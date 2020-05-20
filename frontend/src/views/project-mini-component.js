import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class ProjectMiniComponent extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="background: #FFFFFF;
box-shadow: 4px 4px 4px rgba(0, 0, 0, 0.25);
border-radius: 20px;">
 <vaadin-vertical-layout style="align-self: center; margin: var(--lumo-space-m);">
  <vaadin-button style="width: 100%; background-color: rgba(255, 255, 255); font-family: Roboto;
font-style: normal;
font-weight: bold;
font-size: 36px;
line-height: 42px; color: #000000;" disabled>
   Title 
  </vaadin-button>
  <vaadin-button style="width: 100%; background-color: rgba(255, 255, 255, 0.75);font-family: Roboto;
font-style: normal;
font-weight: 500;
font-size: 24px;
line-height: 28px;

color: #000000;" disabled id="date created" tabindex="">
   Date Created
  </vaadin-button>
  <vaadin-button style="width: 100%; background-color: rgba(255, 255, 255, 0.75); font-family: Roboto;
font-style: normal;
font-weight: 500;
font-size: 18px;
line-height: 21px;

color: #000000;" disabled tabindex="">
   Created By: 
  </vaadin-button>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'project-mini-component';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(ProjectMiniComponent.is, ProjectMiniComponent);
