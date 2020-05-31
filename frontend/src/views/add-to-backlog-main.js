import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import './header-component.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import './sidebar-component.js';
import './add-to-backlog.js';

class AddToBacklogMain extends PolymerElement {

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
 <vaadin-horizontal-layout style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto; height: 90%;">
  <vaadin-vertical-layout style="width: 20%; height: 100%; align-self: stretch; flex-shrink: 0; flex-grow: 1;">
   <sidebar-component style="flex-shrink: 1; flex-grow: 0; align-self: stretch;" id="sidebar"></sidebar-component>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout style="flex-grow: 0; width: 80%; height: 100%; flex-shrink: 1;">
   <add-to-backlog style="align-self: stretch;" id="addToBacklog"></add-to-backlog>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'add-to-backlog-main';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(AddToBacklogMain.is, AddToBacklogMain);
