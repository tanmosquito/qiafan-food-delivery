<template>
	<div :class="['sublist-wrapper',{'pinned': currentOnTop}]">
		<div class="sublist-title">{{sublistData.title}}</div>
		<ul>
			<li v-for="listItem,index in sublistData.list" :key="index">{{listItem}}</li>
		</ul>
	</div>
</template>
<script type="text/javascript">
export default {
	name: "MenuSublist",
	props: ["sublistData", "currentOnTop"]
}
</script>
<style type="text/css">

.sublist-wrapper .sublist-title {
	position: relative;
	background-color: whitesmoke;
	line-height: 2em;
}
.sublist-wrapper.pinned .sublist-title {
	position: absolute;
	top: 0;
	left: 0;
	right: 0;
}
.sublist-wrapper.pinned ul{
	padding-top: 2em;
}
.sublist-wrapper {
	padding-bottom: 1em;
}
.sublist-wrapper ul li {
	padding:  0.5em;
}
</style>