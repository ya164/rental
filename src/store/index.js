import { createStore } from 'vuex';
import axios from '../axios';
import createPersistedState from 'vuex-persistedstate';

export default createStore({
    plugins: [createPersistedState()],
    state: {
        user: null,
        token: localStorage.getItem('jwt') || null,
    },
    getters: {
        isAuthenticated: state => !!state.token,
        user: state => state.user,
    },
    mutations: {
        setUser(state, user) {
            state.user = user;
        },
        setToken(state, token) {
            state.token = token;
            localStorage.setItem('jwt', token);
        },
        clearAuth(state) {
            state.user = null;
            state.token = null;
            localStorage.removeItem('jwt');
        },
    },
    actions: {
        async login({ commit }, credentials) {
            try {
                const response = await axios.post('/auth/login', credentials);
                commit('setToken', response.data.token);
                commit('setUser', response.data.user);
            } catch (error) {
                console.error('Login failed:', error.response?.data || error.message);
                throw error;
            }
        },
        async register(_, userData) { // Видалено `commit`, якщо він не потрібен
            try {
                await axios.post('/auth/register', userData);
            } catch (error) {
                console.error('Registration failed:', error.response?.data || error.message);
                throw error;
            }
        },
        async fetchUser({ commit }) {
            try {
                const response = await axios.get('/users/profile');
                commit('setUser', response.data);
            } catch (error) {
                console.error('Fetching user failed:', error.response?.data || error.message);
            }
        },
        logout({ commit }) {
            commit('clearAuth');
        },
    },
});
