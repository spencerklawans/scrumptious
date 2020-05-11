import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-item.js';
import '@vaadin/vaadin-date-picker/src/vaadin-date-picker.js';
import '@vaadin/vaadin-checkbox/src/vaadin-checkbox-group.js';
import '@vaadin/vaadin-checkbox/src/vaadin-checkbox.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';

class NewTicket extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; padding: var(--lumo-space-m);">
 Create New Ticket
 <vaadin-form-item style="margin: var(--lumo-space-m);">
  <label slot="label">Title</label>
  <vaadin-text-field class="full-width" required has-value></vaadin-text-field>
 </vaadin-form-item>
 <vaadin-form-item style="width: 100%; margin: var(--lumo-space-m);">
  <label slot="label">Description</label>
  <vaadin-text-field class="full-width" style="padding: var(--lumo-space-xs);" has-value></vaadin-text-field>
 </vaadin-form-item>
 <vaadin-horizontal-layout theme="spacing" style="margin: var(--lumo-space-m);">
  <vaadin-date-picker label="Date Assigned" placeholder="Default: Today"></vaadin-date-picker>
  <vaadin-date-picker label="Date Due"></vaadin-date-picker>
 </vaadin-horizontal-layout>
 <vaadin-checkbox-group style="padding: var(--lumo-space-m);" label="Assign to">
  <vaadin-checkbox>
   Ryan
  </vaadin-checkbox>
  <vaadin-checkbox>
   Kira
  </vaadin-checkbox>
  <vaadin-checkbox>
   Galen
  </vaadin-checkbox>
  <vaadin-checkbox>
   Spencer
  </vaadin-checkbox>
 </vaadin-checkbox-group>
 <vaadin-combo-box></vaadin-combo-box>
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
   To-Do 
  </vaadin-checkbox>
  <vaadin-checkbox>
   In Progress
  </vaadin-checkbox>
  <vaadin-checkbox>
   Completed
  </vaadin-checkbox>
 </vaadin-checkbox-group>
 <vaadin-horizontal-layout style="width: 100%; align-self: center;">
  <vaadin-button style="margin: var(--lumo-space-l);">
   Cancel
  </vaadin-button>
  <vaadin-horizontal-layout theme="margin" style="flex-grow: 1;"></vaadin-horizontal-layout>
  <vaadin-button style="margin: var(--lumo-space-l);">
    Create Ticket 
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
