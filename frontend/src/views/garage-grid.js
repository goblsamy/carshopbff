import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

class GarageGrid extends PolymerElement {

    static get template() {
        return html`
            <style include="shared-styles"></style>
            <vaadin-grid id="grid"></vaadin-grid>

        `;
    }

    static get is() {
        return 'garage-grid';
    }

    static get properties() {
        return {

        }
    }
}

customElements.define(GarageGrid.is, GarageGrid);