<template>
  <div class="faq">
    <div class="container">
      <h2 class="section-title">Часті Питання</h2>
      <div class="faq-list">
        <div class="faq-item" v-for="faq in faqs" :key="faq.id">
          <h3 class="faq-item__question">{{ faq.question }}</h3>
          <p class="faq-item__answer">{{ faq.answer }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'FAQView',
  data() {
    return {
      faqs: [
        {
          id: 1,
          question: 'Як зареєструватися на RentalSystem?',
          answer: 'Натисніть кнопку "Реєстрація" у хедері та заповніть форму з вашими даними.'
        },
        {
          id: 2,
          question: 'Чи можна змінити бронювання?',
          answer: 'Так, ви можете змінити своє бронювання у вашому кабінеті користувача.'
        },
        // Додайте більше питань за потребою
      ]
    }
  }
}
</script>

<style scoped>
.faq-item__question {
  color: var(--primary-color);
}

.faq-item__answer {
  color: var(--text-secondary);
}
</style>
