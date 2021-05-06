<template>
	<div class="business-list">
		<infinite-navigatable-scroll-list
		:items="cards" 
		key-name="id" 
		:load="getBusinessList" 
		url="/customer/business">
			<template v-slot="{item}">
				<business-card :card-info="item"></business-card>
			</template>
		</infinite-navigatable-scroll-list>
	</div>
</template>
<script type="text/javascript">
import InfiniteNavigatableScrollList from "@/components/customer/common/InfiniteNavigatableScrollList";
import BusinessCard from "@/components/customer/home/BusinessCard";
export default {
	components: {
		"infinite-navigatable-scroll-list":InfiniteNavigatableScrollList,
		"business-card": BusinessCard
	},
	data() {
		return {
			cards:[],
			start:0,
			range:0
		}
	},
	methods: {
		getBusinessList() {
			var id = this.cards.length;
			if(this.cards.length >= 10) return;
			this.cards.push(
				{id:id,name:"常德牛肉粉", avast: null, rate: 4.5, deliveryCost: 5.00, minimumOrder: 20.00, currency: "CNY"}
			);                         
		}
	}
}
</script>
<style type="text/css">
</style>