import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import './sidebar-component.js';
import './new-ticket.js';
import './header-component.js';

class NewTicketMain extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct); height: 10%; flex-grow: 0;">
  <header-component style="flex-grow: 1; width: 100%; flex-shrink: 1; align-self: stretch;" id="header"></header-component>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto; height: 90%;">
  <vaadin-vertical-layout class="sidebar" style="flex-basis: calc(7*var(--lumo-size-s)); flex-shrink: 0; width: 20%; height: 100%; flex-grow: 1;">
   <sidebar-component style="flex-grow: 1; flex-shrink: 1; height: 100%; width: 100%; align-self: stretch;" id="sidebar"></sidebar-component>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout style="flex-grow: 0; height: 100%; width: 80%;">
   <new-ticket style="flex-grow: 1; align-self: stretch;" id="newTicketForm"></new-ticket>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'new-ticket-main';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(NewTicketMain.is, NewTicketMain);
