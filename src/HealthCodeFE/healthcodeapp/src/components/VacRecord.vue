<script setup lang="ts">
export interface Record {
	vacnum: string,
	name: string,
	time: string,
	site: string,
}

const props = defineProps<{
	record: Record
}>()

</script>
<template>
	<el-row class="record">
		<el-row class="result" justify="space-between" align="middle">
			<el-col :span="10" class="title">
				{{ props.record.vacnum }}
			</el-col>
		</el-row>
		<el-row class="item-row" >
			<el-col :span="8"  class="item-title">
				疫苗名称：
			</el-col>
			<el-col :span="16" class="item">
				<!-- 2022-12-05 21:41:33 -->
				{{ props.record.name }}
			</el-col>
		</el-row>
		<el-row class="item-row" >
			<el-col :span="8"  class="item-title">
				检测时间：
			</el-col>
			<el-col :span="16" class="item">
				<!-- 2022-12-05 21:41:33 -->
				{{ props.record.time }}
			</el-col>
		</el-row>
		<el-row class="item-row" >
			<el-col :span="8"  class="item-title">
				检测地点：
			</el-col>
			<el-col :span="16" class="item">
				<!-- 2022-12-05 21:41:33 -->
				{{ props.record.site }}
			</el-col>
		</el-row>
	</el-row>
</template>
<style scoped>
.result {
	border-bottom: 1px solid black;
	width: 90%;
	height: 25%;
}
.record {
	width: 100%;
	height: 18vh;
	border-radius: 1rem;
	background-color: #a6ded7;
	display: flex;
	flex-direction: column;
	justify-content: start;
	align-items: center;
}
.title {
	font-size: 1.3rem;
	font-weight: bolder;
	color: #000;
	text-align: left;
	align-items: center;
	justify-content: left;
	display: flex;
	flex-direction: row;
}

.item-row {
	height: 20%;
	width: 90%;
	margin-top: 0.1rem;
}

.item-title {
	font-size: 1rem;
	font-weight: bolder;
	color: #000;
	text-align: left;
	align-items: center;
	justify-content: left;
	display: flex;
	flex-direction: row;
}
.item {
	font-size: 1rem;
	color: #666666;
	font-family: 'Consolas', sans-serif;
	text-align: left;
	align-items: center;
	justify-content: right;
	display: flex;
	flex-direction: row;
}
</style>
