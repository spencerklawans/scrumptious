import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import './sidebar-component.js';
import './header-component.js';
import './team-view.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class TeamViewMain extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout class="header" style="width: 100%; height: 10%;">
  <header-component style="flex-grow: 1;" id="header"></header-component>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto; height: 90%; align-self: stretch;">
  <vaadin-vertical-layout class="sidebar" style="width: 20%; flex-grow: 1; height: 100%; align-self: stretch;">
   <sidebar-component id="sidebar" style="align-self: stretch;"></sidebar-component>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout class="content" style="width: 80%; flex-grow: 1; align-self: stretch; height: 100%;">
   <team-view style="flex-grow: 1; width: 100%;" id="teamView"></team-view>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'team-view-main';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(TeamViewMain.is, TeamViewMain);
