import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-item.js';
import '@vaadin/vaadin-date-picker/src/vaadin-date-picker.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-checkbox/src/vaadin-checkbox-group.js';
import '@vaadin/vaadin-checkbox/src/vaadin-checkbox.js';

class NewTicket extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; padding: var(--lumo-space-m);" theme="spacing-xs">
 <vaadin-button style="background-color: #FFFFFF; color: #000000; font-size: 16pt; margin-top: var(--lumo-space-l);" disabled tabindex="">
   Create New Ticket 
 </vaadin-button>
 <vaadin-form-item style="margin: var(--lumo-space-m); ">
  <label slot="label">Title</label>
  <vaadin-text-field class="full-width" required has-value></vaadin-text-field>
 </vaadin-form-item>
 <vaadin-form-item style="width: 100%; margin: var(--lumo-space-m);">
  <label slot="label">Description</label>
  <vaadin-text-field class="full-width" style="padding: var(--lumo-space-xs); padding-right: var(--lumo-space-l); flex-grow: 1;" has-value></vaadin-text-field>
 </vaadin-form-item>
 <vaadin-horizontal-layout theme="spacing-xl" style="margin: var(--lumo-space-m); justify-content: space-around;">
  <vaadin-date-picker label="Date Assigned" placeholder="Default: Today" style="font-size: 12pt;"></vaadin-date-picker>
  <vaadin-date-picker label="Date Due" style="font-size: 12pt;"></vaadin-date-picker>
 </vaadin-horizontal-layout>
 <vaadin-combo-box style="padding-left: var(--lumo-space-m);" label="Assign To"></vaadin-combo-box>
 <vaadin-checkbox-group label="Priority" style="padding: var(--lumo-space-m);">
  <vaadin-checkbox>
    Low 
  </vaadin-checkbox>
  <vaadin-checkbox>
    Medium 
  </vaadin-checkbox>
  <vaadin-checkbox>
    High 
  </vaadin-checkbox>
 </vaadin-checkbox-group>
 <vaadin-checkbox-group label="Status" style="padding: var(--lumo-space-m);">
  <vaadin-checkbox>
    To Do 
  </vaadin-checkbox>
  <vaadin-checkbox>
    In Progress 
  </vaadin-checkbox>
  <vaadin-checkbox>
    Completed 
  </vaadin-checkbox>
 </vaadin-checkbox-group>
 <vaadin-horizontal-layout style="width: 100%; align-self: center;">
  <vaadin-button style="margin: var(--lumo-space-l); border-radius: 10px; background-color: #FED766; color: #000000; box-shadow: var(--lumo-box-shadow-s); font-size: 12pt;" id="cancelButton">
    Cancel 
  </vaadin-button>
  <vaadin-horizontal-layout theme="margin" style="flex-grow: 1;"></vaadin-horizontal-layout>
  <vaadin-button style="margin: var(--lumo-space-l); border-radius: 10px; background-color: #FED766; color: #000000; box-shadow: var(--lumo-box-shadow-s); font-size: 12pt;" id="createButton">
    Create 
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'new-ticket';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(NewTicket.is, NewTicket);
