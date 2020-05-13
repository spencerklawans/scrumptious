import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import './header-component.js';
import './sidebar-component.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class BacklogView extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout style="width: 100%; height: 10%; flex-grow: 0;">
  <header-component style="flex-shrink: 0; flex-grow: 1;"></header-component>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="width: 100%; height: 90%; flex-grow: 1; flex-shrink: 1;">
  <vaadin-vertical-layout style="width: 20%; height: 100%;">
   <sidebar-component id="sidebarComponent" style="flex-shrink: 0; flex-grow: 1; align-self: stretch;"></sidebar-component>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout style="flex-grow: 1; flex-shrink: 0; width: 80%; height: 100%;">
   <vaadin-button style="color: #000000; background-color: #FFFFFF; font-size: 16pt; margin: var(--lumo-space-l);" disabled>
    Backlog
   </vaadin-button>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'backlog-view';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(BacklogView.is, BacklogView);