import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class HeaderComponent extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-horizontal-layout style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-base-color); box-shadow: var(--lumo-box-shadow-m); justify-content: flex-start; height: 100%; flex-grow: 0;">
 <vaadin-horizontal-layout style="margin-right: auto; padding: var(--lumo-space-s); justify-content: center; align-items: center;" id="logoWrapper"></vaadin-horizontal-layout>
 <vaadin-horizontal-layout id="buttonWrapper" style="justify-content: flex-end; margin-left: auto; padding: var(--lumo-space-s);">
  <vaadin-button id="userDashButton" style="width: 100%; height: 100%; border-radius: 50%; background-color: transparent; flex-grow: 0; flex-shrink: 1; align-self: center;"></vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'header-component';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(HeaderComponent.is, HeaderComponent);
