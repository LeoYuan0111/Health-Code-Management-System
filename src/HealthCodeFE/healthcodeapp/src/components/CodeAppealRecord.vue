<script setup lang="ts">
import { reactive } from 'vue'
import { ref } from 'vue'


/* 管理者 健康码申诉 */
export interface Record {
	name : string , //申诉用户名
    color : string ,//申诉者当前健康码颜色(红/黄/绿）0/1/2
    reason : string , //申诉理由
    time : string //申诉时间
}

const props = defineProps<{
	record: Record
}>()
const form = reactive({
	result : true,
	reason : ''
})

const is_submit = ref(false)

</script>
<template>
	<el-row class="record">
		<el-row class="item-row" >
			<el-col :span="9"  class="item-title">
				申诉人姓名
			</el-col>
			<el-col :span="15" class="item">
				<!-- 2022-12-05 21:41:33 -->
				{{ props.record.name }}
			</el-col>
		</el-row>
		<el-row class="item-row" >
			<el-col :span="9"  class="item-title">
				健康码状态
			</el-col>
			<el-col :span="15" class="item">
				{{ props.record.color }}
			</el-col>
		</el-row>
		<el-row class="item-row" >
			<el-col :span="9"  class="item-title">
				申诉理由
			</el-col>
			<el-col :span="15" class="item">
				{{ props.record.reason }}
			</el-col>
		</el-row>
        <el-row class="item-row" >
			<el-col :span="9"  class="item-title" >
				申诉时间
            </el-col>
            <el-col :span="15" class="item">
                {{ props.record.time }}
            </el-col>
        </el-row>          		
		<el-row class="item-row">
			<el-col :span="9"  class="item-title">
				申诉意见
			</el-col>
			<el-col :span="15" class="item">
				<el-form :model="form" class="form">	
					<el-form-item class="formLabel">
					    <el-radio-group v-model="form.result">
							<el-radio :label="true">同意</el-radio>
							<el-radio :label="false">驳回</el-radio>
						</el-radio-group>
					</el-form-item>
				</el-form>
			</el-col>	
		</el-row>

		<el-form-item label="理由" class="formLabel item-row">
          <el-input v-model="form.reason" class="input"  type="textarea" :rows="2"></el-input>
        </el-form-item>

	<el-row>
	</el-row>
		<el-form-item class="submit_item">
			<el-button type="primary" class="submit" @click="is_submit = true">提交</el-button>
		</el-form-item>  
			<el-row class="agree-row tag" v-if="is_submit" align="right">
			<el-row v-if="form.result" class="agree">
				已同意
			</el-row>
			<el-row v-else class="reject">
				已驳回
			</el-row>
		</el-row>  
	</el-row>





</template>

<style>
  
</style>

<style scoped>
.formLabel /deep/ .el-form-item__label {
	font-size: 1.2rem;
	font-weight: bolder;
	color: #000;
  }
  
.el-radio /deep/ .el-radio__label{
	font-size:1.2rem !important;
}
.input {
  height:40px;
  font-size: 1.2rem;
}
.result {
	border-bottom: 1px solid black;
	width: 90%;
	height: 25%;
}
.record {
	width: 100%;
	height: 40vh;
	border-radius: 1rem;
	background-color: #a6ded7;
	display: flex;
	flex-direction: column;
	align-items: center;

}
.tag {
	height: 80%;
	border-radius: 0.2rem;
	font-size: 1.2rem;
	font-weight: bold;
	display: flex;
	justify-content: center;
	align-items: center;
	/* margin-top: 0.2rem; */
}

.agree {
	border: 0.2rem solid #13b928;
	color: #13b928;
}
.reject {
	border: 0.2rem solid #ff0000;
	color: #ff0000;
}

.item-row {
	height: 3.5vh;
	width: 95%;
	margin-top: 0.2rem;
}
.agree-row{
	height: 3.5vh;
	width: 95%;
	margin-top: 0.2rem;
	justify-content: right;
	padding-right: 10%;
}

.form {
	width: 100%;
}
.item-title {
	font-size: 1.2rem;
	font-weight: bolder;
	color: #000;
	justify-content: left;
	display: flex;
	flex-direction: row;
}
.item {
	font-size: 1.2rem;
	color: #666666;
	font-family: 'Consolas', sans-serif;
	justify-content: left;
	display: flex;
	flex-direction: row;
}
.submit_item{
  padding-top: 10%;
  margin-bottom: 0;
  align-items: center;
  justify-content: center;

}
.submit {
	width: 80%;
	height: 2.5rem;
	margin: 0 15%;
  	font-size: 1.3rem;

}
</style>
