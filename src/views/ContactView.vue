<template>
  <div class="contact">
    <div class="container">
      <h2 class="section-title">Контакти</h2>
      <div class="contact-form">
        <form @submit.prevent="submitForm">
          <div class="form-group">
            <label for="name">Ім'я</label>
            <input type="text" v-model="form.name" class="form-control" id="name" placeholder="Ваше ім'я" required />
          </div>
          <div class="form-group">
            <label for="email">Email</label>
            <input type="email" v-model="form.email" class="form-control" id="email" placeholder="Ваш email" required />
          </div>
          <div class="form-group">
            <label for="message">Повідомлення</label>
            <textarea v-model="form.message" class="form-control" id="message" rows="5" placeholder="Ваше повідомлення" required></textarea>
          </div>
          <button type="submit" class="btn btn-primary">Надіслати</button>
        </form>
      </div>
      <div class="contact-info">
        <h3>Наші Контакти</h3>
        <p>Email: support@rentalsystem.com</p>
        <p>Телефон: +38 123 456 789</p>
        <p>Адреса: вул. Приклад, 1, Київ, Україна</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ContactView',
  data() {
    return {
      form: {
        name: '',
        email: '',
        message: ''
      }
    }
  },
  methods: {
    submitForm() {
      // Обробка форми (відправка на сервер)
      alert('Ваше повідомлення надіслано!')
      this.form.name = ''
      this.form.email = ''
      this.form.message = ''
    }
  }
}
</script>

<style scoped>
.contact-form {
  max-width: 600px;
  margin: 0 auto 3rem;
}

.contact-info {
  text-align: center;
}

.contact-info h3 {
  margin-bottom: 1rem;
  color: var(--primary-color);
}
</style>
