<template>
	<div class="business">
		<content-frame-with-navigatable-title-bar title="常德牛肉粉">
			<menu-list-with-tag></menu-list-with-tag>
		</content-frame-with-navigatable-title-bar>
	</div>
</template>
<script type="text/javascript">
import ContentFrameWithNavigatableTitleBar from "@/components/customer/common/ContentFrameWithNavigatableTitleBar";
import MenuListWithTag from "@/components/customer/home/MenuListWithTag";

export default {
	name: "Business",
	components: {
		"content-frame-with-navigatable-title-bar": ContentFrameWithNavigatableTitleBar,
		"menu-list-with-tag": MenuListWithTag
	}
}
</script>
<style type="text/css" scoped>
	
</style>