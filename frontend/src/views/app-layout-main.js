import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class AppLayoutMain extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 1; background-color: var(--lumo-base-color); box-shadow: var(--lumo-box-shadow-m); justify-content: flex-start; padding: var(--lumo-space-s); height: 20%; flex-grow: 0;" id="header">
  <vaadin-horizontal-layout theme="margin" id="logoWrapper" style="margin-right: auto; padding: var(--lumo-space-xs);"></vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="margin" id="userButtonWrapper" style="justify-content: flex-end; align-items: flex-end; margin-left: auto; padding: var(--lumo-space-xs);">
   <vaadin-button id="userDashButton" style="width: 50px; height: 50px; border-radius: 50%; background-color: #FED766; flex-grow: 0; flex-shrink: 0; box-shadow: var(--lumo-box-shadow-xs); align-self: flex-end;"></vaadin-button>
  </vaadin-horizontal-layout>
 </vaadin-horizontal-layout>
 <vaadin-vertical-layout style="height: 100%; width: 20%; background-color: rgba(210, 209, 213, 0.75); justify-content: space-around;">
  <vaadin-button style="width: 100%;"></vaadin-button>
  <vaadin-vertical-layout theme="spacing" style="align-self: center; height: 50%; width: 100%; align-items: flex-start;">
   <vaadin-button id="navButtonBacklog" class="menu-bar-button" style="width: 100%; background-color: rgba(210, 209, 213, 0.75); color: #000000; ">
     Backlog 
   </vaadin-button>
   <vaadin-button id="navButtonCalendar" class="menu-bar-button" style="width: 100%; background-color: rgba(210, 209, 213, 0.75); color: #000000; ">
     Calendar 
   </vaadin-button>
   <vaadin-button id="navButtonTickets" class="menu-bar-button" style="width: 100%; background-color: rgba(210, 209, 213, 0.75); color: #000000; ">
     Tickets 
   </vaadin-button>
   <vaadin-button id="navButtonTeam" class="menu-bar-button" style="width: 100%; background-color: rgba(210, 209, 213, 0.75); color: #000000; ">
     Team 
   </vaadin-button>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout style="align-self: center;">
   <vaadin-button style="border-radius: 10px; background-color: #FED766; color: #000000; box-shadow: var(--lumo-box-shadow-s);">
    Switch Projects
   </vaadin-button>
  </vaadin-vertical-layout>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'app-layout-main';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(AppLayoutMain.is, AppLayoutMain);
