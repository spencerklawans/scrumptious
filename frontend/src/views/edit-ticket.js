import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-item.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-date-picker/src/vaadin-date-picker.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class EditTicket extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="padding-right: var(--lumo-space-m); padding-left: var(--lumo-space-m); width: 100%; background-color: #FFFFFF; height: 100%; align-items: flex-start; justify-content: flex-start; flex-wrap: wrap; align-content: flex-start; flex-direction: row;">
 <vaadin-form-item style="margin: var(--lumo-space-m);">
  <label slot="label">Title</label>
  <vaadin-text-field id="title" invalid has-value></vaadin-text-field>
 </vaadin-form-item>
 <vaadin-form-item style="width: 100%; margin: var(--lumo-space-m);">
  <label slot="label">Description</label>
  <vaadin-text-field id="description" class="full-width" style="padding: var(--lumo-space-xs); padding-right: var(--lumo-space-l); flex-grow: 1;" theme="spacing-xl" has-value></vaadin-text-field>
 </vaadin-form-item>
 <vaadin-horizontal-layout style="margin: var(--lumo-space-m); justify-content: space-around; flex-direction: row; flex-wrap: wrap; align-content: flex-start;" theme="spacing-xl">
  <vaadin-date-picker id="dateAssigned" label="Date Assigned" placeholder="Default: Today" style="align-self: flex-start;"></vaadin-date-picker>
  <vaadin-date-picker id="dateDue" label="Date Due" style="align-self: flex-start;"></vaadin-date-picker>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="margin: var(--lumo-space-m); width: 100%; flex-wrap: wrap; justify-content: flex-start; align-items: flex-start; align-content: flex-start;" theme="spacing-xl" id="assigneeWrapper">
  <vaadin-combo-box id="status" label="Status"></vaadin-combo-box>
  <vaadin-combo-box id="priority" label="Priority"></vaadin-combo-box>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="width: 100%; align-self: center; align-content: flex-start;">
  <vaadin-button id="cancelButton" style="margin: var(--lumo-space-l); border-radius: 10px; background-color: #FED766; color: #000000; box-shadow: var(--lumo-box-shadow-s); font-size: 12pt;">
    Cancel 
  </vaadin-button>
  <vaadin-horizontal-layout style="flex-grow: 1;"></vaadin-horizontal-layout>
  <vaadin-button id="updateButton" style="margin: var(--lumo-space-l); border-radius: 10px; background-color: #FED766; color: #000000; box-shadow: var(--lumo-box-shadow-s); font-size: 12pt;">
    Update 
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'edit-ticket';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(EditTicket.is, EditTicket);
