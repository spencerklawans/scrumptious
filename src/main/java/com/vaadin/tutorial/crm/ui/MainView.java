package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.tutorial.crm.backend.entity.Company;
import com.vaadin.tutorial.crm.backend.entity.Contact;
import com.vaadin.tutorial.crm.backend.service.ContactService;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;

/**
 * A Designer generated component for the main-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("main-view")
@JsModule("./src/views/main-view.js")

public class MainView extends PolymerTemplate<MainView.MainViewModel> {

    @Id("filterText")
    private TextField filterText;
    @Id("addContactButton")
    private Button addContactButton;
    @Id("grid")
    private Grid<Contact> grid;

    private ContactService contactService;
    /**
     * Creates a new MainView.
     */

    public MainView(ContactService contactService) {
        this.contactService = contactService;
        grid.addColumn(Contact::getFirstName).setHeader("First name");
        grid.addColumn(Contact::getLastName).setHeader("Last name");
        grid.addColumn(Contact::getEmail).setHeader("Email");
        grid.addColumn(Contact::getStatus).setHeader("Status");
        grid.addColumn(contact -> { 
            Company company = contact.getCompany();
            return company == null ? "-" : company.getName();
        }).setHeader("Company");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        grid.setItems(contactService.findAll());
    }

    /**
     * This model binds properties between MainView and main-view
     */
    public interface MainViewModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
