<script setup lang="ts">
import { reactive } from 'vue'
import { ref } from 'vue'


/* 管理者 场所码查询 */
export interface Record {
    //申请人信息
    user_name : string , 
    user_id : string ,
    user_phone : string ,
    //场所信息
    place_name : string ,
    place_city : string ,
    place_addr : string
}

const props = defineProps<{
	record: Record
}>()


</script>


<template>
    
	<el-row class="record">
        <el-row class="title" justify="start">
            申请人信息
        </el-row>
		<el-row class="item-row" >
			<el-col :span="8"  class="item">
				姓名
			</el-col>
			<el-col :span="16" class="item">
				<!-- 2022-12-05 21:41:33 -->
				{{ props.record.user_name }}
			</el-col>
		</el-row>
		<el-row class="item-row" >
			<el-col :span="8"  class="item">
				身份证号
			</el-col>
			<el-col :span="16" class="item">
				{{ props.record.user_id }}
			</el-col>
		</el-row>
		<el-row class="item-row" >
			<el-col :span="8"  class="item">
				联系电话
			</el-col>
			<el-col :span="16" class="item">
				{{ props.record.user_phone }}
			</el-col>
		</el-row>
        <el-row class="title2">
            场所信息
        </el-row>
        <el-row class="item-row" >
			<el-col :span="8"  class="item" >
				单位名称
            </el-col>
            <el-col :span="16" class="item">
                {{ props.record.place_name }}
            </el-col>
        </el-row>          		
		<el-row class="item-row">
			<el-col :span="8"  class="item">
				省/市/区
			</el-col>
			<el-col :span="16" class="item">
				{{ props.record.place_city }}
			</el-col>	
		</el-row>
        <el-row class="item-row">
			<el-col :span="8"  class="item">
				详细地址
			</el-col>
			<el-col :span="16" class="item">
				{{ props.record.place_addr }}
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
	height: 3.5vh;
	width: 95%;
	margin-top: 0.2rem;
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
