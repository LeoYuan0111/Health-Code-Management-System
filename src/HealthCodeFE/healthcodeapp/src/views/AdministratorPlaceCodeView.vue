<script setup lang="ts">
import IconReturn from '@/components/icons/IconReturn.vue';
import { useRouter } from 'vue-router'
import { reactive } from 'vue'
const router = useRouter()

const onReturn = () => {
	router.push('/administrator')
}

/*
表格信息的问题:
    1.color是文本还是枚举
    2.加了user_name
*/
const form = reactive({
  user_name : '',//加了一条用户姓名，后端可以核对防止管理员输入出错
  user_id : '',
  color : '',
  reason : '',
  time : ''
})

const onSubmit = () => {
  let date = new Date();
  form.time = date.toLocaleString();
	console.log(form);
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
    <el-main class="main1"> 
      <el-form :model="form" class="form">
        <el-form-item label="场所码编号" class="formLabel">
          <el-input v-model="form.user_name" class="input"></el-input>
        </el-form-item> 
        <el-form-item label="收回理由" class="formLabel">
          <el-input v-model="form.reason" class="input" type="textarea" :rows="2"></el-input>
        </el-form-item> 
        <el-form-item class="submit_item">
          <el-button type="primary" class="submit" @click="onSubmit">提交</el-button>
        </el-form-item> 
      </el-form>
    </el-main>
    <el-header class="header">
      <p class="text">查看场所码</p>
    </el-header>
    <el-main class="main2"> 
      <el-form :model="form" class="form">
        <el-form-item label="场所码编号" class="formLabel">
          <el-input v-model="form.user_name" class="input"></el-input>
        </el-form-item> 
        <el-form-item class="submit_item">
          <el-button type="primary" class="submit" @click="onSubmit">提交</el-button>
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
.submit_item{
  padding-top: 10%;
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
  background-color: red;
}
.main1 {
  display: flex;
  
  align-items: center;
  flex-direction: column;
  height: auto;
  background-color: #D9D9D9;
  padding:5%;
  margin: 0 -32px;
  border-radius: 20px;
  height:35vh;
}

.main2 {
  display: flex;
  
  align-items: center;
  flex-direction: column;
  height: auto;
  background-color: #D9D9D9;
  padding:5%;
  margin: 0 -32px;
  border-radius: 20px;
  height:20vh;
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

.submit {
	width: 100%;
	height: 3rem;
	margin: 0.5rem auto;
  font-size: 24px;


}

</style>
