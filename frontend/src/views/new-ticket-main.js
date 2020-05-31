import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import './header-component.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import './sidebar-component.js';
import './new-ticket.js';

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
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct); height: 10%;">
  <header-component style="flex-grow: 1;" id="header"></header-component>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto; height: 100%; align-self: stretch;">
  <vaadin-vertical-layout class="sidebar" style="flex-basis: calc(7*var(--lumo-size-s)); flex-shrink: 0; background-color: var(--lumo-contrast-5pct); width: 20%; height: 100%; flex-grow: 1; align-self: stretch;">
   <sidebar-component style="align-self: stretch; flex-grow: 1; flex-shrink: 1; height: 100%; width: 100%;" id="sidebar"></sidebar-component>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout style="flex-grow: 1; height: 100%; width: 80%;">
   <new-ticket style="align-self: stretch; flex-grow: 1;" id="newTicketForm"></new-ticket>
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
