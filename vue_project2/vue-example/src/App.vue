<script setup>
import { useThemeStore } from '@@/stores/theme'

import HelloWorld from './components/HelloWorld.vue'
import Filter from './components/Filter.vue'

const themeStore = useThemeStore()
</script>

<template>
  <!-- <div>
    <a href="https://github.com/choosla" target="_blank">
      <img src="/choosla.svg" class="logo" alt="Choosla logo" />
    </a>
  </div>
  <HelloWorld msg="Vue Starter" /> -->

  <!-- <Filter /> -->
  <div :style="{ backgroundColor: themeStore.color }" class="min-h-screen transition-all">
    <!-- <router-view /> -->
  </div>
</template>

<style scoped>
.logo {
  height: 6em;
  padding: 1.5em;
  will-change: filter;
  transition: filter 300ms;
}
.logo:hover {
  filter: drop-shadow(0 0 2em #0c52bb);
}
</style>
