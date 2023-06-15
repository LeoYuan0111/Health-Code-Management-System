<script setup lang="ts">
import { ref } from 'vue'
import IconReturn from '@/components/icons/IconReturn.vue';
import { useRouter } from 'vue-router'
import { reactive } from 'vue'
import UserInfoCard from '@/components/ManagerUserInfoCard.vue';
import { Record } from '@/components/ManagerUserInfoCard.vue';


const router = useRouter()

const onReturn = () => {
	router.push('/manager')
}

const record = reactive<Record>(
  {
    name : '唐可可' ,
	phone : '13800000000' ,
    email :'123456789@qq.com' ,
	addr : '浙江大学玉泉校区' ,
	health_code : '绿码',
	RNA_result : '阴性',
	RNA_time : '2022-12-05 17:12:16',
  },
)


/*
表格信息的问题:
    1.color是文本还是枚举
    2.加了user_name
*/
const form = reactive({
  user_id : ''
})

const is_submit = ref(false);

const onSubmit = () => {
    is_submit.value = true ;
    console.log(form);
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
        <h1 class="title">用户信息查询</h1>
        </el-col>
      </el-row>
    </el-header>

    <el-main class="main"> 
      <el-form :model="form" class="form">
        <el-form-item label="身份证号" class="formLabel">
          <el-input v-model="form.user_id" class="input"></el-input>
        </el-form-item> 
        <el-form-item>
            <el-button type="primary" class="submit" @click="onSubmit">提交</el-button>
        </el-form-item>
      </el-form>
    </el-main>
    
  </el-container>
  <el-drawer v-model="is_submit" direction="btt" size="50%" :show-close="false" :with-header="false">
    <UserInfoCard :record="record" />
  </el-drawer>
</template>

<style>
  .formLabel .el-form-item__label {
    font-size:1.5rem;
    font-weight:400;
    color:black;
  }
  .el-input__inner {
  font-size: 1.5rem;
}
.input {
  height:auto;
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
  height:auto;
  align-items: center;
  flex-direction: column;
  width: 100%;
  padding: 0;
  margin-top: 7vh;
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
