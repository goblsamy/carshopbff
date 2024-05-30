import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

class CarView extends PolymerElement {

    static get template() {
        return html`
            <style include="shared-styles">

            </style>
            <vaadin-horizontal-layout style="justify-content: space-between;">
                <div>
                    <vaadin-button id="createButton">
                        <iron-icon icon="lumo:plus" slot="prefix"></iron-icon>Létrehozás
                    </vaadin-button>
                    <vaadin-button id="deleteButton">
                        <iron-icon icon="lumo:cross" slot="prefix"></iron-icon>Törlés
                    </vaadin-button>
                    <vaadin-button id="editButton">
                        <iron-icon icon="lumo:edit" slot="prefix"></iron-icon>Módosítás
                    </vaadin-button>
                </div>
                <div>
                    <vaadin-button id="refreshButton">
                        <iron-icon icon="lumo:search" slot="prefix"></iron-icon>Frissítés
                    </vaadin-button>
                </div>
            </vaadin-horizontal-layout>
            <div>
                <car-grid id="carGrid"></car-grid>
            </div>
            <vaadin-dialog id="dialog"></vaadin-dialog>
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