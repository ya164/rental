<template>
  <div class="dashboard">
    <div class="container">
      <div class="welcome">
        <h3 class="welcome__title">Ласкаво просимо, {{ user.name }}!</h3>
        <p class="welcome__subtitle">Ось ваші останні активності.</p>
      </div>

      <div class="stats">
        <div class="stat-card">
          <div class="stat-card__header">
            <div class="stat-card__icon">📅</div>
            <h4 class="stat-card__title">Активних оренд</h4>
          </div>
          <div class="stat-card__value">{{ activeRentals }}</div>
        </div>
        <div class="stat-card">
          <div class="stat-card__header">
            <div class="stat-card__icon">💵</div>
            <h4 class="stat-card__title">Загальний дохід</h4>
          </div>
          <div class="stat-card__value">${{ totalIncome }}</div>
        </div>
        <div class="stat-card">
          <div class="stat-card__header">
            <div class="stat-card__icon">⭐</div>
            <h4 class="stat-card__title">Рейтинг</h4>
          </div>
          <div class="stat-card__value">{{ rating }}</div>
        </div>
      </div>

      <section class="rentals">
        <h2 class="section-title">Ваші Оренди</h2>
        <div class="grid">
          <div v-for="rental in rentals" :key="rental.id" class="rental-item">
            <div class="rental-item__header">
              <h4 class="rental-item__title">{{ rental.carName }}</h4>
              <span :class="`rental-item__status ${rental.status.toLowerCase()}`">{{ rental.status }}</span>
            </div>
            <p class="rental-item__details">Дата початку: {{ rental.startDate }}</p>
            <p class="rental-item__details">Дата завершення: {{ rental.endDate }}</p>
          </div>
        </div>
      </section>

      <section class="expenses">
        <h2 class="section-title">Ваші Витрати</h2>
        <table class="expenses-table">
          <thead>
          <tr>
            <th>Дата</th>
            <th>Категорія</th>
            <th>Сума</th>
            <th>Опис</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="expense in expenses" :key="expense.id">
            <td>{{ expense.date }}</td>
            <td>{{ expense.category }}</td>
            <td>${{ expense.amount }}</td>
            <td>{{ expense.description }}</td>
          </tr>
          </tbody>
        </table>
        <div class="expenses-chart">
          <!-- Ваш графік або компонент -->
          <div class="chart-placeholder">Графік буде тут</div>
        </div>
      </section>
    </div>
  </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex'

export default {
  name: 'DashboardView',
  computed: {
    ...mapGetters(['user', 'activeRentals', 'totalIncome', 'rating', 'rentals', 'expenses'])
  },
  created() {
    this.fetchUserData()
  },
  methods: {
    ...mapActions(['fetchUserData'])
  }
}
</script>

<style scoped>
.rental-item__status {
  text-transform: uppercase;
}

.rental-item__status.success {
  background: var(--success);
}

.rental-item__status.cancelled {
  background: var(--danger);
}

.rental-item__status.pending {
  background: var(--warning);
}

.expenses-table th {
  background: var(--gray-100);
}

.expenses-table td {
  color: var(--gray-800);
}

.chart-placeholder {
  padding: 2rem;
  border: 2px dashed var(--gray-300);
  border-radius: var(--radius-sm);
  color: var(--gray-500);
  font-style: italic;
}
</style>
