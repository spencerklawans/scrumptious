import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import './header-component.js';
import './sidebar-component.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class CalendarMain extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout style="width: 100%; height: 10%;">
  <header-component id="header" style="flex-grow: 1;"></header-component>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="width: 100%; height: 90%; align-self: stretch; flex-grow: 1;">
  <vaadin-vertical-layout style="width: 20%; flex-grow: 1; height: 100%; align-self: stretch; flex-shrink: 0;">
   <sidebar-component id="sidebar" style="align-self: stretch; flex-grow: 1; flex-shrink: 0;"></sidebar-component>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout style="width: 80%; flex-grow: 1; align-self: stretch; height: 100%;">
   <vaadin-button style="margin-top: var(--lumo-space-l); margin-left: var(--lumo-space-m); background-color: #FFFFFF; color: #000000; font-size: 16pt; font-weight: bold;" disabled tabindex="">
     Calendar 
   </vaadin-button>
   <vaadin-horizontal-layout id="viewWrapper" style="width: 100%; align-self: flex-end; justify-content: flex-end; padding-right: var(--lumo-space-m);"></vaadin-horizontal-layout>
   <vaadin-horizontal-layout id="calendarWrapper" style="width: 100%; height: 70%; padding: var(--lumo-space-m);"></vaadin-horizontal-layout>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'calendar-main';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(CalendarMain.is, CalendarMain);
