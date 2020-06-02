package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.templatemodel.TemplateModel;

import org.aspectj.weaver.ast.Not;
import org.vaadin.stefan.fullcalendar.CalendarView;
import org.vaadin.stefan.fullcalendar.CalendarViewImpl;
import org.vaadin.stefan.fullcalendar.FullCalendar;
import org.vaadin.stefan.fullcalendar.Entry;
import org.vaadin.stefan.fullcalendar.FullCalendarBuilder;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.polymertemplate.Id;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;


//added for Gcalendar
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.Events;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * A Designer generated component for the calendar-main template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("calendar-main")
@JsModule("./src/views/calendar-main.js")
@Route(value = "calendar")
public class CalendarMain extends PolymerTemplate<CalendarMain.CalendarMainModel> {

    @Id("header")
	private HeaderComponent header;
	@Id("sidebar")
	private SidebarComponent sidebar;
	@Id("calendarWrapper")
	private HorizontalLayout calendarWrapper;
	
	//Added for Gcalendar
	private static final String APPLICATION_NAME = "Scrumptious";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    
    private static final List<String> SCOPES = Collections.singletonList(CalendarScopes.CALENDAR_READONLY);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";
    
    private Calendar service;
	@Id("viewWrapper")
	private HorizontalLayout viewWrapper;

	/**
     * Creates a new CalendarMain.
     */
    public CalendarMain() {
        // You can initialise any data required for the connected UI components here.
    	
    	//configure the calendar service
    	try {
    		this.setService();
    		
    	}
    	catch(GeneralSecurityException gse) {
    		Notification.show("GSE: " + gse.getMessage());
    	}
    	catch(IOException ioe){
    		Notification.show("IOE: " + ioe.getMessage());
    	}
    	
    	setCalendar(); 
    	header.setLogo();
    	header.setUserButton();
    	sidebar.setNavButtons();
    	sidebar.setCalendarColor();
    }

    /**
     * This model binds properties between CalendarMain and calendar-main
     */
    public interface CalendarMainModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
    
    public void setCalendar() {
    	FullCalendar calendar = FullCalendarBuilder.create().build();

    	calendar.setWeekNumbersVisible(false);
    	calendarWrapper.add(calendar);
    	calendarWrapper.setFlexGrow(1, calendar);

    	// get next 100 events
    	List<Event> events= this.getCalendarEvents(100); 

		for (Event event : events) {
			//Adds upcoming events from Signed In User's Google Calendar to calendar
			
			Entry entry = getVaadinEntry(event);
			
			calendar.addEntry(entry);
		}
		
		
		//select which view to display 
		ComboBox<CalendarView> viewBox = new ComboBox<>("", CalendarViewImpl.values()); 
	   	viewBox.addValueChangeListener(e -> {
    		CalendarView value = e.getValue(); 
    		calendar.changeView(value == null ? CalendarViewImpl.DAY_GRID_MONTH : value); 
	  	});
		    	
		viewBox.setValue(CalendarViewImpl.DAY_GRID_MONTH);
	   	viewBox.getStyle().set("background-color", "#FED766");
    	viewWrapper.add(viewBox);
    	calendar.addDatesRenderedListener(e -> {
	   		LocalDate intervalStart = e.getIntervalStart(); 
    		CalendarView cView = viewBox.getValue(); 
    	});
		    	
    	//set timezone 
	   	calendar.addBrowserTimezoneObtainedListener(e -> {
	  		calendar.setTimezone(e.getTimezone());
    	});

    }
    
    private static Credential getCredentials(final NetHttpTransport httpTrans) throws IOException {
    	/** API Code for Google Calendar 
    	 * 
    	 * @_DO_NOT_MODIFY
    	 **/
    	
        // Load client secrets.
        InputStream in = CalendarMain.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                httpTrans, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }
    
    
    private void setService() throws IOException, GeneralSecurityException{
    	// Google Calendar API configuration
    	final NetHttpTransport httpTrans = GoogleNetHttpTransport.newTrustedTransport();
        this.service = new Calendar.Builder(httpTrans, JSON_FACTORY, getCredentials(httpTrans))
                .setApplicationName(APPLICATION_NAME)
                .build();
    }
    
    
    private List<Event> getCalendarEvents(int numEvents){
    	/**
    	 * @param: this.service: calendar service used to get Logged in User's GCal events
    	 * @param numEvents: number of events to return
    	 * @return: list of (<=numEvents) upcoming events in User's GCal
    	 */
    	
    	// Shows events after time.now
    	DateTime now = new DateTime(System.currentTimeMillis()); 
        Events events = null;
        List<Event> items = new ArrayList<>();
        
		try {
			//Get events
			events = this.service.events().list("primary")
			        .setMaxResults(numEvents)
			        .setTimeMin(now)
			        .setOrderBy("startTime")
			        .setSingleEvents(true)
			        .execute();
			
		} catch (IOException e) {
			Notification.show("Error getting Google Calendar Events.");
			return Collections.emptyList();
		}
		if (events != null) {
			// if events exist
			items = events.getItems();
		}
		return items;
    }
    
    
    private static boolean isAllDay(LocalDateTime start, LocalDateTime end) {
    	/**
    	 * @params: start time and end time of an event
    	 * @return: if the event spans all day or multiple days (duration is divisible by 86400 seconds)
    	 * */
    	return start.until(end, ChronoUnit.SECONDS) % 86400 == 0;
    }

    
    private static String randomColor() {
    	/** Generates a random color string to be used when populating calendar.
    	 * @return A CSS color string from a random selection
    	 **/
    	
    	// Add or remove string items of this list to update color combinations
    	Random rand = new Random();
    	ArrayList<String> colors = new ArrayList<>();
    	
    	colors.add("red"); colors.add("orange"); colors.add("Gold");
    	colors.add("green"); colors.add("blue"); colors.add("purple");
    	colors.add("MediumOrchid"); colors.add("DarkTurquoise"); colors.add("crimson");
    	colors.add("silver"); colors.add("MediumAquaMarine");
    	colors.add("MidnightBlue"); colors.add("#FF7F50");
    	
    	// pick a random element of colors
    	int choice = (int)(rand.nextInt() * colors.size());
    	
    	return colors.get(choice);
    }
    
    
    private static LocalDateTime parseLDTFromGoogleEvent(EventDateTime dt) throws NoSuchFieldException {
    	/**
    	 * @param Google EventDateTime
    	 * @return LocalDateTime used by Vaadin FullCalendar
    	 * @throws an ~exception~ if the input could not be parsed
    	 */
    	DateTime edt;
    	String edtString;
    	
    	if ((edt = dt.getDateTime()) != null) {
			//DateTime: event has a start time and end time
			edtString = edt.toString();
			return LocalDateTime.parse(edtString, DateTimeFormatter.ISO_ZONED_DATE_TIME);
			
		}else if ((edt = dt.getDate()) != null) {
			//Date: event is all day/multiple days
			//AtStartOfDay operator creates LocalDateTime starting at beginning of Date
			edtString = edt.toString();
			return LocalDate.parse(edtString, DateTimeFormatter.ISO_DATE).atStartOfDay();
			
		}else {
			// Error - Don't show the event, log an error message
			throw new NoSuchFieldException("Error parsing start-date for event ");
		}
    }
    
    private static Entry getVaadinEntry(Event event) {
    	/**
    	 * @param event: a google calendar event
    	 * @return a Vaadin calendar entry to be inserted into calendar
    	 * */
    	String title = event.getSummary();
    	Entry entry = new Entry(String.valueOf(title.hashCode()));
    	
    	String color = randomColor();
    	
    	boolean eventIsAllDay;
    	LocalDateTime startLDT;
    	LocalDateTime endLDT;
    	
		//Event start
		EventDateTime start = event.getStart();
		
		try {
			startLDT = parseLDTFromGoogleEvent(start);
		}catch (NoSuchFieldException e) {
			//Should add a log entry for an error
			return null;
		}	
		
		//Event end
		EventDateTime end = event.getEnd();
		
		try {
			endLDT = parseLDTFromGoogleEvent(end);
		}catch (NoSuchFieldException e) {
			//Should add a log entry for an error
			return null;
		}
		
		eventIsAllDay = isAllDay(startLDT, endLDT);
		String description = event.getDescription();
		
		//Populate entry
		entry.setAllDay(eventIsAllDay);
    	entry.setColor(color);
    	entry.setTitle(title);
    	entry.setEnd(endLDT);
    	entry.setStart(startLDT);
    	entry.setDescription(description);
    	
    	
    	return entry;
    }

}
