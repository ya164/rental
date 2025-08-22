<template>
  <div class="home">
    <section class="hero">
      <div class="container hero__container">
        <div class="hero__content">
          <h1 class="hero__title">
            Ефективна система <span class="highlight">управління орендою</span>
          </h1>
          <p class="hero__description">
            Зручний облік об'єктів оренди, контроль статусів, історія операцій
            та фінансова аналітика в одному місці.
          </p>
          <div class="hero__cta">
            <router-link to="/registration" class="btn btn--primary btn--lg">Створити акаунт</router-link>
            <router-link to="/#features" class="btn btn--text">Дізнатися більше</router-link>
          </div>
          <div class="hero__stats">
            <div class="stat-item">
              <span class="stat-item__number">1000+</span>
              <span class="stat-item__label">Активних об'єктів</span>
            </div>
            <div class="stat-item">
              <span class="stat-item__number">500+</span>
              <span class="stat-item__label">Користувачів</span>
            </div>
            <div class="stat-item">
              <span class="stat-item__number">2000+</span>
              <span class="stat-item__label">Орендних записів</span>
            </div>
          </div>
        </div>
        <div class="hero__image">
          <!-- hero-image видалено, floating-cards залишені -->
          <div class="floating-cards">
            <div class="float-card float-card--1">
              <div class="float-card__icon">👤</div>
              <div class="float-card__text">Особистий кабінет</div>
            </div>
            <div class="float-card float-card--2">
              <div class="float-card__icon">📊</div>
              <div class="float-card__text">Фінансовий підсумок</div>
            </div>
            <div class="float-card float-card--3">
              <div class="float-card__icon">📝</div>
              <div class="float-card__text">Облік об'єктів</div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- Решта секцій (features, how, cta) з вашого HTML коду -->
    <section class="features" id="features">
      <div class="container">
        <h2 class="section-title">Основні можливості</h2>
        <div class="features-grid">
          <div class="feature-card">
            <div class="feature-card__icon">🔐</div>
            <h3 class="feature-card__title">Авторизація</h3>
            <p>
              Безпечна реєстрація та вхід через логін і пароль. Надійне зберігання даних користувачів.
            </p>
          </div>
          <div class="feature-card">
            <div class="feature-card__icon">📦</div>
            <h3 class="feature-card__title">Облік об'єктів</h3>
            <p>
              Контроль статусів об'єктів: доступно, зайнято, на обслуговуванні. Повна історія використання.
            </p>
          </div>
          <div class="feature-card">
            <div class="feature-card__icon">👤</div>
            <h3 class="feature-card__title">Особистий кабінет</h3>
            <p>
              Управління особистими даними, перегляд історії та активних оренд. Редагування контактної інформації.
            </p>
          </div>
          <div class="feature-card">
            <div class="feature-card__icon">💰</div>
            <h3 class="feature-card__title">Фінансовий облік</h3>
            <p>
              Підрахунок загальної вартості оренд за період. Аналіз витрат за місяць або рік.
            </p>
          </div>
        </div>
      </div>
    </section>

    <section class="how" id="how">
      <div class="container">
        <h2 class="section-title">Як користуватись системою</h2>
        <div class="steps">
          <div class="step">
            <div class="step__number">1</div>
            <h3 class="step__title">Реєстрація</h3>
            <p>Створіть обліковий запис</p>
          </div>
          <div class="step">
            <div class="step__number">2</div>
            <h3 class="step__title">Вибір об'єкта</h3>
            <p>Оберіть доступний об'єкт</p>
          </div>
          <div class="step">
            <div class="step__number">3</div>
            <h3 class="step__title">Оренда</h3>
            <p>Створіть запис оренди</p>
          </div>
          <div class="step">
            <div class="step__number">4</div>
            <h3 class="step__title">Контроль</h3>
            <p>Відстежуйте статус</p>
          </div>
        </div>
      </div>
    </section>

    <section class="cta">
      <div class="container">
        <div class="cta__content">
          <h2 class="cta__title">Спробуйте безкоштовно</h2>
          <p class="cta__text">Створіть обліковий запис та оцініть всі можливості системи</p>
          <router-link to="/registration" class="btn btn--primary btn--lg">Створити акаунт</router-link>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
export default {
  name: 'HomeView'
}
</script>

<style scoped>
/* Додаткові стилі для HomeView за потребою */
</style>
