import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import './header-component.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-item.js';
import '@vaadin/vaadin-date-picker/src/vaadin-date-picker.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';

class AddProject extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout style="width: 100%; height: 10%;">
  <header-component style="flex-grow: 1; flex-shrink: 0;" id="header"></header-component>
 </vaadin-horizontal-layout>
 <vaadin-vertical-layout style="width: 100%; height: 90%; background-color: rgba(210, 209, 213);">
  <vaadin-button style="background-color: rgba(210, 209, 213, 0.75); color: #000000; font-size: 16pt; font-weight: bold; align-self: flex-start; margin-left: var(--lumo-space-m); margin-top: var(--lumo-space-l);" disabled tabindex="">
    Create New Project 
  </vaadin-button>
  <vaadin-form-item style="margin-left: var(--lumo-space-xl); width: 80%; margin-top: var(--lumo-space-s); margin-bottom: var(--lumo-space-l);" id="nameForm">
   <label slot="label">Name</label>
   <vaadin-text-field style="width: 100%;" id="nameField"></vaadin-text-field>
  </vaadin-form-item>
  <vaadin-form-item style="margin-left: var(--lumo-space-xl); width: 80%; margin-bottom: var(--lumo-space-l);" id="descriptionForm">
   <vaadin-text-field style="width: 100%;" id="descriptionField"></vaadin-text-field>
   <label slot="label">Description</label>
  </vaadin-form-item>
  <vaadin-date-picker label="Date Created" placeholder="Default: Today" style="margin-left: var(--lumo-space-xl); margin-bottom: var(--lumo-space-l);" id="datePicked"></vaadin-date-picker>
  <vaadin-form-item style="margin-bottom: var(--lumo-space-xl); margin-left: var(--lumo-space-xl); width: 80%;" id="inviteForm">
   <label slot="label" style="flex-grow: 1; flex-shrink: 0; width: 100%;">Invite Team Members </label>
   <vaadin-text-field style="margin-left: var(--lumo-space-m); width: 100%;" id="teamField"></vaadin-text-field>
  </vaadin-form-item>
  <vaadin-horizontal-layout style="width: 100%; justify-content: space-between; margin-top: var(--lumo-space-xl);">
   <vaadin-button style="margin: var(--lumo-space-l); border-radius: 10px; background-color: #FED766; color: #000000; box-shadow: var(--lumo-box-shadow-s); font-size: 12pt;" id="cancelButton">
     Cancel 
   </vaadin-button>
   <vaadin-button style="margin: var(--lumo-space-l); border-radius: 10px; background-color: #FED766; color: #000000; box-shadow: var(--lumo-box-shadow-s); font-size: 12pt;" id="createButton">
     Create 
   </vaadin-button>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'add-project';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(AddProject.is, AddProject);
