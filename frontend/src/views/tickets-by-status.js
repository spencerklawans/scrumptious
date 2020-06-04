import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class TicketsByStatus extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; font-family: Roboto; font-style: normal; font-weight: bold; font-size: 48px; line-height: 56px; color: #000000; flex-direction: column; align-items: flex-start;">
 <vaadin-button style="background-color: #FFFFFF; color: #000000; font-size: 16pt; align-self: flex-start; margin-left: var(--lumo-space-m); margin-top: var(--lumo-space-l); font-weight: bold;" disabled tabindex="">
   Tickets 
 </vaadin-button>
 <vaadin-horizontal-layout style="height: 100%; font-style: normal; font-weight: 500; font-size: 36px; line-height: 42px; color: #FFFFFF; align-self: flex-start; width: 100%; justify-content: space-around; flex-grow: 0; flex-direction: row;">
  <vaadin-vertical-layout style="background: #00758B; border: 1px solid rgba(0, 0, 0, 0.5); box-sizing: border-box; border-radius: 10px; margin-left: var(--lumo-space-xl); margin-right: var(--lumo-space-xl); justify-content: flex-start; height: 100%; margin-top: var(--lumo-space-l); margin-bottom: var(--lumo-space-l); width: 30%; flex-direction: column; align-items: flex-start;" id="todo">
   <vaadin-button style="color: #FFFFFF; background-color: #00758B; font-size: 18pt; margin-bottom: auto; align-self: flex-start;" disabled tabindex="">
     To Do 
   </vaadin-button>
   <vaadin-vertical-layout id="todoWrapper" style="width: 100%; flex-grow: 1; flex-shrink: 1; justify-content: flex-start; padding: var(--lumo-space-s); flex-direction: column; align-items: flex-start;"></vaadin-vertical-layout>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout style="height: 100%; background: #009FB7; border: 1px solid rgba(0, 0, 0, 0.5); box-sizing: border-box; box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25); border-radius: 10px; font-family: Roboto; font-style: normal; font-weight: 500; font-size: 36px; line-height: 42px; margin: var(--lumo-space-l); margin-left: var(--lumo-space-xl); margin-right: var(--lumo-space-xl); width: 30%; flex-direction: column; align-items: flex-start; justify-content: flex-start;" id="inProgress">
   <vaadin-button style="color: #FFFFFF; background-color: #009FB7; font-size: 18pt; margin-bottom: auto; align-self: flex-start;">
     In Progress 
   </vaadin-button>
   <vaadin-vertical-layout id="progressWrapper" style="width: 100%; flex-grow: 1; justify-content: flex-start; padding: var(--lumo-space-s); flex-direction: column; align-items: flex-start;"></vaadin-vertical-layout>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout style="background: #31BCCD; border: 1px solid rgba(0, 0, 0, 0.5); box-sizing: border-box; box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25); border-radius: 10px; font-family: Roboto; font-style: normal; font-weight: 500; font-size: 36px; line-height: 42px; margin: var(--lumo-space-l); height: 100%; margin-right: var(--lumo-space-xl); margin-left: var(--lumo-space-xl); width: 30%; flex-direction: column; align-items: flex-start; justify-content: flex-start;" id="completed">
   <vaadin-button style="color: #FFFFFF; background-color: #31BCCD; font-size: 18pt; margin-bottom: auto; align-self: flex-start;">
     Completed 
   </vaadin-button>
   <vaadin-vertical-layout id="completedWrapper" style="width: 100%; flex-grow: 1; justify-content: flex-start; padding: var(--lumo-space-s); flex-direction: column; align-items: flex-start;"></vaadin-vertical-layout>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="flex-shrink: 0; margin: var(--lumo-space-m); width: 100%; justify-content: space-between; padding: var(--lumo-space-xs);">
  <vaadin-horizontal-layout id="radioWrapper" style="flex-grow: 1;"></vaadin-horizontal-layout>
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
