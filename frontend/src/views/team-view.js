import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
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
<vaadin-vertical-layout style="width: 100%; height: 100%;" id="root">
 <vaadin-button style="font-size: 16pt; color: #000000; margin-top: var(--lumo-space-l); margin-left: var(--lumo-space-m); align-self: flex-start; background-color: #FFFFFF; font-weight: bold;" disabled tabindex="">
   Team 
 </vaadin-button>
 <vaadin-horizontal-layout class="content" style="width: 100%; height: 100%;">
  <vaadin-vertical-layout style="height: 100%; width: 33%;" id="columnOne"></vaadin-vertical-layout>
  <vaadin-vertical-layout style="height: 100%; width: 33%;" id="columnTwo"></vaadin-vertical-layout>
  <vaadin-vertical-layout style="width: 33%;" id="columnThree"></vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="width: 100%;">
  <vaadin-button style="border-radius: 10px; background-color: #FED766; color: #000000; box-shadow: var(--lumo-box-shadow-s); font-size: 12pt; margin: var(--lumo-space-l);">
    Contact Team Member 
  </vaadin-button>
  <vaadin-horizontal-layout theme="spacing" style="flex-grow: 1;"></vaadin-horizontal-layout>
  <vaadin-button style="border-radius: 10px; background-color: #FED766; color: #000000; box-shadow: var(--lumo-box-shadow-s); font-size: 12pt; margin: var(--lumo-space-l);">
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
