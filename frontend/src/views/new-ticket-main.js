import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import './side-bar.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import './top-bar.js';
import './new-ticket.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

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
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct); height: 100%;">
  <top-bar style="width: 100%; height: 100%; flex-grow: 0; flex-shrink: 0;"></top-bar>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto;">
  <vaadin-vertical-layout class="sidebar" style="flex-basis: calc(7*var(--lumo-size-s)); flex-shrink: 0; background-color: var(--lumo-contrast-5pct);">
   <side-bar style="width: 100%;"></side-bar>
  </vaadin-vertical-layout>
  <vaadin-horizontal-layout style="width: 100%; justify-content: center;">
   <new-ticket style="width: 50%; align-self: center;"></new-ticket>
  </vaadin-horizontal-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct);"></vaadin-horizontal-layout>
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
