<template>
	<div class="order-card-list">
		<infinite-navigatable-scroll-list
		:items="cards"
		key-name="id"
		:load="getOrders"
		url="/customer/order">
			<template v-slot="{item}">
				<order-card :card-info="item"></order-card>
			</template>
		</infinite-navigatable-scroll-list>
	</div>
</template>
<script type="text/javascript">
import InfiniteNavigatableScrollList from "@/components/customer/common/InfiniteNavigatableScrollList";
import OrderCard from "@/components/customer/order/OrderCard";
export default {
	name: "OrderCardList",
	data() {
		return {
			cards: [{id:1,businessName:"常德牛肉粉1", avast:"",orderItems:[]}],
			start: 0,
			range: 10
		}
	},
	methods:{
		getOrders() {

		}
	},
	components:{
		"infinite-navigatable-scroll-list": InfiniteNavigatableScrollList,
		"order-card": OrderCard
	}
}
</script>