<template>
	<ul class="infinite-list"
	v-infinite-scroll="load" 
	:infinite-scroll-disabled="scrollDisabled">
		<router-link 
		v-for="item in items" 
		:key="item[keyName]" 
		:to="toURL(item.id)" 
		custom v-slot="{navigate}"
		class="infinite-list-item">
			<li @click="navigate">
				<slot :item="item"></slot>
			</li>
		</router-link>
	</ul>
</template>
<script type="text/javascript">
import Vue from 'vue';
import InfiniteScroll from "element-ui";
Vue.use(InfiniteScroll);
export default {
	name: "InfiniteNavigatableScrollList",
	props:["items", "load", "url", "keyName"],
	data() {
		return {
			loading: false
		}
	},
	methods: {
		toURL(id) {
			return this.url + '/' + id;
		},
		loadMore() {
			this.loading = true;
			this.load();
		}
	},
	computed: {
		scrollDisabled() {
			return this.loading;
		}
	}
}
</script>
<style type="text/css">
.infinite-list {
	height: 100%;
	padding: 1em 1em 0 1em;
	margin-top: 0;
	overflow: auto;
}
.infinite-list-item {
	margin-bottom: 0.5em;
}
</style>