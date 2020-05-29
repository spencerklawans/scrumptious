import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@polymer/iron-icon/iron-icon.js';

class TicketComponent extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="border: 2px solid #000000; background-color: #FFFFFF; justify-content: space-between;">
 <vaadin-button id="title" style="width: 100%; background-color: rgba(255, 255, 255); font-size: 14pt; flex-grow: 0;"></vaadin-button>
 <vaadin-horizontal-layout style="width: 100%; justify-content: space-between; padding-right: var(--lumo-space-m); padding-left: var(--lumo-space-m);">
  <vaadin-button id="assignedUser" style="background-color: #FFFFFF; font-size: 8pt;" disabled>
   <iron-icon icon="lumo:user" slot="prefix" style="color: #FED766;"></iron-icon>
  </vaadin-button>
  <vaadin-button id="priority" style="font-size: 8pt; color: #000000; background-color: #FFFFFF;" disabled></vaadin-button>
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
