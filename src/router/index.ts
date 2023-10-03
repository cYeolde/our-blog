import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import Index from "@/views/Index.vue";
import Classify from "@/views/Classify.vue";
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
    path:'/classify',
    name: 'classify',
    component: Classify,
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
