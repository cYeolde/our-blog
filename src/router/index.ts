import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import Index from "@/views/Index.vue";
import Articles from "@/views/Articles.vue";
import About from "@/views/About.vue";
import Photos from "@/views/Photos.vue";
import Tags from "@/views/Tags.vue";
import Archive from "@/views/Archive.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'home',
    component: Index,
    children: []
  },
  {
    path:'/articles',
    name: 'articles',
    component: Articles,
    children: []
  },
  {
    path: '/about',
    name: 'about',
    component: About,
    children: [],
  },
  {
    path: '/photos',
    name: 'photos',
    component: Photos,
    children: []
  },
  {
    path: '/tags',
    name: 'tags',
    component: Tags,
    children: []
  },
  {
    path: '/archive',
    name: 'archive',
    component: Archive,
    children: []
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
