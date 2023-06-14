<script setup lang="ts">
import IconReturn from '@/components/icons/IconReturn.vue';
import { useRouter } from 'vue-router'
import { reactive } from 'vue'
const router = useRouter()

const onReturn = () => {
	router.push('/administrator')
}

/*
  撤销场所码 表单
*/
const form1 = reactive({
  site_id : '',//场所码编号
  reason : '' //撤销理由
})

/*
  查看场所码 表单
*/
const form2 = reactive({
  site_id : ''//场所码编号
})


const onSubmit1 = () => {
	console.log(form1);
}

const onSubmit2 = () => {
  console.log(form2);
}

</script>

<template>
  <el-container>
    <el-header>
      <el-row>
        <el-col :span="3" class="icon" @click="onReturn">
        <IconReturn />
        </el-col>
        <el-col :span="21">
        <h1 class="title">场所码管理</h1>
        </el-col>
      </el-row>
    </el-header>
    <el-header class="header">
      <p class="text">收回已申请场所码</p>
    </el-header>
    <el-main class="main"> 
      <el-form :model="form1" class="form">
        <el-form-item label="场所码编号" class="formLabel">
          <el-input v-model="form1.site_id" class="input"></el-input>
        </el-form-item> 
        <el-form-item label="收回理由" class="formLabel">
          <el-input v-model="form1.reason" class="input" type="textarea" :rows="2"></el-input>
        </el-form-item> 
        <el-form-item class="submit_item">
          <el-button type="primary" class="submit" @click="onSubmit1">提交</el-button>
        </el-form-item> 
      </el-form>
    </el-main>
    <el-header class="header">
      <p class="text">查看场所码</p>
    </el-header>
    <el-main class="main"> 
      <el-form :model="form2" class="form">
        <el-form-item label="场所码编号" class="formLabel">
          <el-input v-model="form2.site_id" class="input"></el-input>
        </el-form-item> 
        <el-form-item class="submit_item2">
          <el-button type="primary" class="submit" @click="onSubmit2">查看详情</el-button>
        </el-form-item> 
      </el-form>
    </el-main>

  </el-container>
</template>

<style>
  .formLabel .el-form-item__label {
    font-size:24px;
    font-weight:400;
    color:black;
  }
  .el-input__inner {
  height: 40px;
  font-size: 20px;
}
.input {
  height:40px;
  font-size: 20px;
}
</style>


<style scoped>


.el-header{
  margin-left:-28px;
} 

.name{
  padding-left: 0px;
  padding-bottom: 30px;
  color: #666666;
}
.text {
  color:black;
  font-size:22px;
  font-weight: bold;
}
.boldtext {
  color:black;
  font-size:16px;
  font-weight:bold;
}
.title {
  color: #01a28c;
  font-size: 28px;
  margin: 0;
  padding: 0;
  display: flex;
  justify-content: left;
  align-items: center;

}

.select_item{
  height: 30px;
  line-height: 25px;
  font-size: 20px;
}
.header{
  height:8vh;
  padding-top:4vh;
}
.main {
  display: flex;
  
  align-items: center;
  flex-direction: column;
  height: auto;
  background-color: #D9D9D9;
  margin: 0 -32px;
  border-radius: 20px;
  height:auto;
  padding:2.5rem 1.5rem;
  margin:0 -32px;
}

.icon {
  display: flex;
  justify-content: left;
  align-items: center;
}

.form {
  font-size: 28px;
  line-height: 20vh;
}

.submit_item{
  padding-top: 10%;
  margin-bottom: 0;
}
.submit_item2{
  padding-top: 5%;
  margin-bottom: 0;
}

.submit {
	width: 100%;
	height: 3rem;
	margin: 0.3rem;
  font-size: 24px;
}

</style>
