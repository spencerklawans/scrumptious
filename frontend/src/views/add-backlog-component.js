import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';

class AddBacklogComponent extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-button theme="icon" aria-label="Add new" style="width: 100%; background-color: #FED766; box-shadow: var(--lumo-box-shadow-s); border-radius: 10px; color: #000000;" id="addButton">
  <iron-icon icon="lumo:plus"></iron-icon>
 </vaadin-button>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'add-backlog-component';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(AddBacklogComponent.is, AddBacklogComponent);
