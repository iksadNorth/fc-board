import { createApp } from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import { loadFonts } from './plugins/webfontloader'

import axios from "axios";
import store from './store'
import router from './router';

import com_sheet from './components/parts/com_sheet.vue'

import view_Hashtag from './components/view_Hashtag.vue'
import view_Home from './components/view_Home.vue'
import view_Join from './components/view_Join.vue'
import view_Login from './components/view_Login.vue'
import view_Post from './components/view_Post.vue'
import view_Posts from './components/view_Posts.vue'

loadFonts()

const app = createApp(App)

app.component("com-sheet", com_sheet)

app.component("view-Hashtag", view_Hashtag)
app.component("view-Home", view_Home)
app.component("view-Join", view_Join)
app.component("view-Login", view_Login)
app.component("view-Post", view_Post)
app.component("view-Posts", view_Posts)

app.config.globalProperties.$axios = axios;
app.config.globalProperties.$backendUrl = 'http://localhost:8080';

app.use(vuetify)
app.use(store)
app.use(router)
app.mount('#app')
