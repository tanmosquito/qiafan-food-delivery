<template>
	<el-card class="order-card">
		<div>
			<section>
				<header>
					<div class="business-info">
						<img :src="cardInfo.avast">
						<span class="business-name">{{cardInfo.businessName}}</span>
					</div>
					<div class="order-state">已完成</div>
				</header>
				<ul class="order-item">
					<li 
					v-for="item in cardInfo.orderItems"
					:key="item.id"
					class="order-item">
						{{item.id}}
					</li>
				</ul>
				
				<footer @click.stop>
					<el-row>
						<el-button>取消订单</el-button>
						<el-button>再来一单</el-button>
						<el-button type="primary">确认送达</el-button>
					</el-row>
				</footer>
				
			</section>
		</div>
	</el-card>
</template>
<script type="text/javascript">
import {Card, Button} from "element-ui";
export default {
	name: "OrderCard",
	props:["cardInfo"],
	components: {
		"el-card": Card,
		"el-button": Button
	}
}
</script>
<style type="text/css" scoped>
.order-card header {
	line-height: 1.5em;
	margin-bottom: 1em;
	overflow: auto;
}
.order-card .business-info {
	float: left;
}
.order-card .business-info img {
	width:  1.5em;
	height: 1.5em;
	vertical-align: bottom;
	margin-right: 0.5em;
}
.order-card .order-state {
	font-size: 0.8em;
	float: right;
}
.order-card .el-button {
	font-size: 0.8em;
	padding:  0.5em 0.7em;
	float: right;
}
.order-card footer {
	overflow: auto;
}
</style>