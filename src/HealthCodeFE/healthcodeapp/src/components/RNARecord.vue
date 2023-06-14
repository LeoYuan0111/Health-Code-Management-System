<script setup lang="ts">
export interface Record {
	result: boolean,
	time: string,
	sample_time: string
}

const props = defineProps<{
	record: Record
}>()

</script>
<template>
	<el-row class="record">
		<el-row class="result" justify="space-between" align="middle">
			<el-col :span="10" class="title">
				检测结果
			</el-col>
			<el-col v-if="props.record.result" :span="8" class="result-tag negative">
				阴性
			</el-col>
			<el-col v-else :span="8" class="result-tag positive">
				阳性
			</el-col>
		</el-row>
		<el-row class="time-row" >
			<el-col :span="8"  class="time-title">
				检测时间：
			</el-col>
			<el-col :span="16" class="time">
				<!-- 2022-12-05 21:41:33 -->
				{{ props.record.time }}
			</el-col>
		</el-row>
		<el-row class="time-row">
			<el-col :span="8"  class="time-title">
				采样时间：
			</el-col>
			<el-col :span="16" class="time">
				<!-- 2022-12-05 17:12:16 -->
				{{ props.record.sample_time }}
			</el-col>
		</el-row>
	</el-row>
</template>
<style scoped>
.result {
	border-bottom: 1px solid black;
	width: 90%;
	height: 33%;
}
.record {
	width: 100%;
	height: 15vh;
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
.result-tag {
	height: 80%;
	border-radius: 0.2rem;
	font-size: 1.2rem;
	font-weight: bold;
	display: flex;
	justify-content: center;
	align-items: center;
	/* margin-top: 0.2rem; */
}

.negative {
	border: 0.2rem solid #13b928;
	color: #13b928;
}
.positive {
	border: 0.2rem solid #ff0000;
	color: #ff0000;
}
.time-row {
	height: 25%;
	width: 90%;
	margin-top: 0.2rem;
}

.time-title {
	font-size: 1rem;
	font-weight: bolder;
	color: #000;
	text-align: left;
	align-items: center;
	justify-content: left;
	display: flex;
	flex-direction: row;
}
.time {
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
