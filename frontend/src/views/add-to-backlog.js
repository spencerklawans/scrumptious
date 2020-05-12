import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-item.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-checkbox/src/vaadin-checkbox-group.js';
import '@vaadin/vaadin-list-box/src/vaadin-list-box.js';
import '@vaadin/vaadin-radio-button/src/vaadin-radio-group.js';
import '@vaadin/vaadin-radio-button/src/vaadin-radio-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class AddToBacklog extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; padding: var(--lumo-space-m);">
  Add to Backlog 
 <vaadin-form-item>
  <label slot="label">Title</label>
  <vaadin-text-field class="full-width" has-value></vaadin-text-field>
 </vaadin-form-item>
 <vaadin-form-item>
  <label slot="label">Description</label>
  <vaadin-text-field class="full-width" value="(optional)" has-value></vaadin-text-field>
 </vaadin-form-item>
 <vaadin-list-box>
  <b>Priority</b>
 </vaadin-list-box>
 <vaadin-radio-group theme="horizontal" value="on">
  <vaadin-radio-button checked>
   <b>Low</b>
   <div>
    Non-vital work
   </div>
  </vaadin-radio-button>
  <vaadin-radio-button checked>
   <b>Medium</b>
   <div>
    Essential
   </div>
  </vaadin-radio-button>
  <vaadin-radio-button checked>
   <b>High</b>
   <div>
    Essential and time-sensitive
   </div>
  </vaadin-radio-button>
 </vaadin-radio-group>
 <vaadin-checkbox-group></vaadin-checkbox-group>
 <vaadin-horizontal-layout style="width: 100%;">
  <vaadin-button style="flex-shrink: 0;">
   Cancel
  </vaadin-button>
  <vaadin-horizontal-layout theme="spacing" style="flex-grow: 0; width: 100%; flex-shrink: 1;"></vaadin-horizontal-layout>
  <vaadin-button style="flex-shrink: 0;">
   Add
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'add-to-backlog';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(AddToBacklog.is, AddToBacklog);
