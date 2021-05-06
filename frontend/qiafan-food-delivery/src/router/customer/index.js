import Vue from 'vue';
import VueRouter from 'vue-router';
import BusinessCardList from '@/views/customer/index/BusinessCardList';
import Business from "@/views/customer/index/Business";
import Home from "@/views/customer/home/Home";
import OrderCardList from "@/views/customer/order/OrderCardList";
import CashFlowList from "@/views/customer/order/CashFlowList";
import Charge from "@/views/customer/order/Charge";

Vue.use(VueRouter);

const routes = [
  {
    path: '/customer',
    redirect: "/customer/index"
  },
  {
    path: "/customer/index",
    name: "BusinessCardList",
    component: BusinessCardList
  },
  {
    path: "/customer/order",
    name: "OrderCardList",
    component: OrderCardList
  },
  {
    path: "/customer/home",
    name: "UserHome",
    component: Home
  },
  {
    path: "/customer/finance",
    name: "CashFlowList",
    components:{
      globalFullScreen: CashFlowList
    }
  },
  {
    path: "/customer/charge",
    name: "Charege",
    components: {
      globalFullScreen: Charge
    }
  },
  {
    path: "/customer/business/:businessId",
    name: "BusinessWithId",
    components: {
      globalFullScreen: Business
    }
  }
  //,
  //{
    //path: '/about',
    //name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    //// which is lazy-loaded when the route is visited.
    //component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  //}
];

const customerRouter = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default customerRouter;
