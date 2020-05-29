package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.templatemodel.TemplateModel;

import org.aspectj.weaver.ast.Not;
import org.vaadin.stefan.fullcalendar.FullCalendar;
import org.vaadin.stefan.fullcalendar.FullCalendarBuilder;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
//import com.vaadin.tutorial.crm.ui.HeaderComponent;
import com.vaadin.flow.component.polymertemplate.Id;
//import com.vaadin.tutorial.crm.ui.SidebarComponent;
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
import com.google.api.services.calendar.model.Events;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    //TODO: Make new credentials.json
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";
    
    private Calendar service;

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
    	
    }

    /**
     * This model binds properties between CalendarMain and calendar-main
     */
    public interface CalendarMainModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
    
    public void setCalendar() {
    	FullCalendar calendar = FullCalendarBuilder.create().build();
    	calendarWrapper.add(calendar);
    	calendarWrapper.setFlexGrow(1, calendar);
    	
    	List<Event> events= this.getCalendarEvents(10); // get next 10 events
		
		for (Event event : events) {
			// Temporarily show via notification, the events upcoming
			//Replace with populate calendar
			
			Notification.show("Upcoming event: " + event.getDescription());
		}
    }
    
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = CalendarMain.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }
    
    private void setService() throws IOException, GeneralSecurityException{
    	//GCalendar
    	final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        this.service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
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
        List<Event> items = new ArrayList<Event>();
        
		try {
			//Get events
			events = this.service.events().list("primary")
			        .setMaxResults(numEvents)
			        .setTimeMin(now)
			        .setOrderBy("startTime")
			        .setSingleEvents(true)
			        .execute();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Notification.show("IOE GCE: "+ e.getMessage());
		}
		if (events != null) {
			// if events exist
			items = events.getItems();
		}
		return items;
    }
    
}
