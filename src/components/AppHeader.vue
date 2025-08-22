<template>
  <header class="header">
    <div class="header__container container">
      <router-link to="/" class="logo">
        <div class="logo__icon">📦</div>
        <span class="logo__text">RentalSystem</span>
      </router-link>
      <nav>
        <ul class="nav__list">
          <li><router-link to="/" class="nav__link">Головна</router-link></li>
          <li><router-link to="/faq" class="nav__link">FAQ</router-link></li>
          <li><router-link to="/contact" class="nav__link">Контакти</router-link></li>
        </ul>
      </nav>
      <div class="auth-buttons">
        <router-link to="/login" class="btn btn--outline">Увійти</router-link>
        <router-link to="/registration" class="btn btn--primary">Реєстрація</router-link>
      </div>
    </div>
  </header>
</template>

<script>
export default {
  name: 'AppHeader'
}
</script>

<style scoped>
/* Додаткові стилі для AppHeader за потребою */
</style>
