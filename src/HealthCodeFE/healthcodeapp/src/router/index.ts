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
      path: '/advanced',
      name: 'advanced',
      component: () => import('../views/AdvancedView.vue')
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
      path:'/manager',
      name:'manager',
      component: () => import('../views/ManagerMainView.vue')
    },
    {
      path:'/manager/code_change',
      name:'manager_code_change',
      component: () => import('../views/ManagerCodeChangeView.vue')
    },
    {
      path:'/manager/place_code',
      name:'manager_place_code',
      component: () => import('../views/ManagerPlaceCodeView.vue')
    },
    {
      path:'/manager/na_place',
      name:'manager_na_place',
      component: () => import('../views/ManagerNAPlaceView.vue')
    },
    {
      path:'/manager/user_authorization',
      name:'manager_user_authorization',
      component: () => import('../views/ManagerUserAuthorizationView.vue')
    },
    {
      path:'/manager/code_appeal' ,
      name:'manager_code_appeal' ,
      component: () => import('../views/ManagerCodeAppealView.vue')
    },
    {
      path:'/manager/user_info',
      name:'manager_user_info',
      component: () => import('../views/ManagerUserInfoView.vue')
    },
    {
      path:'/detector',
      name:'detector',
      component: () => import('../views/DetectorMainView.vue')
    },
    {
      path:'/detector/view_tube',
      name:'detector_view_tube',
      component: () => import('../views/DetectorViewTubeView.vue')
    }

  ]
})

export default router
