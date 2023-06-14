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
      component: () => import('../views/UserMainView.vue')
    },
    {
      path: '/rna_site',
      name: 'rna_site',
      component: () => import('../views/RNASiteView.vue')
    },
    {
      path: '/user/rna_record',
      name: 'user_rna_record',
      component: () => import('../views/UserRNARecordView.vue')
    },
    {
      path: '/user/vac_record',
      name: 'user_vac_record',
      component: () => import('../views/UserVacRecordView.vue')
    },
    {
      path: '/user/info',
      name: 'user_info',
      component: () => import('../views/UserInfoView.vue')
    },
    {
      path: '/sampler' ,
      name: 'sampler' ,
      component: () => import('../views/SamplerMainView.vue')
    },
    {
      path:'/sampler/nucleic_acid',
      name : 'sampler_nucleic_acid',
      component: () => import('../views/SamplerNucleicAcidView.vue')
    },
    {
      path:'/sampler/vaccination',
      name : 'sampler_vaccination',
      component: () => import('../views/SamplerVaccination.vue')
    },
    {
      path:'/administrator',
      name:'administrator',
      component: () => import('../views/AdministratorMainView.vue')
    },
    {
      path:'/administrator/code_change',
      name:'administrator_code_change',
      component: () => import('../views/AdministratorCodeChangeView.vue')
    },
    {
      path:'/administrator/place_code',
      name:'administrator_place_code',
      component: () => import('../views/AdministratorPlaceCodeView.vue')
    },
    {
      path:'/administrator/na_place',
      name:'administrator_na_place',
      component: () => import('../views/AdministratorNAPlaceView.vue')
    },
    {
      path:'/administrator/user_authorization',
      name:'administrator_user_authorization',
      component: () => import('../views/AdministratorUserAuthorizationView.vue')
    },
    {
      path:'/administrator/code_appeal' ,
      name:'administrator_code_appeal' ,
      component: () => import('../views/AdministratorCodeAppeal.vue')
    }

  ]
})

export default router
