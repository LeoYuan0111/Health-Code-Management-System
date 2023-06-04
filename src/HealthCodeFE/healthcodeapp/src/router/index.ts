import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/main',
      name: 'main',
      component: () => import('../views/MainView.vue')
    },
    {
      path: '/sampler_main' ,
      name: 'sampler_main' ,
      component: () => import('../views/SamplerMainView.vue')
    },
    {
      path:'/sampler_nucleic_acid',
      name : 'sampler_nucleic_acid',
      component: () => import('../views/SamplerNucleicAcidView.vue')
    },
    {
      path:'/sampler_vaccination',
      name : 'sampler_vaccination',
      component: () => import('../views/SamplerVaccination.vue')
    }

  ]
})

export default router
