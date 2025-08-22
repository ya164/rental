<template>
  <div id="app">
    <AppHeader />
    <main>
      <router-view></router-view>
    </main>
    <AppFooter />
  </div>
</template>

<script>
import AppHeader from './components/AppHeader.vue'
import AppFooter from './components/AppFooter.vue'

export default {
  name: 'App',
  components: {
    AppHeader,
    AppFooter
  }
}
</script>

<style>
/* Глобальні стилі вже підключені у main.js */
</style>
