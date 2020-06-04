import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import './header-component.js';
import '@vaadin/vaadin-list-box/src/vaadin-list-box.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-area.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

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
  <vaadin-vertical-layout style="width: 30%; padding: var(--lumo-space-m); height: 100%;">
   <vaadin-button style="background-color: rgba(210, 209, 213, 0.5); color: #000000; font-size: 16pt; padding: var(--lumo-space-xs); font-weight: bold;" disabled tabindex="">
     User Dashboard 
   </vaadin-button>
   <vaadin-vertical-layout style="width: 100%; height: 100%; background-color: #009FB7; margin-top: var(--lumo-space-xs); border-radius: 15px; justify-content: space-around;">
    <vaadin-vertical-layout style="height: 60%; width: 100%; flex-direction: column; justify-content: space-around;">
     <vaadin-horizontal-layout style="width: 100%;" id="profilePicField">
      <vaadin-button id="userProfilePic" style="width: 100%; height: 100%; border-radius: 50%; background-color: transparent; flex-grow: 0; flex-shrink: 1; align-self: center; padding-top: var(--lumo-space-s);"></vaadin-button>
     </vaadin-horizontal-layout>
     <vaadin-horizontal-layout style="width: 100%;" id="nameField">
      <vaadin-button id="name" style="width: 100%; background-color: #009FB7; color: #FFFFFF; font-size: 14pt; font-weight: bold;" disabled tabindex=""></vaadin-button>
     </vaadin-horizontal-layout>
     <vaadin-horizontal-layout style="width: 100%; justify-content: flex-start; flex-wrap: wrap; align-content: flex-start;" id="emailField">
      <vaadin-button style="background-color: #009FB7; color: #000000; font-size: 12pt; font-weight: bold; padding: var(--lumo-space-xs); margin-left: var(--lumo-space-xs);" disabled tabindex="">
        Email: 
      </vaadin-button>
      <vaadin-button id="email" style="background-color: #009FB7; font-size: 12pt; padding-right: var(--lumo-space-xs); color: #000000;" disabled tabindex=""></vaadin-button>
     </vaadin-horizontal-layout>
     <vaadin-horizontal-layout style="width: 100%; justify-content: flex-start; flex-wrap: wrap; align-content: flex-start;" id="roleField">
      <vaadin-button style="background-color: #009FB7; color: #000000; font-size: 12pt; font-weight: bold; padding: var(--lumo-space-xs); margin-left: var(--lumo-space-s);" disabled tabindex="">
        Current Project: 
      </vaadin-button>
      <vaadin-button id="currProject" style="background-color: #009FB7; font-size: 12pt; padding-right: var(--lumo-space-xs); color: #000000; padding: var(--lumo-space-s); margin-left: var(--lumo-space-s);" disabled tabindex=""></vaadin-button>
     </vaadin-horizontal-layout>
    </vaadin-vertical-layout>
   </vaadin-vertical-layout>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout style="width: 70%;">
   <vaadin-horizontal-layout style="width: 100%; height: 50%; justify-content: space-between; padding-top: var(--lumo-space-xl);">
    <vaadin-vertical-layout style="width: 45%; margin-top: var(--lumo-space-l); margin-left: var(--lumo-space-xs); background-color: #009FB7; border-radius: 15px;">
     <vaadin-button style="background-color: #009FB7; color: #FFFFFF; font-size: 14pt; font-weight: bold; padding: var(--lumo-space-xs); margin-left: var(--lumo-space-s);" disabled tabindex="">
       All Projects 
     </vaadin-button>
     <vaadin-horizontal-layout style="width: 90%; align-self: center; background-color: #FFFFFF; border-radius: 15px; height: 50%; padding: var(--lumo-space-s);">
      <vaadin-list-box id="projectListBox" style="width: 100%; padding: var(--lumo-space-s); overflow: auto;"></vaadin-list-box>
     </vaadin-horizontal-layout>
     <vaadin-button id="toProjectsButton" style="background-color: #FED766; color: #000000; box-shadow: var(--lumo-box-shadow-s); font-size: 12pt; align-self: center; margin-top: var(--lumo-space-s);">
       Go to Projects Page 
     </vaadin-button>
    </vaadin-vertical-layout>
    <vaadin-vertical-layout style="width: 45%; margin-top: var(--lumo-space-l); background-color: #009FB7; border-radius: 15px; margin-right: var(--lumo-space-m);">
     <vaadin-button style="background-color: #009FB7; color: #FFFFFF; font-size: 14pt; font-weight: bold; padding: var(--lumo-space-xs); margin-left: var(--lumo-space-s);" disabled tabindex="">
       Current Tickets 
     </vaadin-button>
     <vaadin-horizontal-layout style="width: 90%; align-self: center; background-color: #FFFFFF; border-radius: 15px; height: 50%; padding: var(--lumo-space-s);">
      <vaadin-list-box id="ticketListBox" style="width: 100%; padding: var(--lumo-space-s); overflow: auto;"></vaadin-list-box>
     </vaadin-horizontal-layout>
     <vaadin-button id="toTicketsButton" style="background-color: #FED766; color: #000000; box-shadow: var(--lumo-box-shadow-s); font-size: 12pt; align-self: center; margin-top: var(--lumo-space-s);">
       Go to Tickets Page 
     </vaadin-button>
    </vaadin-vertical-layout>
   </vaadin-horizontal-layout>
   <vaadin-horizontal-layout style="width: 100%; height: 60%;">
    <vaadin-vertical-layout style="margin-top: var(--lumo-space-l); margin-left: var(--lumo-space-xs); margin-bottom: var(--lumo-space-l); width: 100%; margin-right: var(--lumo-space-m); background-color: #009FB7; border-radius: 15px; height: 86%;">
     <vaadin-button style="background-color: #009FB7; color: #FFFFFF; font-size: 14pt; padding: var(--lumo-space-xs); margin-left: var(--lumo-space-s); font-weight: bold;">
       Notes 
     </vaadin-button>
     <vaadin-text-area label="" placeholder="" id="noteField" style="width: 90%; background: #FFFFFF; height: 55%; align-self: center; padding: var(--lumo-space-s); border-radius: 15px; overflow: auto;" has-value></vaadin-text-area>
     <vaadin-button id="saveNotesButton" style="align-self: flex-end; margin-right: var(--lumo-space-l); background-color: #FED766; color: #000000; box-shadow: var(--lumo-box-shadow-s); font-size: 12pt; margin-top: var(--lumo-space-s);">
       Save Notes 
     </vaadin-button>
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
