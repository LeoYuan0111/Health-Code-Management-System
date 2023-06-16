<script setup lang="ts">
import { reactive } from 'vue'
import { ref } from 'vue'


/* 管理者 健康码申诉 */
export interface Record {
    tube_id : string , //试管号
    result : boolean , //检测结果 True-阴性 False-阳性
}

const props = defineProps<{
	record: Record
}>()

//撤销该实验的结果
const form = reactive({
    tube_id : props.record.tube_id
})

//撤销
const onCancel = () => {
	console.log(form);
}

</script>
<template>
    <el-row class="item-row" >
        <el-col :span="8"  class="item" >
            {{ props.record.tube_id }}
        </el-col>
        <el-col v-if="props.record.result " :span="8" class="item">
            阴性
        </el-col>
        <el-col v-else :span="8" class="item reditem" >
            阳性
        </el-col>
        <el-col :span="8" class="item">
            <el-button type="primary" class="submit" @click="onCancel">撤销</el-button>
        </el-col>
    </el-row>
    


</template>

<style>
  
</style>

<style scoped>


.item-row {
	height: 3.5vh;
	width: 100%;
	margin-top: 0.2rem;
    justify-content: center;
    display: flex;
	flex-direction: row;
	align-items: center;
    margin-top:0;
}
.reditem {
    color : red;
}

.form {
	width: 100%;
}
.item-title {
	font-size: 1.2rem;
	color: #000;
	justify-content: left;
	display: flex;
	flex-direction: row;
}

.item {
  text-align: center;
  font-size:1.3rem;
  font-weight: 500;
}
.submit_item{
  padding-top: 10%;
  margin-bottom: 0;
  align-items: center;
  justify-content: center;

}
.submit {
	width: 60%;
	height: 2.5rem;
	margin: 0 15%;
  	font-size: 1.3rem;

}
</style>
