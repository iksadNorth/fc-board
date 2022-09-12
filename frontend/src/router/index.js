import { createWebHistory, createRouter } from 'vue-router';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import('../components/view_Home.vue'), 
  },

  {
    path: '/login',
    name: 'Login',
    component: () => import('../components/view_Login.vue'), 
  },

  {
    path: '/join',
    name: 'Join',
    component: () => import('../components/view_Join.vue'), 
  },

  {
    path: '/post-write',
    name: 'PostWrite',
    component: () => import('../components/view_PostWrite.vue'), 
  },

  {
    path: '/posts/:id',
    name: 'Post',
    component: () => import('../components/view_Post.vue'), 
  },

  {
    path: '/posts/search-hashtag',
    name: 'Hashtag',
    component: () => import('../components/view_Hashtag.vue'), 
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;