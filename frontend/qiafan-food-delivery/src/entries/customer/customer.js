import Vue from 'vue';
import App from '../../views/customer/App.vue';
import router from '../../router/customer';

//Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
