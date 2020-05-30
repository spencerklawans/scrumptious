import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class UserComponent extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; justify-content: center; padding: var(--lumo-space-l);">
 <vaadin-button style="background: #009FB7; box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25); border-radius: 10px; font-size: 18px; line-height: 28px; color: #000000; width: 100%; height: 100%;" id="userButton">
  Default Name
 </vaadin-button>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'user-component';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(UserComponent.is, UserComponent);