import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class AddProjectComponent extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-button theme="icon" aria-label="Add new" id="addButton" style="width: 100%; background-color: #FED766; box-shadow: var(--lumo-box-shadow-s); border-radius: 10px; color: #000000; font-size: 12pt;">
  Add Project 
 </vaadin-button>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'add-project-component';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(AddProjectComponent.is, AddProjectComponent);
