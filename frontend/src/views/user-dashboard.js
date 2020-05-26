import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import './header-component.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-list-box/src/vaadin-list-box.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';

class UserDashboard extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout style="width: 100%; height: 10%;">
  <header-component style="flex-grow: 1;" id="header"></header-component>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="width: 100%; height: 90%; background-color: rgba(210, 209, 213); padding: var(--lumo-space-s);" theme="spacing-xs">
  <vaadin-vertical-layout style="width: 30%; padding: var(--lumo-space-m);">
   <vaadin-button style="background-color: rgba(210, 209, 213, 0.5); color: #000000; font-size: 16pt; padding: var(--lumo-space-xs);" disabled tabindex="">
     User Dashboard 
   </vaadin-button>
   <vaadin-vertical-layout style="width: 100%; height: 90%; background-color: #009FB7; margin-top: var(--lumo-space-xs); border-radius: 15px;">
    <vaadin-horizontal-layout style="width: 100%; height: 50%; padding: var(--lumo-space-l);">
     <vaadin-button style="border-radius: 50%; width: 100%; height: 100%; background-color: #FED766; color: #000000; box-shadow: var(--lumo-box-shadow-s); " disabled tabindex=""></vaadin-button>
    </vaadin-horizontal-layout>
    <vaadin-vertical-layout style="height: 60%; width: 100%; flex-direction: column;">
     <vaadin-horizontal-layout style="width: 100%;" id="nameField"></vaadin-horizontal-layout>
     <vaadin-horizontal-layout style="width: 100%;" id="roleField"></vaadin-horizontal-layout>
     <vaadin-horizontal-layout style="width: 100%;" id="emailField"></vaadin-horizontal-layout>
     <vaadin-horizontal-layout style="width: 100%;" id="phoneField"></vaadin-horizontal-layout>
     <vaadin-horizontal-layout style="width: 100%; justify-content: center;">
      <vaadin-button id="editProfileButton" style="background-color: #FED766; color: #000000; box-shadow: var(--lumo-box-shadow-s); font-size: 12pt;">
        Edit Profile 
      </vaadin-button>
     </vaadin-horizontal-layout>
    </vaadin-vertical-layout>
   </vaadin-vertical-layout>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout style="width: 70%;">
   <vaadin-horizontal-layout style="width: 100%; height: 50%; justify-content: space-between; padding-top: var(--lumo-space-xl);">
    <vaadin-vertical-layout style="width: 45%; margin-top: var(--lumo-space-l); margin-left: var(--lumo-space-xs); background-color: #009FB7; border-radius: 15px;">
     <vaadin-button style="background-color: #009FB7; color: #FFFFFF; font-size: 14pt; padding: var(--lumo-space-xs); margin-left: var(--lumo-space-s);" disabled>
       Current Projects 
     </vaadin-button>
     <vaadin-horizontal-layout style="width: 90%; align-self: center; background-color: #FFFFFF; border-radius: 15px; height: 50%;">
      <vaadin-list-box id="projectListBox">
       <vaadin-item>
         Item one 
       </vaadin-item>
       <vaadin-item>
         Item two 
       </vaadin-item>
       <vaadin-item>
         Item three 
       </vaadin-item>
      </vaadin-list-box>
     </vaadin-horizontal-layout>
     <vaadin-button id="toProjectsButton" style="background-color: #FED766; color: #000000; box-shadow: var(--lumo-box-shadow-s); font-size: 12pt; align-self: center; margin-top: var(--lumo-space-s);">
       Go to Project Page 
     </vaadin-button>
    </vaadin-vertical-layout>
    <vaadin-vertical-layout style="width: 45%; margin-top: var(--lumo-space-l); background-color: #009FB7; border-radius: 15px; margin-right: var(--lumo-space-m);">
     <vaadin-button style="background-color: #009FB7; color: #FFFFFF; font-size: 14pt; padding: var(--lumo-space-xs); margin-left: var(--lumo-space-s);" disabled>
       Today's Tickets 
     </vaadin-button>
     <vaadin-horizontal-layout style="width: 90%; align-self: center; background-color: #FFFFFF; border-radius: 15px; height: 50%;">
      <vaadin-list-box id="ticketListBox">
       <vaadin-item id="vaadinItem">
         Item one 
       </vaadin-item>
       <vaadin-item>
         Item two 
       </vaadin-item>
       <vaadin-item>
         Item three 
       </vaadin-item>
      </vaadin-list-box>
     </vaadin-horizontal-layout>
     <vaadin-button id="toTicketsButton" style="background-color: #FED766; color: #000000; box-shadow: var(--lumo-box-shadow-s); font-size: 12pt; align-self: center; margin-top: var(--lumo-space-s);">
       Go to Tickets Page 
     </vaadin-button>
    </vaadin-vertical-layout>
   </vaadin-horizontal-layout>
   <vaadin-horizontal-layout style="width: 100%; height: 60%;">
    <vaadin-vertical-layout style="margin-top: var(--lumo-space-l); margin-left: var(--lumo-space-xs); margin-bottom: var(--lumo-space-l); width: 100%; margin-right: var(--lumo-space-m); background-color: #009FB7; border-radius: 15px; ">
     <vaadin-button style="background-color: #009FB7; color: #FFFFFF; font-size: 14pt; padding: var(--lumo-space-xs); margin-left: var(--lumo-space-s);">
       Notes 
     </vaadin-button>
     <vaadin-horizontal-layout id="notesField" style="width: 90%; align-self: center; background-color: #FFFFFF; border-radius: 15px; height: 75%;"></vaadin-horizontal-layout>
    </vaadin-vertical-layout>
   </vaadin-horizontal-layout>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'user-dashboard';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(UserDashboard.is, UserDashboard);
