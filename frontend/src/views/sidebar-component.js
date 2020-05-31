import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

class SidebarComponent extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout class="sidebar" style="background-color: rgba(210, 209, 213); margin-top: auto; justify-content: center; padding: var(--lumo-space-xs); align-items: flex-start; flex-shrink: 0; height: 100%;">
 <vaadin-button style="width: 100%; background-color: rgba(210, 209, 213, 0.75); height: 20%;" disabled tabindex=""></vaadin-button>
 <vaadin-vertical-layout style="align-self: center; height: 70%; width: 100%; align-items: flex-start; justify-content: center;" theme="spacing">
  <vaadin-button style="width: 100%; background-color: rgba(210, 209, 213, 0.75); font-family: Roboto; font-style: normal; font-weight: bold; font-size: 36px; line-height: 56px; color: #000000; height: 100%;" id="projectName" disabled>
   default project name
  </vaadin-button>
  <vaadin-button style="width: 100%; background-color: rgba(210, 209, 213, 0.75); color: #000000; " id="toBacklog">
    Backlog 
  </vaadin-button>
  <vaadin-button style="width: 100%; background-color: rgba(210, 209, 213, 0.75); color: #000000; " id="toCalendar">
    Calendar 
  </vaadin-button>
  <vaadin-button style="width: 100%; background-color: rgba(210, 209, 213, 0.75); color: #000000; " id="toTickets">
    Tickets 
  </vaadin-button>
  <vaadin-button style="width: 100%; background-color: rgba(210, 209, 213, 0.75); color: #000000; " id="toTeam">
    Team 
  </vaadin-button>
  <vaadin-vertical-layout style="width: 95%; padding: var(--lumo-space-xs); flex-grow: 0; flex-shrink: 1; align-self: center; justify-content: flex-end; margin: var(--lumo-space-xl);" theme="spacing-l">
   <vaadin-button style="border-radius: 10px; background-color: #FED766; color: #000000; box-shadow: var(--lumo-box-shadow-s); width: 100%; align-self: center; padding: var(--lumo-space-xs); flex-shrink: 1;" id="toProjectPage">
     Switch Projects 
   </vaadin-button>
  </vaadin-vertical-layout>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'sidebar-component';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(SidebarComponent.is, SidebarComponent);
