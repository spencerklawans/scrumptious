import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-item.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-checkbox/src/vaadin-checkbox-group.js';
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
<vaadin-vertical-layout style="width: 100%; height: 100%; padding: var(--lumo-space-l);">
 <vaadin-button style="background-color: #FFFFFF; color: #000000; font-size: 16pt; align-self: flex-start; flex-grow: 0; margin: var(--lumo-space-xs); font-weight: bold;" disabled tabindex="">
   Add to Backlog 
 </vaadin-button>
 <vaadin-form-item style="margin: var(--lumo-space-m); align-self: flex-start;">
  <label slot="label" style="font-size: 12pt; ">Title</label>
  <vaadin-text-field class="full-width" has-value style="flex-grow: 1;" required id="title"></vaadin-text-field>
 </vaadin-form-item>
 <vaadin-form-item style="margin: var(--lumo-space-m);">
  <label slot="label" style="font-size: 12pt;">Description</label>
  <vaadin-text-field class="full-width" has-value placeholder="(optional)" id="description"></vaadin-text-field>
 </vaadin-form-item>
 <vaadin-button style="background-color: #FFFFFF; color: hsla(214, 42%, 18%, 0.72); margin: var(--lumo-space-xs);" disabled tabindex="">
   Priority 
 </vaadin-button>
 <vaadin-radio-group theme="horizontal" value="on" style="padding-left: var(--lumo-space-xl);" id="prioritySelection">
  <vaadin-radio-button checked style="margin: var(--lumo-space-xs);" id="lowPriority">
   <b>Low</b>
   <div>
     Non-vital work 
   </div>
  </vaadin-radio-button>
  <vaadin-radio-button checked style="margin: var(--lumo-space-xs);" tabindex="-1" id="medPriority">
   <b>Medium</b>
   <div>
     Essential 
   </div>
  </vaadin-radio-button>
  <vaadin-radio-button checked id="highPriority" tabindex="-1">
   <b>High</b>
   <div>
     Essential and time-sensitive 
   </div>
  </vaadin-radio-button>
 </vaadin-radio-group>
 <vaadin-checkbox-group></vaadin-checkbox-group>
 <vaadin-horizontal-layout style="width: 100%; padding: var(--lumo-space-s);">
  <vaadin-button style="flex-shrink: 0; border-radius: 10px; background-color: #FED766; color: #000000; box-shadow: var(--lumo-box-shadow-s); font-size: 12pt;" id="cancelButton">
    Cancel 
  </vaadin-button>
  <vaadin-horizontal-layout theme="spacing" style="flex-grow: 0; width: 100%; flex-shrink: 1;"></vaadin-horizontal-layout>
  <vaadin-button style="flex-shrink: 0; border-radius: 10px; background-color: #FED766; color: #000000; box-shadow: var(--lumo-box-shadow-s); font-size: 12pt;" id="addButton">
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
