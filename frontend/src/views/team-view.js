import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import './user-component.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class TeamView extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-button style="font-family: Roboto;
font-style: normal;
font-weight: bold;
font-size: 48px;
line-height: 56px;

color: #000000;" disabled>
  Team
 </vaadin-button>
 <vaadin-horizontal-layout class="content" style="width: 100%; height: 100%;">
  <vaadin-vertical-layout style="height: 100%; width: 33%;">
   <user-component style="align-self: stretch;"></user-component>
   <user-component style="align-self: stretch;"></user-component>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout style="height: 100%; width: 33%;">
   <user-component style="align-self: stretch;"></user-component>
   <user-component style="align-self: stretch;"></user-component>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout style="width: 33%;">
   <user-component style="width: 100%;"></user-component>
   <user-component style="width: 100%;"></user-component>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="width: 100%;">
  <vaadin-button style="background: #FED766; box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25); border-radius: 15px; margin: var(--lumo-space-l);">
   Contact Team Member
  </vaadin-button>
  <vaadin-horizontal-layout theme="spacing" style="flex-grow: 1;"></vaadin-horizontal-layout>
  <vaadin-button style="background: #FED766; box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25); border-radius: 15px; margin: var(--lumo-space-l);">
   Manage Team
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'team-view';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(TeamView.is, TeamView);
