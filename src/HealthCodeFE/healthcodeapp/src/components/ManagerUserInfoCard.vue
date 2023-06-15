<script setup lang="ts">
import { reactive } from 'vue'
import { ref } from 'vue'


/* 管理者 用户信息查询 */
export interface Record {
    //申请人信息
    name : string , 
	phone : string ,
    email : string ,
	addr : string ,
	health_code : string,
	RNA_result : string,
	RNA_time : string,
}

const props = defineProps<{
	record: Record
}>()


</script>


<template>
    
	<el-row class="record">
		<el-row class="item-row" >
			<el-col :span="8"  class="item">
				用户姓名
			</el-col>
			<el-col :span="16" class="item">
				<!-- 2022-12-05 21:41:33 -->
				{{ props.record.name }}
			</el-col>
		</el-row>
		<el-row class="item-row" >
			<el-col :span="8"  class="item">
				联系电话
			</el-col>
			<el-col :span="16" class="item">
				{{ props.record.phone }}
			</el-col>
		</el-row>
		<el-row class="item-row" >
			<el-col :span="8"  class="item">
				邮箱
			</el-col>
			<el-col :span="16" class="item">
				{{ props.record.email }}
			</el-col>
		</el-row>
        <el-row class="item-row" >
			<el-col :span="8"  class="item" >
				住址
            </el-col>
            <el-col :span="16" class="item">
                {{ props.record.addr }}
            </el-col>
        </el-row>          		
		<el-row class="item-row">
			<el-col :span="8"  class="item">
				健康码状态
			</el-col>
			<el-col :span="16" class="item">
				{{ props.record.health_code }}
			</el-col>	
		</el-row>

		<el-row class="item-row">
			<el-col :span="8"  class="item">
				最近核酸<br>采样时间
			</el-col>
			<el-col :span="16" class="item">
				{{ props.record.RNA_time }}
			</el-col>	
		</el-row>
		<el-row class="item-row">
			<el-col :span="8"  class="item">
				最近核酸<br>检测结果
			</el-col>
			<el-col :span="16" class="item">
				{{ props.record.RNA_result }}
			</el-col>	
		</el-row>
    </el-row>
</template>

<style>
  
</style>

<style scoped>


.record {
	width: 100%;
	height: auto;
	display: flex;
	flex-direction: column;

}
.title {
    font-size : 1.3rem;
    font-weight: bolder; 
}


.title2 {
    font-size : 1.3rem;
    font-weight: bolder;
    margin-top: 1.2rem;
}

.item-row {
	height: auto;
	width: 95%;
	margin-top: 0.2rem;
	display: flex;
	align-items:center;

}
.item {
	font-size: 1.2rem;
	color: #666666;
	font-family: 'Consolas', sans-serif;
	justify-content: left;
	display: flex;
	flex-direction: row;
}

</style>
