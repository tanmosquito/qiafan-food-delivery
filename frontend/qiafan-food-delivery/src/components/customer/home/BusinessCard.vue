<template>
	<el-card>
		<div class="business-card">
			<img :src="cardInfo.avast">
			<div class="business-info">
				<div class="business-name">
					{{cardInfo.name}}
				</div>
				<div class="business-rate">
					{{cardInfo.rate}}
				</div>
				<div class="business-delivery-cost">
					起送{{cardInfo.currency}}{{cardInfo.minimumOrder}} 配送费{{cardInfo.currency}}{{cardInfo.deliveryCost}}
				</div>
			</div>
		</div>
	</el-card>
</template>
<script type="text/javascript">
import {Card} from "element-ui";

export default {
	name: "BusinessCard",
	props: ["cardInfo"],
	components: {
		"el-card": Card
	}
};
</script>
<style scoped>
.business-card{
	/* 该样式为了让作为容器的元素与浮动内容一样高。 */
	overflow: auto;
}
.business-card img {
	width: 65px;
	height: 65px;
	margin-right: 1em;
	float: left;
}
.business-card .business-info{
	float: left;
}
.business-card .business-rate,
.business-card .business-delivery-cost {
	font-size: 12px;
}
</style>