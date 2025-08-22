<template>
  <div>
    <h1>Login</h1>
    <form @submit.prevent="handleLogin">
      <input v-model="email" type="email" placeholder="Email" required />
      <input v-model="password" type="password" placeholder="Password" required />
      <button type="submit">Login</button>
    </form>
    <p v-if="error">{{ error }}</p>
  </div>
</template>

<script>
import { mapActions } from 'vuex';

export default {
  data() {
    return {
      email: '',
      password: '',
      error: null,
    };
  },
  methods: {
    ...mapActions(['login']),
    async handleLogin() {
      try {
        await this.login({ email: this.email, password: this.password });
        this.$router.push('/dashboard');
      } catch (error) {
        this.error = 'Invalid credentials';
      }
    },
  },
};
</script>