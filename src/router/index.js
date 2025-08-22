// router/index.js
import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import FAQView from '../views/FAQView.vue';
import ContactView from '../views/ContactView.vue';
import DashboardView from '../views/DashboardView.vue';
import LoginView from '../views/LoginView.vue';
import RegistrationView from '../views/RegistrationView.vue';

const routes = [
    { path: '/', name: 'Home', component: HomeView },
    { path: '/faq', name: 'FAQ', component: FAQView },
    { path: '/contact', name: 'Contact', component: ContactView },
    { path: '/dashboard', name: 'Dashboard', component: DashboardView, meta: { requiresAuth: true } },
    { path: '/login', name: 'Login', component: LoginView },
    { path: '/registration', name: 'Registration', component: RegistrationView },
];

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes,
});

router.beforeEach((to, from, next) => {
    const requiresAuth = to.matched.some(record => record.meta.requiresAuth);
    const isAuthenticated = !!localStorage.getItem('jwt');

    if (requiresAuth && !isAuthenticated) {
        next('/login');
    } else {
        next();
    }
});

export default router;