import { createApp } from 'vue'
import VueGoogleMaps from '@fawmi/vue-google-maps'
import App from './App.vue'

createApp(App)
    .use(VueGoogleMaps, {
        load: {
            key: 'AIzaSyAQLEWp-adcWG-zLCM5X8Iwf_q1DUznv7w',
        },
    }).mount("#app")
