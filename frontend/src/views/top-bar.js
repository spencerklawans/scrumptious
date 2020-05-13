import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class TopBar extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 1; background-color: var(--lumo-base-color); box-shadow: var(--lumo-box-shadow-m); justify-content: flex-start; padding: var(--lumo-space-s); height: 100%; flex-grow: 0;" id="header">
 <vaadin-horizontal-layout theme="margin" id="logoWrapper" style="margin-right: auto; padding: var(--lumo-space-xs);"></vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="margin" id="userButtonWrapper" style="justify-content: flex-end; align-items: flex-end; margin-left: auto; padding: var(--lumo-space-xs);">
  <vaadin-button id="userDashButton" style="width: 50px; height: 50px; border-radius: 50%; background-color: #FED766; flex-grow: 0; flex-shrink: 0; box-shadow: var(--lumo-box-shadow-xs); align-self: flex-end;"></vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'top-bar';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(TopBar.is, TopBar);
