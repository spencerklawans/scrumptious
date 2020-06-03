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
<vaadin-vertical-layout style="justify-content: center; padding: var(--lumo-space-l); background: #009FB7; box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25); border-radius: 10px;">
 <vaadin-button id="userButton" style="background: #009FB7; font-size: 14pt; line-height: 28px; color: #FFFFFF; font-weight: bold;" disabled></vaadin-button>
 <vaadin-button id="emailButton" style="background: #009FB7; font-size: 14pt; line-height: 28px; color: #FFFFFF;" disabled>
   Button 
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