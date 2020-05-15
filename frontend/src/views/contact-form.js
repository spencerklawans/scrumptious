import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-text-field/src/vaadin-email-field.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class ContactForm extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-form-layout style="width: 100%; height: 100%;">
 <vaadin-text-field label="First Name"></vaadin-text-field>
 <vaadin-text-field label="Last Name"></vaadin-text-field>
 <vaadin-email-field label="Email"></vaadin-email-field>
 <vaadin-combo-box label="Company"></vaadin-combo-box>
 <vaadin-combo-box label="Status"></vaadin-combo-box>
 <vaadin-horizontal-layout theme="spacing" style="width: 100%; height: 100%;">
  <vaadin-button theme="primary">
   Save
  </vaadin-button>
  <vaadin-button theme="error">
   Delete
  </vaadin-button>
  <vaadin-button theme="tertiary">
   Close
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-form-layout>
`;
    }

    static get is() {
        return 'contact-form';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(ContactForm.is, ContactForm);
