<template>
	<div class="menu-list">
		<div class="tags">
			<ul>
				<li :class="['tag',{'pinned-tag': index === currentOnTopIndex}]" 
				v-for="menu,index of menus"
				:key="index"
				@click="onTagClick(index)"
				>{{menu.title}}</li>
			</ul>
		</div>
		<div class="sublist-title-pin-bord">
			<div class="sublists" 
			@scroll="updatePinTitle"
			ref="sublistsScroller">
				<div class="sublists-wrapper">
					<template v-for="menu,index in menus">
						<menu-sublist :sublist-data="menu" :current-on-top="currentOnTopIndex === index"
						:key="index"
						ref="sublist">
						</menu-sublist>
					</template>
				</div>
			</div>
		</div>
	</div>
</template>
<script type="text/javascript">
import MenuSublist from "@/components/customer/home/MenuSublist";
export default {
	name: "MenuListWithTag",
	props: [],
	data() {
		return {
			menus: [
				{
					title: "爆品菜款",
					list: ["小炒肉","小炒肉","小炒肉","小炒肉","小炒肉","小炒肉","小炒肉","小炒肉","小炒肉","小炒肉","小炒肉","小炒肉","小炒肉"]
				},
				{
					title: "今日招牌",
					list: ["干锅花菜","干锅花菜","干锅花菜","干锅花菜","干锅花菜","干锅花菜","干锅花菜","干锅花菜","干锅花菜","干锅花菜","干锅花菜","干锅花菜","干锅花菜"]
				},
				{
					title: "特惠菜品",
					list: ["小炒海带","小炒海带","小炒海带","小炒海带","小炒海带","小炒海带","小炒海带","小炒海带","小炒海带","小炒海带","小炒海带","小炒海带","小炒海带"]
				},
				{
					title: "每日小菜",
					list: ["凉拌青瓜","凉拌青瓜","凉拌青瓜","凉拌青瓜","凉拌青瓜","凉拌青瓜","凉拌青瓜","凉拌青瓜","凉拌青瓜","凉拌青瓜","凉拌青瓜","凉拌青瓜","凉拌青瓜","凉拌青瓜","凉拌青瓜",]
				}
			],
			currentOnTopIndex:0,
			topLevelWrapperRect:{}
		}
	},
	methods: {
		updatePinTitle() {
			let sublists = this.$refs.sublist;
			for(let i = 0; i < sublists.length; i++) {
				let sublist = sublists[i],
					sublistRect = sublist.$el.getBoundingClientRect();
				if((sublistRect.y - this.topLevelWrapperRect.y) <=0 && 
					(sublistRect.bottom - this.topLevelWrapperRect.y) >= 0) {
					this.currentOnTopIndex = i;
				}
			}
		},
		onTagClick(index) {
			this.currentOnTopIndex = index;
			let sublistRect = this.$refs["sublist"][index].$el.getBoundingClientRect();
			if(sublistRect.y < 0) {
				this.$refs["sublistsScroller"].scrollBy(0,sublistRect.y);
			} else {
				this.$refs["sublistsScroller"].scrollBy(0,sublistRect.y - this.topLevelWrapperRect.y);
			}
		}
	},
	mounted() {
		this.topLevelWrapperRect = this.$el.getBoundingClientRect();
	},
	components: {
		"menu-sublist": MenuSublist
	}
}
</script>
<style type="text/css" scoped>
.menu-list {
	height: 100%;
	overflow: hidden;
	position: relative;
}
.menu-list .tags {
	height: 100%;
	width: 70px;
	overflow: auto;
	float: left;
}
.menu-list .tags ul li.pinned-tag {
	background-color: whitesmoke;
}
.menu-list .sublist-title-pin-bord {
	height: 100%;
	overflow: hidden;
	position: relative;
}
.menu-list .sublist-title-pin-bord .sublists {
	height: 100%;
	overflow: auto;
}

</style>