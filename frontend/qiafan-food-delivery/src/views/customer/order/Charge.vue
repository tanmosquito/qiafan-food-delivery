<template>
	<div class="charge">
		<content-frame-with-navigatable-title-bar title="充值">
			<el-card>
				<header>充值金额</header>
				<el-row class="amount">
					<el-col :span="2">
						<label class="currency-label">¥</label>
					</el-col>
					<el-col :span="22">
						<input type="number" class="amount-input">
					</el-col>
				</el-row>
				<div class="charge-btn">
					<el-button type="primary">充值</el-button>
				</div>
			</el-card>
		</content-frame-with-navigatable-title-bar>
	</div>
</template>
<script type="text/javascript">
import {Button, Card, Row, Col} from "element-ui";

import ContentFrameWithNavigatableTitleBar from "@/components/customer/common/ContentFrameWithNavigatableTitleBar";

export default {
	data() {
		return {
			amount: 0
		}
	},
	components: {
		"el-button": Button,
		"el-card": Card,
		"el-row": Row,
		"el-col": Col,
		"content-frame-with-navigatable-title-bar": ContentFrameWithNavigatableTitleBar
	}
}
</script>
<style type="text/css" scoped>
.charge header {
	margin-bottom: 1em;
}
.charge .amount {
	font-size: 2em;
}
.charge .amount .amount-input {
	width: 100%;
	line-height: 1em;
	font-size: inherit;
	border-top: none;
	border-left: none;
	border-right: none;
	border-radius: 0;
	box-sizing: border-box;
	padding: 0 0.5em;
	outline: 0;
}
.charge .amount .currency-label {
	vertical-align: bottom;
}
.charge-btn {
	margin-top: 1em;
}
.charge .el-card {
	margin: 1em;
}
.charge .el-card .el-button {
	width: 100%;
}
</style>