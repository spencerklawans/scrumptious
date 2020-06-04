package com.scrumptious.logic.ui;

import com.vaadin.flow.templatemodel.TemplateModel;

import org.vaadin.stefan.fullcalendar.CalendarView;
import org.vaadin.stefan.fullcalendar.CalendarViewImpl;
import org.vaadin.stefan.fullcalendar.FullCalendar;
import org.vaadin.stefan.fullcalendar.Entry;
import org.vaadin.stefan.fullcalendar.FullCalendarBuilder;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.scrumptious.logic.backend.controller.GoogleCalendarController;
import java.time.LocalDate;
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
	
	
    
   
	@Id("viewWrapper")
	private HorizontalLayout viewWrapper;

	/**
     * Creates a new CalendarMain.
     */
    public CalendarMain() {
        // You can initialise any data required for the connected UI components here.
    	
    	
    	
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
    	GoogleCalendarController gcc = new GoogleCalendarController();

    	calendar.setWeekNumbersVisible(false);
    	calendarWrapper.add(calendar);
    	calendarWrapper.setFlexGrow(1, calendar);

    	// get next 100 events
    	List<Entry> entries= gcc.getCalendarEntries(100); 

		for (Entry entry : entries) {
			//Adds upcoming events from Signed In User's Google Calendar to calendar
			
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
	   	calendar.addBrowserTimezoneObtainedListener(e ->
	  		calendar.setTimezone(e.getTimezone()));


    }
    
    
    
    
    
    
    
    
    
    
    
    
    

}
