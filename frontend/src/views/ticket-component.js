import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class TicketComponent extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="border: 2px solid #000000; background-color: #FFFFFF; justify-content: space-between; margin: var(--lumo-space-xs); align-content: flex-start; align-items: flex-start; flex-direction: column; flex-wrap: wrap;">
 <vaadin-button id="title" style="width: 100%; background-color: rgba(255, 255, 255); font-size: 14pt; flex-grow: 1; color: #000000; font-weight: bold; align-self: center;" disabled tabindex=""></vaadin-button>
 <vaadin-horizontal-layout style="align-self: center; align-items: flex-start; justify-content: flex-start; flex-wrap: wrap; align-content: flex-start;">
  <vaadin-button style="background-color: #FFFFFF; color: #000000; font-size: 12pt; font-weight: bold;" disabled tabindex="">
    Due : 
  </vaadin-button>
  <vaadin-button id="dateButton" style="background-color: #FFFFFF; color: #000000; font-size: 12pt;" disabled tabindex="">
    Button 
  </vaadin-button>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="width: 100%; justify-content: space-between; padding-right: var(--lumo-space-m); padding-left: var(--lumo-space-m); align-items: flex-start; flex-direction: row; align-content: flex-start;">
  <vaadin-vertical-layout style="flex-grow: 1; flex-wrap: wrap; align-content: flex-start; overflow: auto; flex-direction: column; align-items: flex-start; justify-content: flex-start;">
   <vaadin-button id="assignedUser" style="background-color: #FFFFFF; font-size: 10pt; color: #000000; flex-grow: 1; width: 100%; height: 100%; align-self: flex-start;" disabled tabindex=""></vaadin-button>
  </vaadin-vertical-layout>
  <vaadin-button id="priority" style="font-size: 10pt; color: #000000; background-color: #FFFFFF; font-weight: bold; flex-grow: 0;" tabindex=""></vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'ticket-component';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(TicketComponent.is, TicketComponent);
