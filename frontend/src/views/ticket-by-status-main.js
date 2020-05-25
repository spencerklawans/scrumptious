import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import './tickets-by-status.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import './header-component.js';
import './sidebar-component.js';

class TicketByStatusMain extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 1; background-color: var(--lumo-contrast-10pct); height: 10%;">
  <header-component style="flex-grow: 1; flex-shrink: 0;" id="header"></header-component>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto; height: 90%; align-self: stretch;">
  <vaadin-vertical-layout class="sidebar" style="flex-basis: calc(7*var(--lumo-size-s)); flex-shrink: 1; background-color: var(--lumo-contrast-5pct); width: 20%; flex-grow: 1; height: 100%; align-self: stretch;">
   <sidebar-component style="align-self: stretch; " id="sidebar"></sidebar-component>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout class="content" style="width: 80%; flex-grow: 1; align-self: stretch; height: 100%;">
   <tickets-by-status style="width: 100%; flex-shrink: 0;" id="ticketStatusView"></tickets-by-status>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'ticket-by-status-main';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(TicketByStatusMain.is, TicketByStatusMain);
