import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-radio-button/src/vaadin-radio-group.js';
import '@vaadin/vaadin-radio-button/src/vaadin-radio-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class TicketsByStatus extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; font-family: Roboto;
font-style: normal;
font-weight: bold;
font-size: 48px;
line-height: 56px;

color: #000000;">
 <vaadin-button style="background-color: #FFFFFF; color: #000000; font-size: 16pt; align-self: flex-start; margin-left: var(--lumo-space-m); margin-top: var(--lumo-space-l);" disabled tabindex="">
   Tickets 
 </vaadin-button>
 <vaadin-horizontal-layout style="height: 100%; font-style: normal; font-weight: 500; font-size: 36px; line-height: 42px; color: #FFFFFF; align-self: center; width: 100%;">
  <vaadin-vertical-layout style="height: 100%; width: 33%; background: #00758B; border: 1px solid rgba(0, 0, 0, 0.5); box-sizing: border-box; border-radius: 10px; flex-direction: column; margin: var(--lumo-space-l); margin-left: var(--lumo-space-xl); margin-right: var(--lumo-space-xl);" id="todo">
   <vaadin-button style="color: #FFFFFF; background-color: #00758B; font-size: 18pt; margin-bottom: auto;" disabled tabindex="">
     To Do 
   </vaadin-button>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout style="height: 100%; width: 33%; background: #009FB7; border: 1px solid rgba(0, 0, 0, 0.5); box-sizing: border-box; box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25); border-radius: 10px; flex-direction: column-reverse; font-family: Roboto; font-style: normal; font-weight: 500; font-size: 36px; line-height: 42px; flex-direction: column-reverse; margin: var(--lumo-space-l); margin-left: var(--lumo-space-xl); margin-right: var(--lumo-space-xl);" id="inProgress">
   <vaadin-button style="color: #FFFFFF; background-color: #009FB7; font-size: 18pt; margin-bottom: auto;">
     In Progress 
   </vaadin-button>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout style="background: #31BCCD; border: 1px solid rgba(0, 0, 0, 0.5); box-sizing: border-box; box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25); border-radius: 10px; flex-direction: column-reverse; font-family: Roboto; font-style: normal; font-weight: 500; font-size: 36px; line-height: 42px; flex-direction: column-reverse; margin: var(--lumo-space-l); width: 33%; height: 100%; margin-right: var(--lumo-space-xl); margin-left: var(--lumo-space-xl);" id="completed">
   <vaadin-button style="color: #FFFFFF; background-color: #31BCCD; font-size: 18pt; margin-bottom: auto;">
     Completed 
   </vaadin-button>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="flex-shrink: 0; margin: var(--lumo-space-m); width: 100%; justify-content: space-between; padding: var(--lumo-space-xs);">
  <vaadin-radio-group label="Viewing By" value="on" style="padding-top: var(--lumo-space-s); align-self: flex-end; margin-top: var(--lumo-space-s);">
   <vaadin-radio-button checked>
     My Tickets 
   </vaadin-radio-button>
   <vaadin-radio-button checked>
     Whole Project 
   </vaadin-radio-button>
   <vaadin-radio-button checked tabindex="-1">
     Custom 
   </vaadin-radio-button>
  </vaadin-radio-group>
  <vaadin-horizontal-layout style="align-self: flex-end; margin-right: var(--lumo-space-xl); padding-right: var(--lumo-space-s); padding: var(--lumo-space-s); align-items: center;">
   <vaadin-button style="width: 100%; height: 50%; border-radius: 10px; background-color: #FED766; color: #000000; box-shadow: var(--lumo-box-shadow-s); font-size: 12pt;" id="createButton">
     Create New Ticket 
   </vaadin-button>
  </vaadin-horizontal-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'tickets-by-status';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(TicketsByStatus.is, TicketsByStatus);
