import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

class CarDataPanel extends PolymerElement {

    static get template() {
        return html`
            <style include="shared-styles">
                
            </style>
            <div>
                <h3>Új autó létrehozása</h3>
                <div>
                    <vaadin-combo-box id="comboCarType" label="Autó típusa"></vaadin-combo-box>
                    <vaadin-text-field label="Autó neve" value="{{item.carName}}"></vaadin-text-field>
                    <vaadin-text-field label="Garázs azonosító" value="{{item.garageId}}"></vaadin-text-field>
                </div>
                <div>
                    <vaadin-button id="save">
                        <iron-icon icon="lumo:checkmark" slot="prefix"></iron-icon>Ment</vaadin-button>
                    </vaadin-button>
                    <vaadin-button id="cancel">Mégsem</vaadin-button>
                </div>
            </div>
        `;
    }

    static get is() {
        return 'car-data-panel';
    }

    static get properties() {
        return {

        }
    }
}

customElements.define(CarDataPanel.is, CarDataPanel);