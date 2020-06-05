package com.scrumptious.logic.backend.controller;

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

import org.vaadin.stefan.fullcalendar.Entry;

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
import com.scrumptious.logic.backend.entity.Ticket;
import com.scrumptious.logic.ui.CalendarMain;
import com.vaadin.flow.component.notification.Notification;



public class GoogleCalendarController {
	
	private static final String APPLICATION_NAME = "Scrumptious";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    
    private static final List<String> SCOPES = Collections.singletonList(CalendarScopes.CALENDAR_EVENTS);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";
    
    private Calendar service;
    private TicketController tc;
    private Long pid = null;
    
    private static Random rand = new Random();
    
    
    public GoogleCalendarController() {
    	try {
    		this.setService();
    		
    	}
    	catch(GeneralSecurityException|IOException gse) {
    		Notification.show("Error getting data from Google Calendar. Refresh and try again.");
    	}
    	
    }
    
    public GoogleCalendarController(TicketController tc, Long projectId) {
    	this.tc = tc;
    	this.pid = projectId;
    	
    	//configure the calendar service
    	try {
    		this.setService();
    		
    	}
    	catch(GeneralSecurityException|IOException gse) {
    		Notification.show("Error getting data from Google Calendar and Project. Refresh and try again.");
    	}
    }
    
    public boolean hasProject() {
    	/**
    	 * @return if the instance has a PID associated with it
    	 */
    	return this.pid != null;
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
    	/**
    	 * @return Nothing. set service as required by Google Calendar API
    	 * 
    	 * Google Calendar API configuration
    	 */
    	final NetHttpTransport httpTrans = GoogleNetHttpTransport.newTrustedTransport();
        this.service = new Calendar.Builder(httpTrans, JSON_FACTORY, getCredentials(httpTrans))
                .setApplicationName(APPLICATION_NAME)
                .build();
    }
    
    
    public List<Entry> getCalendarEntries(int numEntries){
    	/**
    	 * @param: numEntries: number of calendar entries to display.
    	 * @return: A List of Vaadin Entries for insertion to calendar
    	 * 
    	 * A Calendar-Main facing function for querying Calendar API for Calendar entries and 
    	 * returning them in Vaadin-friendly format.
    	 */
    	
    	List<Entry> entries = new ArrayList<>();
    	
    	List<Event> calendarEvents = getCalendarEvents(numEntries);
    	
    	for (Event event: calendarEvents) {
    		Entry e = getVaadinEntry(event);
    		
    		entries.add(e);
    		
    	}
    	
    	return entries;
    }
    
    public List<Entry> getTicketEntries(){
    	/**
    	 * @return List of Vaadin Entries associated with the Tickets in 
    	 * 		current project's list of tickets
    	 */
    	
    	List<Entry> entries = new ArrayList<>();
    	
    	// Get tickets associated with current project
    	List<Ticket> tickets = this.tc.findTicketsByPid(this.pid);
    	
    	for (Ticket t : tickets) {
    		try {
    			Event e = getEventFromTicket(t);
    			
    			Entry entry = getVaadinEntry(e);
        		entries.add(entry);
        		
    		} 
    		
    		catch(IOException e) {
    			;
    		}
    			
    	}
    	return entries;
    }
    
    public Event getEventFromTicket(Ticket ticket) throws IOException {
    	/**
    	 * @param ticket: a ticket to be added to user's calendar
    	 * @return Google Calendar Event
    	 * 
    	 * Note: this is a round-about way of adding tickets that is more portable for 
    	 * future addition of write-to-GCal functionality
    	 */
    	
    	Event event = new Event();
    	
    	event.setSummary("Ticket: " + ticket.getTitle());
    	event.setDescription(ticket.getDescription() + 
    			"\n\tStatus: " + ticket.getStatus().toString() + 
    			"\n\tPriority: " + ticket.getPriority().toString());
    	
    	LocalDateTime startDateTime = ticket.getDueDate().atStartOfDay();
    	EventDateTime start = parseGoogleEDTFromLDT(startDateTime);
    	event.setStart(start);
    	
    	LocalDateTime endDateTime = ticket.getDueDate().atStartOfDay();
    	EventDateTime end = parseGoogleEDTFromLDT(endDateTime);
    	event.setEnd(end);
    	
    	return event;
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
			
		} catch (IOException|NullPointerException e) {
			Notification.show("Error getting Google Calendar Events.");
		}
		finally {
			if (events != null) {
				// if events exist
				items = events.getItems();
			}
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
    	ArrayList<String> colors = new ArrayList<>();
    	
    	colors.add("red"); colors.add("orange"); colors.add("Gold");
    	colors.add("green"); colors.add("blue"); colors.add("purple");
    	colors.add("MediumOrchid"); colors.add("DarkTurquoise"); colors.add("crimson");
    	colors.add("silver"); colors.add("MediumAquaMarine");
    	colors.add("MidnightBlue"); colors.add("#FF7F50");
    	
    	// pick a random element of colors
    	int choice = (rand.nextInt(colors.size()));
    	
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
    
    private static EventDateTime parseGoogleEDTFromLDT(LocalDateTime ldt) {
    	/**
    	 * @param a LocalDateTime
    	 * @return a Google Calendar API EventDateTime for creation of Google Calendar Events
    	 */
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
    	String date = ldt.format(formatter);
    	
    	return new EventDateTime().setDateTime(new DateTime(date));
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
