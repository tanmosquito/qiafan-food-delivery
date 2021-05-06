<template>
	<header class="navigatable-title-bar">
		<nav class="nav-arrow iconfont" @click="back">&#xe600;</nav>
		<div class="title"><slot></slot></div>
	</header>
</template>
<script type="text/javascript">
export default {
	methods: {
		back() {
			this.$router.go(-1);
		}
	}
}
</script>
<style type="text/css" scoped>
.navigatable-title-bar {
	line-height: 1em;
	font-size: 1em;
	text-align: center;
	background-color: whitesmoke;
	padding: 1em 1em;
	overflow: hidden;
}
.navigatable-title-bar .nav-arrow {
	position: absolute;
	width: 20px;
	height: 100%;
}
</style>