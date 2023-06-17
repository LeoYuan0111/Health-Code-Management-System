<script setup lang="ts">
import IconReturn from '@/components/icons/IconReturn.vue';
import { useRouter } from 'vue-router'
import { reactive } from 'vue'
import { ElMessage } from 'element-plus';
const router = useRouter()

const onReturn = () => {
	router.push('/main')
}

/*
表格信息的问题:
    1.color是文本还是枚举
    2.加了user_name
*/
const form = reactive({
  user_name : '',//加了一条用户姓名，后端可以核对防止管理员输入出错
  user_id : '',
  phone: '',
  site_name: '',
  site_address: '',
  address: ''
})

const onSubmit = () => {
  let date = new Date();
  // form.time = date.toLocaleString();
	// console.log(form);
  ElMessage.success('提交成功')
}

</script>

<template>
  <el-container>
    <el-header >
      <el-row>
        <el-col :span="3" class="icon" @click="onReturn">
        <IconReturn />
        </el-col>
        <el-col :span="21">
        <h1 class="title">场所码申请</h1>
        </el-col>
      </el-row>
    </el-header>

    <el-main class="main"> 
      <el-form :model="form" class="form">
        <el-form-item label="用户姓名" class="formLabel">
          <el-input v-model="form.user_name" class="input"></el-input>
        </el-form-item> 
        <el-form-item label="身份证号" class="formLabel">
          <el-input v-model="form.user_id" class="input"></el-input>
        </el-form-item>
        <el-form-item label="身份证号" class="formLabel">
          <el-input v-model="form.user_id" class="input"></el-input>
        </el-form-item>
        <el-form-item label="单位名称" class="formLabel">
          <el-input v-model="form.site_name" class="input"></el-input>
        </el-form-item>
        <el-form-item label="单位地区" class="formLabel">
          <el-input v-model="form.site_address" class="input"></el-input>
        </el-form-item>
        <el-form-item label="详细地址" class="formLabel">
          <el-input v-model="form.address" class="input"></el-input>
        </el-form-item>
      </el-form>
    </el-main>
    <el-footer>
      <el-button type="primary" class="submit" @click="onSubmit">提交</el-button>
    </el-footer>
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
  font-size:16px;
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

.main {
  display: flex;
  
  align-items: center;
  flex-direction: column;
  height: 50vh;
  background-color: #D9D9D9;
  padding:40px 20px;
  margin: 80px -32px;
  border-radius: 20px;
}
.footer{
  display: flex;
  justify-content: end;
  align-items: center;
  flex-direction: column;
  height: auto;
  padding:15px;
}

.icon {
  display: flex;
  justify-content: left;
  align-items: center;
}
.iconbig {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 60%;
}

.form {
  font-size: 28px;
}

.submit {
	width: 100%;
	height: 3rem;
	margin: 0.5rem auto;
  font-size: 24px;
}

</style>
