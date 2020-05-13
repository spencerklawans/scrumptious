import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import './top-bar.js';
import './side-bar.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
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
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct);">
  <top-bar style="width: 100%;"></top-bar>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto;">
  <side-bar style="width: 20%;"></side-bar>
  <vaadin-horizontal-layout style="justify-content: center; width: 100%;">
   <add-to-backlog></add-to-backlog>
  </vaadin-horizontal-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct);"></vaadin-horizontal-layout>
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
