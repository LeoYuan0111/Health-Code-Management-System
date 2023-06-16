<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
import { onMounted } from 'vue'

import { useUserStore } from '@/stores/user'

const user = useUserStore()

// await user.checkLogin()
onMounted(async () => {
  await user.checkLogin()
})
// import HelloWorld from './components/HelloWorld.vue'
</script>

<template>
  <div id="corner">
    <div id="circle1"></div>
    <div id="circle2"></div>
  </div>
  <RouterView />
</template>

<style scoped>
header {
  line-height: 1.5;
  max-height: 100vh;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

nav {
  width: 100%;
  font-size: 12px;
  text-align: center;
  margin-top: 2rem;
}

nav a.router-link-exact-active {
  color: var(--color-text);
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
}

nav a {
  display: inline-block;
  padding: 0 1rem;
  border-left: 1px solid var(--color-border);
}

nav a:first-of-type {
  border: 0;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }

  nav {
    text-align: left;
    margin-left: -1rem;
    font-size: 1rem;

    padding: 1rem 0;
    margin-top: 1rem;
  }
}
#corner {
  position: absolute;
  top: 0;
  right: 0;
  overflow: hidden;
  width: 20rem;
  height: 20rem;
  z-index: -99
}
#circle1 {
  position: absolute;
  top: -4rem;
  right: -4rem;
  width: 8rem;
  height: 8rem;
  border-radius: 50%;
  background-color: #01A28C;
  opacity: 0.6;
  background-size: 20px 20px;
  z-index: -199;
}
#circle2 {
  position: absolute;
  top: -5rem;
  right: -4rem;
  width: 10rem;
  height: 10rem;
  border-radius: 50%;
  background-color: #01A28C;
  opacity: 0.38;
  background-size: 20px 20px;
  z-index: -299;
}
</style>
