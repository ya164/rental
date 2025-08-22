<template>
  <footer class="footer">
    <div class="footer__content container">
      <div class="footer__brand">
        <router-link to="/" class="logo">
          <div class="logo__icon">📦</div>
          <span class="logo__text">RentalSystem</span>
        </router-link>
        <p class="footer__description">
          Система для ефективного управління орендою об'єктів
        </p>
      </div>

      <div class="footer__links">
        <div class="footer__column">
          <h4 class="footer__title">Навігація</h4>
          <ul class="footer__list">
            <li><router-link to="/#features">Можливості</router-link></li>
            <li><router-link to="/#how">Інструкції</router-link></li>
          </ul>
        </div>
        <div class="footer__column">
          <h4 class="footer__title">Підтримка</h4>
          <ul class="footer__list">
            <li><router-link to="/faq">FAQ</router-link></li>
            <li><router-link to="/#how">Технічна підтримка</router-link></li>
          </ul>
        </div>
        <div class="footer__column">
          <h4 class="footer__title">Контакти</h4>
          <ul class="footer__list">
            <li>📧 yardid@ukr.net</li>
            <li>📞 +38(093)590-69-96</li>
            <li>📍 м. Київ, вул. Христини Сушко, 49</li>
          </ul>
        </div>
      </div>
    </div>

    <div class="footer__bottom container">
      <div class="footer__copy">© 2024 RentalSystem. Всі права захищено</div>
      <div class="footer__social">
        <a href="#" class="social-link">Facebook</a>
        <a href="#" class="social-link">Instagram</a>
        <a href="#" class="social-link">Twitter</a>
      </div>
    </div>
  </footer>
</template>

<script>
export default {
  name: 'AppFooter'
}
</script>

<style scoped>
/* Додаткові стилі для AppFooter за потребою */
</style>
