import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

class GarageView extends PolymerElement {

    static get template() {
        return html`
            <style include="shared-styles"></style>
            <div class="centered-content">
                <garage-grid id="garageGrid"></garage-grid>
                <vaadin-button id="button">Refresh Garagec</vaadin-button>
            </div>
        `;
    }

    static get is() {
        return 'garage-view';
    }

    static get properties() {
        return {}
    }
}

customElements.define(GarageView.is, GarageView);