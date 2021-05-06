<template>
  <div id="app">
    <div class="main-view-container">
      <div class="view-container">
        <router-view></router-view>
      </div>
    </div>

  <transition name="global-full-screen">
    <router-view 
      class='global-full-screen-page-view'
      name='globalFullScreen' v-slot="{Component}">
      <component :is="Component" />
    </router-view>
  </transition>
    
    <el-row class="destinations">
      
      <router-link 
      to='/customer/index' 
      custom 
      v-slot="{navigate, isExactActive}">
        <el-col class='destination' 
        :span='8' 
        @click.native="navigate"
        :class="{active: isExactActive}">
          <div class="iconfont">&#xe608;</div>
          <div>首页</div>
        </el-col>
      </router-link>
      
      
      <router-link 
      to='/customer/order' 
      custom 
      v-slot="{navigate, isExactActive}">
        <el-col class='destination' 
        :span='8' 
        @click.native="navigate"
        :class="{active: isExactActive}">
          <div class="iconfont">&#xe60d;</div>
          <div>订单</div>
        </el-col>
      </router-link>
        
    
      <router-link 
      to='/customer/home' 
      custom 
      v-slot="{navigate, isExactActive}">
        <el-col class='destination' 
        :span='8'
        @click.native="navigate"
        :class="{active: isExactActive}">
          <div class="iconfont">&#xe60f;</div>
          <div>我的</div>
        </el-col>
      </router-link>

    </el-row>
  </div>
</template>

<script type="text/javascript">
  import "element-ui/lib/theme-chalk/index.css";
  import "@/assets/styles/reset.css";
  import "@/assets/styles/mobile-sepecific.css"

  import {Row, Col} from "element-ui";

  export default {
    components: {
      "el-row": Row,
      "el-col": Col
    },
    data() {
      return {
      }
    }
  };
</script>

<style>
#app {
  width: 100%;
  height: 100%;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  overflow: hidden;
  position: relative;
}


.destinations {
  width: 100%;
  height: 49px;
  border-top: solid ghostwhite 1px;
  position: fixed;
  bottom: 0;
  background-color: whitesmoke;
  text-align: center;
}

.destinations > .destination {
  height: 100%;
  font-size: 0.5em;
  display: flex;
  flex-flow: column;
  justify-content: center;
}
.destinations > .destination.active {
  color: lightblue;
}
.main-view-container{
  width: 100%;
  height: 100%;
  overflow: auto;
}
.main-view-container > .view-container {
  margin-bottom: 50px;
}

.global-full-screen-page-view {
  width: 100%;
  height: 100%;
  max-width: 100%;
  max-height: 100%;
  background-color: white;
  overflow: auto;
  position: fixed;
  top: 0;
  z-index: 999;
}
.global-full-screen-enter {
  right: -100%;
}
.global-full-screen-enter-active {
  transition: right 0.5s;
}
.global-full-screen-enter-to {
  right: 0;
}
.global-full-screen-leave {
  right: 0;
}
.global-full-screen-leave-active {
  transition: right 0.5s;
}
.global-full-screen-leave-to {
  right: -100%;
}
</style>
