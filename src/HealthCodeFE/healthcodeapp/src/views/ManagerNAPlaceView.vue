<script setup lang="ts">
import { ref } from 'vue'
import IconReturn from '@/components/icons/IconReturn.vue';
import { useRouter } from 'vue-router'
import { reactive } from 'vue'
import { ElMessage } from 'element-plus';

const router = useRouter()

const onReturn = () => {
	router.push('/manager')
}

/*
  查看场所码 表单
*/
const form1 = reactive({
  site_id : '',//场所码编号
})

/*
  修改场所码 表单
*/
const form2 = reactive({
  site_id : '',//场所码编号
  time : '' //采样时间
})


/*
  删除场所码 表单
*/
const form3 = reactive({
  site_id : '',//场所码编号
})


const is_submit1 = ref(false)


const onSubmit1 = () => {
  is_submit1.value = true;
	console.log(form1);
  ElMessage.success('提交成功')
}

const onSubmit2 = () => {
  console.log(form2);
  ElMessage.success('提交成功')
}

const onSubmit3 = () => {
  console.log(form3);
  ElMessage.success('提交成功')
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
        <h1 class="title">核酸采样地点管理</h1>
        </el-col>
      </el-row>
    </el-header>
    <el-header class="header">
      <p class="text">查看核酸采样点</p>
    </el-header>
    <el-main class="main"> 
      <el-form :model="form1" class="form">
        <el-form-item label="采样点名称" class="formLabel">
          <el-input v-model="form1.site_id" class="input"></el-input>
        </el-form-item> 
        <el-form-item class="submit_item">
          <el-button type="primary" class="submit" @click="onSubmit1">提交</el-button>
        </el-form-item> 
      </el-form>
      <el-row class="item-row">
        <el-col :span="8" class="item">
          采样点地点
        </el-col>
        <el-col :span="16" class="item" v-if="is_submit1">
          Zijingang Road No.866
        </el-col>
      </el-row>    
      <el-row class="item-row">
        <el-col :span="8" class="item">
          采样时间
        </el-col>
        <el-col :span="16" class="item" v-if="is_submit1">
          18:00 - 20:00
        </el-col>
      </el-row>        
    </el-main>
    <el-header class="header">
      <p class="text">修改核酸采样点</p>
    </el-header>
    <el-main class="main"> 
      <el-form :model="form2" class="form">
        <el-form-item label="采样点名称" class="formLabel">
          <el-input v-model="form2.site_id" class="input"></el-input>
        </el-form-item> 
        <el-form-item :label="'采样点采样时间'" class="formLabel">
          <el-input v-model="form2.time" class="input"></el-input>
        </el-form-item> 
        <el-form-item class="submit_item">
          <el-button type="primary" class="submit" @click="onSubmit2">提交</el-button>
        </el-form-item> 
      </el-form>
    </el-main>
    <el-header class="header">
      <p class="text">删除核酸采样点</p>
    </el-header>
    <el-main class="main"> 
      <el-form :model="form3" class="form">
        <el-form-item label="采样点名称" class="formLabel">
          <el-input v-model="form3.site_id" class="input"></el-input>
        </el-form-item>
        <el-form-item class="submit_item">
          <el-button type="primary" class="submit" @click="onSubmit3">提交</el-button>
        </el-form-item>  
      </el-form>
    </el-main>

  </el-container>
</template>




<style scoped>

.formLabel /deep/ .el-form-item__label {
	font-size: 1.3rem;
  font-weight: 400;
	color: #000;
}

.el-header{
  margin-left:-28px;
} 
.submit_item{
  padding-top: 0;
  margin-bottom: 0;
}

.text {
  color:black;
  font-size:1.3rem;
  font-weight: bold;

}
.title {
  color: #01a28c;
  font-size: 1.5rem;
  margin:0;
  padding: 0;
  display: flex;
  justify-content: left;
  align-items: center;


}
.item-row {
	height: 3.5vh;
	width: 100%;
	margin-top: 0.2rem;  
}
.item {
  font-size: 1.2rem;
  font-weight: 500;
  color:black;
}

.header{
  height:4vh;
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
  padding: 1rem;
  margin:0 -32px;
  
}

.icon {
  display: flex;
  justify-content: left;
  align-items: center;
}

.form {
  font-size: 28px;
  line-height: auto;
}

.submit {
	width: 100%;
	height: 3rem;
	margin: 0.srem;
  font-size: 24px;
}

</style>
