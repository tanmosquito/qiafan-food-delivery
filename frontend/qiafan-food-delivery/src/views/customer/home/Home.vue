<template>
	<div class="home">
		<header>
			<nav></nav>
			<div class="user-introduction">
				<img src="">
				<span :class="['nickname', {elipse: isNicknameOverflow}]">{{userBriefInfo.nickname}}</span>
			</div>
		</header>
		<el-card>
			<section>
				<header>
					<span class="wallet-title">我的钱包</span>
				</header>
				<div class="balance">
					<el-row><span class="title">余额（元）</span></el-row>
					<el-row class="amount"><span>100.00</span></el-row>
				</div>
				<div class="action">
					<el-row :gutter="10">
						<router-link custom 
						to="/customer/finance" 
						v-slot="{navigate}">
							<el-col :span=12 @click.native="navigate">
								<el-button>明细</el-button>
							</el-col>
						</router-link>
						<router-link custom 
						to="/customer/charge" 
						v-slot="{navigate}">
							<el-col :span=12 @click.native="navigate">
								<el-button type="primary">充值</el-button>
							</el-col>
						</router-link>
					</el-row>
				</div>
			</section>
		</el-card>
	</div>
</template>
<script type="text/javascript">
import {Card, Row, Col, Button} from "element-ui";
export default {
	name: "Home",
	data() {
		return {
			userBriefInfo:{
				nickname: "nickname123"
			},
			walletBriefInfo:{}
		}
	},
	computed: {
		isNicknameOverflow(){
			return this.userBriefInfo.nickname.length > 10;
		}
	},
	components: {
		"el-card": Card,
		"el-row": Row,
		"el-col": Col,
		"el-button": Button
	}
}
</script>
<style type="text/css">
.home > header{
	background-color: whitesmoke;
	padding: 1em 1em 40px 1em;
}
.home .user-introduction {
	height: 2em;
	line-height: 2em;
	overflow: auto;
}
.home .user-introduction > img{
	width: 2em;
	height: 2em;
	vertical-align: bottom;
	margin-right: 0.5em;
	float: left;
}
.home .user-introduction > .nickname {
	width: 11em;
	height: 2em;
	overflow: hidden;
	float: left;
}
.home .user-introduction > .elipse::before {
	content: "...";
	float: right;
}
.home .el-card {
	margin: -20px 1em 1em 1em;
}
.home .el-card header {
	margin-bottom: 0.6em;
	overflow: auto;
}
.home .balance {
	margin-bottom: 0.6em;
}
.home .balance .title {
	font-size: 0.6em;
}
.home .balance .amount{
	font-size: 1.4em;
	text-align: center;
}
.home .action .el-button {
	width: 100%;
}

</style>