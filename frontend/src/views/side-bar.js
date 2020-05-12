import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

class SideBar extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="height: 100%; background-color: rgba(210, 209, 213, 0.75); justify-content: space-around;">
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
`;
    }

    static get is() {
        return 'side-bar';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(SideBar.is, SideBar);
