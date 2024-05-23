import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

class AppNavigation extends PolymerElement {

    static get template() {
        return html`
            <style></style>
                <div>
                  <vaadin-tabs id="menu"></vaadin-tabs>
                </div>
        `;
    }

    static get is() {
        return 'app-navigation';
    }

    static get properties() {
        return {

        }
    }
}

customElements.define(AppNavigation.is, AppNavigation);