<template>
	<div class="cash-flow-list">
		<content-frame-with-navigatable-title-bar title="账单">
			<ul v-infinite-scroll="getCashFlowRecords"
			infinite-scroll-disabled="disabled">
				<li class="cash-flow-record"
				v-for="record in records"
				:key="record.id">
					<span class="cash-flow-summary">{{record.summary}}</span>
					<span class="cash-flow-amount">{{record.amount}}</span>
				</li>
			</ul>
		</content-frame-with-navigatable-title-bar>
	</div>
</template>
<script type="text/javascript">
import Vue from "vue";
import InfiniteScroll from "element-ui";
import ContentFrameWithNavigatableTitleBar from "@/components/customer/common/ContentFrameWithNavigatableTitleBar";
Vue.use(InfiniteScroll);
export default {
	name: "CashFlowList",
	data() {
		return {
			records:[],
			disabled: false
		}
	},
	methods: {
		getCashFlowRecords() {
			var id = this.records.length;
			if(this.records.length >= 20) {
				this.disabled = true;
				return;
			}
			this.records.push(
				{id:id, summary:"充值", amount:"+100"}
			);       
		}
	},
	components: {
		"content-frame-with-navigatable-title-bar": ContentFrameWithNavigatableTitleBar
	}
}
</script>
<style type="text/css" scoped>
.cash-flow-list {
	width: 100%;
	height: 100%;
}
.cash-flow-list ul li {
	border-bottom: 1px solid #999;
	padding: 1em;
	overflow: auto;
}
.cash-flow-list ul li .cash-flow-amount {
	float: right;
}
</style>