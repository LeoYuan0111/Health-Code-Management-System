<script setup lang="ts">
import { ref } from 'vue'
import IconReturn from '@/components/icons/IconReturn.vue';
import { useRouter } from 'vue-router'
import { reactive } from 'vue'
import IconFile from '@/components/icons/IconFile.vue';
const router = useRouter()

const onReturn = () => {
  router.push('/administrator')
}

const form = reactive({
    superuser_id : '' ,
    passwd : '' ,
    phone : '' ,
    superuser_name : '',
    type : ''  //权限类型（目前只填了这个）
})

const onSubmit = () => {
  console.log(form)
}

</script>

<template>
  <el-container>
    <el-header style="text-align: left">
      <el-row>
        <el-col :span="3" class="icon" @click="onReturn">
          <IconReturn />
        </el-col>
        <el-col :span="21">
          <h1 class="title">高级用户授权管理</h1>
        </el-col>
      </el-row>
    </el-header>
    <el-main class="main">
      <el-icon size="210">
        <IconFile class="iconbig" />
      </el-icon>
      <p class="boldtext">文件名:授权信息.xlsx</p>
    </el-main>
    <el-footer class="footer">
      <el-form :model="form" class="form">
        <el-form-item label="授权身份" class="formLabel">
          <el-select v-model="form.vac_time" class="input" :placeholder="' '">
            <el-option value="采样者" class="select_item">采样者</el-option>
            <el-option value="检测者" class="select_item">检测者</el-option>
            <el-option value="管理者" class="select_item">管理者</el-option>
          </el-select>
        </el-form-item>
        <el-form-item class="submit_item">
          <el-button type="primary" class="submit" >提交</el-button>
        </el-form-item> 
      </el-form>
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
.name {
  padding-left: 0px;
  padding-bottom: 30px;
  color: #666666;
}
.select_item{
  height: 35px;
  line-height: 25px;
  font-size: 20px;
}
.text {
  color: black;
  font-size: 16px;
}

.boldtext {
  color: #666666;
  font-size: 22px;
  font-weight: bold;
}

.title {
  color: #01a28c;
  font-size: 1.5rem;
  margin: 0;
  padding: 0;
  display: flex;
  justify-content: left;
  align-items: center;

}

.main {
  display: flex;
  justify-content: end;
  align-items: center;
  flex-direction: column;
  height: 350px;
  padding: 0;
  margin: 0;

}

.footer {
  display: flex;
  justify-content: end;
  align-items: center;
  flex-direction: column;
  height: auto;
  padding: 15px;
  margin: 5vh 0;
}

.icon {
  display: flex;
  justify-content: left;
  align-items: center;
  width: 80%;
}

.iconbig {
  display: flex;
  justify-content: center;
  align-item:center;
  width: 90%;
}

.submit_item{
  padding-top: 15vh;
  margin-bottom: 0;
}

.el-row {
  display: flex;
  flex-wrap: wrap;
}

.el-header {
  padding: 0;
  margin: 0;
}


.submit {
  width: 100%;
  height: 3rem;
  margin: 0.5rem auto;
  font-size: 18px;
}
</style>
