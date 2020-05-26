import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import './header-component.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import './add-project-component.js';

class ProjectView extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout style="width: 100%; flex-shrink: 1; height: 10%;">
  <header-component style="flex-grow: 1; flex-shrink: 0;" id="header"></header-component>
 </vaadin-horizontal-layout>
 <vaadin-vertical-layout style="width: 100%; height: 90%; background-color: rgba(210, 209, 213); justify-content: flex-start; align-items: flex-start; flex-shrink: 1; flex-grow: 1;">
  <vaadin-button style="background-color: rgba(210, 209, 213, 0.75); color: #000000; font-size: 16pt; font-weight: bold; align-self: flex-start; margin-left: var(--lumo-space-m);" disabled tabindex="">
    All Projects 
  </vaadin-button>
  <vaadin-vertical-layout style="width: 100%; height: 100%; justify-content: space-around;">
   <vaadin-horizontal-layout id="topLayout" style="width: 100%; height: 25%;"></vaadin-horizontal-layout>
   <vaadin-horizontal-layout style="width: 100%; height: 25%;"></vaadin-horizontal-layout>
   <vaadin-horizontal-layout style="width: 100%; height: 25%;"></vaadin-horizontal-layout>
   <vaadin-horizontal-layout style="width: 100%; align-self: flex-end; justify-content: flex-end; padding-right: var(--lumo-space-l);">
    <add-project-component id="addButton" style="width: 25%;"></add-project-component>
   </vaadin-horizontal-layout>
  </vaadin-vertical-layout>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'project-view';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(ProjectView.is, ProjectView);
