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
<vaadin-vertical-layout style="background: #FFFFFF; box-shadow: var(--lumo-box-shadow-s); border-radius: 10px; border: 5px solid #009FB7; ">
 <vaadin-vertical-layout style="align-self: flex-start; margin: var(--lumo-space-m); align-items: stretch; " theme="spacing-xs">
  <vaadin-button style="width: 100%; background-color: rgba(255, 255, 255); font-size: 20pt; color: #000000; align-self: flex-start;" disabled tabindex="" id="title">
    Title 
  </vaadin-button>
  <vaadin-button style="width: 100%; background-color: rgba(255, 255, 255, 0.75); font-size: 12pt;  color: #000000; align-self: flex-start;" disabled id="dateCreated" tabindex="">
    Date Created 
  </vaadin-button>
  <vaadin-button style="width: 100%; background-color: rgba(255, 255, 255, 0.75); font-size: 12pt; color: #000000; align-self: flex-start;" disabled tabindex="" id="owner">
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
