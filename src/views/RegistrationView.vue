<template>
  <div class="registration-page">
    <header class="header">
      <div class="header__container container">
        <router-link to="/" class="logo">
          <div class="logo__icon">🚗</div>
          RentalSystem
        </router-link>
        <nav>
          <ul class="nav__list">
            <li><router-link to="/faq" class="nav__link">FAQ</router-link></li>
            <li><router-link to="/contact" class="nav__link">Контакти</router-link></li>
          </ul>
        </nav>
        <div class="auth-buttons">
          <router-link to="/login" class="btn btn-outline">Увійти</router-link>
          <router-link to="/registration" class="btn btn-primary">Реєстрація</router-link>
        </div>
      </div>
    </header>
    <main class="registration">
      <div class="container">
        <h2 class="section-title">Реєстрація</h2>
        <form @submit.prevent="registrationHandler" class="registration-form">
          <div class="form-group">
            <label for="name">Ім'я</label>
            <input type="text" v-model="form.name" class="form-control" id="name" placeholder="Введіть ваше ім'я" required />
            <div v-if="errors.name" class="invalid-feedback">{{ errors.name }}</div>
          </div>
          <div class="form-group">
            <label for="email">Email</label>
            <input type="email" v-model="form.email" class="form-control" id="email" placeholder="Введіть ваш email" required />
            <div v-if="errors.email" class="invalid-feedback">{{ errors.email }}</div>
          </div>
          <div class="form-group">
            <label for="password">Пароль</label>
            <input type="password" v-model="form.password" class="form-control" id="password" placeholder="Введіть пароль" required />
            <div v-if="errors.password" class="invalid-feedback">{{ errors.password }}</div>
          </div>
          <button type="submit" class="btn btn-primary btn-lg">Зареєструватися</button>
        </form>
        <div class="text-center mt-3">
          <router-link to="/login" class="btn btn-secondary">Вхід до кабінету користувача</router-link>
        </div>
        <div class="text-center mt-3">
          <router-link to="/login">Вже маєте обліковий запис?</router-link>
        </div>
      </div>
    </main>
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'RegistrationView',
  data() {
    return {
      form: {
        name: '',
        email: '',
        password: ''
      },
      errors: {}
    }
  },
  methods: {
    ...mapActions(['register', 'fetchUser']),
    validateForm() {
      this.errors = {}
      if (!this.form.name) {
        this.errors.name = 'Ім\'я є обов\'язковим.'
      }
      if (!this.form.email) {
        this.errors.email = 'Email є обов\'язковим.'
      } else if (!/\S+@\S+\.\S+/.test(this.form.email)) {
        this.errors.email = 'Будь ласка, введіть коректний email.'
      }
      if (!this.form.password) {
        this.errors.password = 'Пароль є обов\'язковим.'
      } else if (this.form.password.length < 6) {
        this.errors.password = 'Пароль повинен містити мінімум 6 символів.'
      }
      return Object.keys(this.errors).length === 0
    },
    async performRegistration() {
      try {
        await this.register(this.form)
        await this.fetchUser()
        alert('Реєстрація успішна!')
        this.$router.push('/dashboard')
      } catch (error) {
        console.error(error)
        alert('Помилка при реєстрації. Спробуйте ще раз.')
      }
    },
    registrationHandler() {
      if (this.validateForm()) {
        this.performRegistration()
      }
    }
  }
}
</script>

<style scoped>
.registration-page {
  padding-top: 5rem; /* Врахування фіксованого хедера */
}

.registration-form {
  max-width: 400px;
  margin: 0 auto;
}

.text-center {
  text-align: center;
}

.btn-secondary {
  background: linear-gradient(to right, #6c757d, #495057);
  border: none;
  margin-top: 1rem;
}

.btn-secondary:hover {
  transform: translateY(-2px);
  box-shadow: 0 5px 15px rgba(108, 117, 125, 0.4);
}
</style>
