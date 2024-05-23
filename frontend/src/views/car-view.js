import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

class CarView extends PolymerElement {

    static get template() {
        return html`
            <style include="shared-styles"></style>
            <vaadin-horizontal-layout class="centered-content">
                <car-grid id="carGrid"></car-grid>
                <vaadin-button id="button">Refresh gec</vaadin-button>
            </vaadin-horizontal-layout>
        `;
    }

    static get is() {
        return 'car-view';
    }

    static get properties() {
        return {}
    }
}

customElements.define(CarView.is, CarView);