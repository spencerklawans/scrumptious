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
<vaadin-vertical-layout style="background: #FFFFFF; border: 5px solid #009FB7; box-sizing: border-box; box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25); border-radius: 5px; flex-direction: column;">
 <vaadin-button style="width: 100%; background-color: rgba(255, 255, 255); font-family: Roboto; font-style: normal; font-weight: bold; font-size: 24px; line-height: 28px; color: #000000; height: 80%;" disabled>
  Backlog Item Title
 </vaadin-button>
 <vaadin-button style="background: rgba(232, 184, 14, 0.6); border-radius: 2px; align-self: flex-end; margin: var(--lumo-space-l); font-family: Roboto;
font-style: normal;
font-weight: normal;
font-size: 14px;
line-height: 16px;

color: #000000;" disabled>
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
