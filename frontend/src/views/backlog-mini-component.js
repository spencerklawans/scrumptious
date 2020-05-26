import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class BacklogMiniComponent extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="background: #FFFFFF; border: 5px solid #009FB7; box-shadow: var(--lumo-box-shadow-s); border-radius: 10px; flex-direction: column;">
 <vaadin-button style="width: 100%; background-color: rgba(255, 255, 255); font-size: 14pt; line-height: 28px; color: #000000; height: 80%;" disabled tabindex="">
   Backlog Item Title 
 </vaadin-button>
 <vaadin-button style="background: rgba(232, 184, 14, 0.6); border-radius: 2px; align-self: flex-end; margin: var(--lumo-space-l);
font-size: 10pt;
line-height: 16px;

color: #000000;" disabled tabindex="">
   Priority Level 
 </vaadin-button>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'backlog-mini-component';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(BacklogMiniComponent.is, BacklogMiniComponent);
