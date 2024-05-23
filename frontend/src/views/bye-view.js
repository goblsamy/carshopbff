import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

class ByeView extends PolymerElement {

    static get template() {
        return html`
            <style include="shared-styles">
                
            </style>
            <vaadin-horizontal-layout class="centered-content">
                <vaadin-text-field id="textField" label="Your name" themeName="bordered"></vaadin-text-field>
                <vaadin-button id="button">Say Bye!</vaadin-button>
            </vaadin-horizontal-layout>
        `;
    }

    static get is() {
        return 'bye-view';
    }

    static get properties() {
        return {

        }
    }
}

customElements.define(ByeView.is, ByeView);