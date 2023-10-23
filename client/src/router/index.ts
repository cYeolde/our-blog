import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import Index from "@/views/Index.vue";
import Articles from "@/components/Blog/Articles.vue";
import About from "@/views/About.vue";
import Photos from "@/views/Photos.vue";
import Tags from "@/views/Tags.vue";
import Archive from "@/views/Archive.vue";
import Classify from "@/views/Classify.vue";
import Notes from "@/components/Blog/ClassifyList.vue";

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
    children: [
      {
        path:'Notes',
        name: 'Notes',
        component: Notes,
      },
      {
        path:'Projects',
        name: 'Projects',
        component: Articles,
      }
    ]
  },
  //动态路由参数，接受文章ID
  {
    path: '/articles/:id',
    name: 'articles',
    component: Articles,
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
