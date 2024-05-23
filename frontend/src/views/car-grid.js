import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

class CarGrid extends PolymerElement {

    static get template() {
        return html`
            <style include="shared-styles"></style>
            <vaadin-grid id="grid"></vaadin-grid>

        `;
    }

    static get is() {
        return 'car-grid';
    }

    static get properties() {
        return {

        }
    }
}

customElements.define(CarGrid.is, CarGrid);