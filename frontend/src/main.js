import { createApp } from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import { loadFonts } from './plugins/webfontloader'

import axios from "axios";
import store from './store'
import router from './router';

import com_sheet from './components/parts/com_sheet.vue'
import com_List_posts from './components/parts/com_List_posts.vue'
import com_pagination from './components/parts/com_pagination.vue'

import view_Hashtag from './components/view_Hashtag.vue'
import view_Home from './components/view_Home.vue'
import view_Join from './components/view_Join.vue'
import view_Login from './components/view_Login.vue'
import view_Post from './components/view_Post.vue'
import view_Posts from './components/view_Posts.vue'

loadFonts()

const app = createApp(App)

app.component("com-sheet", com_sheet)
app.component("com-List-posts", com_List_posts)
app.component("com-pagination", com_pagination)

app.component("view-Hashtag", view_Hashtag)
app.component("view-Home", view_Home)
app.component("view-Join", view_Join)
app.component("view-Login", view_Login)
app.component("view-Post", view_Post)
app.component("view-Posts", view_Posts)

axios.defaults.baseURL = 'http://localhost:8080'
app.config.globalProperties.$axios = axios;

app.use(vuetify)
app.use(store)
app.use(router)
app.mount('#app')
