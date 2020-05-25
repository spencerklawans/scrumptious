import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

class LoginMain extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-horizontal-layout style="width: 100%; height: 100%; background-color: rgba(210, 209, 213); justify-content: center;">
 <vaadin-vertical-layout style="width: 40%; height: 40%; align-self: center; background-color: #FFFFFF; align-items: center;">
  <vaadin-horizontal-layout id="logoWrapper" style="align-self: stretch; margin: var(--lumo-space-l); margin-top: var(--lumo-space-l); margin-bottom: var(--lumo-space-m); align-items: center; justify-content: center;"></vaadin-horizontal-layout>
  <vaadin-horizontal-layout>
   <div style="font-size: 10pt; padding-left: var(--lumo-space-l); padding-right: var(--lumo-space-l); text-align: center;">
    A lightweight ticket management system for new developers.
   </div>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout id="signInWrapper" style="margin: var(--lumo-space-l);"></vaadin-horizontal-layout>
 </vaadin-vertical-layout>
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'login-main';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(LoginMain.is, LoginMain);
