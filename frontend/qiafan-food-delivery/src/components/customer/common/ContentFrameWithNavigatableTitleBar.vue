<template>
	<div class="content-frame">
		<navigatable-title-bar class="nav-bar">{{title}}</navigatable-title-bar>
		<div class="content-scroll-wrapper">
			<div class="content">
				<slot></slot>
			</div>
		</div>
	</div>
</template>
<script type="text/javascript">
import NavigatableTitleBar from "./NavigatableTitleBar";
export default {
	name: "ContentFrameWithNavigatableTitleBar",
	props:["title"],
	data() {
		return {
		}
	},
	components: {
		"navigatable-title-bar": NavigatableTitleBar
	}
}
</script>
<style type="text/css">
.content-frame {
	height: 100%;
	overflow: hidden;
	position: relative;
}
.content-frame .nav-bar {
	position: relative;
	top: 0;
	left: 0;
	right: 0;
}
.content-frame .content-scroll-wrapper {
	box-sizing: border-box;
	height: 100%;
	padding-bottom: 3em;
	overflow: hidden;
}
.content-frame .content-scroll-wrapper .content {
	height: 100%;
	overflow: auto;
}
</style>