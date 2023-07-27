import { createApp } from "vue";
import { library } from "@fortawesome/fontawesome-svg-core";
import { fas } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import "./style.css";
import App from "./App.vue";
import { i18n } from "./i18n.js";

const app = createApp(App);

library.add(fas);
app.component("fa", FontAwesomeIcon);
app.use(i18n);
app.mount("#app");
