import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-item.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-date-picker/src/vaadin-date-picker.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';
import 'multiselect-combo-box/src/multiselect-combo-box.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import './header-component.js';

class EditTicket extends PolymerElement {

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
  <header-component style="width: 100%;"></header-component>
 </vaadin-horizontal-layout>
 <vaadin-vertical-layout style="padding-right: var(--lumo-space-m); padding-left: var(--lumo-space-m);">
  <vaadin-button style="background-color: #FFFFFF; color: #000000; font-size: 16pt; margin-top: var(--lumo-space-l);" disabled>
   Edit Ticket
  </vaadin-button>
  <vaadin-form-item style="margin: var(--lumo-space-m);">
   <label slot="label">Title</label>
   <vaadin-text-field id="title" required invalid has-value></vaadin-text-field>
  </vaadin-form-item>
  <vaadin-form-item style="width: 100%; margin: var(--lumo-space-m);">
   <label slot="label">Description</label>
   <vaadin-text-field id="description" class="full-width" style="padding: var(--lumo-space-xs); padding-right: var(--lumo-space-l); flex-grow: 1;" theme="spacing-xl" has-value></vaadin-text-field>
  </vaadin-form-item>
  <vaadin-horizontal-layout style="margin: var(--lumo-space-m); justify-content: space-around;" theme="spacing-xl">
   <vaadin-date-picker id="dateAssigned" label="Date Assigned" placeholder="Default: Today"></vaadin-date-picker>
   <vaadin-date-picker id="dateDue" label="Date Due"></vaadin-date-picker>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout style="margin: var(--lumo-space-m); width: 100%;" theme="spacing-xl">
   <vaadin-combo-box id="status" label="Status"></vaadin-combo-box>
   <vaadin-combo-box id="priority" label="Priority"></vaadin-combo-box>
   <multiselect-combo-box id="addAssignees" style="margin-top: var(--lumo-space-s);" label="Add Assignees"></multiselect-combo-box>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout style="width: 100%; align-self: center;">
   <vaadin-button id="cancelButton" style="margin: var(--lumo-space-l); border-radius: 10px; background-color: #FED766; color: #000000; box-shadow: var(--lumo-box-shadow-s); font-size: 12pt;">
    Cancel
   </vaadin-button>
   <vaadin-horizontal-layout style="flex-grow: 1;"></vaadin-horizontal-layout>
   <vaadin-button id="updateButton" style="margin: var(--lumo-space-l); border-radius: 10px; background-color: #FED766; color: #000000; box-shadow: var(--lumo-box-shadow-s); font-size: 12pt;">
    Update
   </vaadin-button>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
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
