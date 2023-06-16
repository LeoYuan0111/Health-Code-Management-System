<script setup lang="ts">
import { ref, reactive, computed } from 'vue'
import IconReturn from '@/components/icons/IconReturn.vue';
import { useRouter } from 'vue-router'
import { useUserStore } from '@/stores/user'
// import { ElMessage } from 'element-plus';

const router = useRouter()
const user = useUserStore()

const onReturn = () => {
  router.push('/main')
}
const onLogout = () => {
  user.logout()
}
</script>
<template>
  <el-container>
    <el-header style="text-align: left">
      <el-row>
        <el-col :span="3" class="icon" @click="onReturn">
          <IconReturn />
        </el-col>
        <el-col :span="19">
          <h1 class="title">个人信息查看</h1>
        </el-col>
      </el-row>
    </el-header>
    <el-main class="main">
      <el-row class="item">
        <el-col :span="8" class="label">姓名</el-col>
        <el-col :span="16" class="value">{{ user.name }}</el-col>
      </el-row>
      <el-row class="item">
        <el-col :span="8" class="label">身份证号</el-col>
        <el-col :span="16" class="value">{{ user.id }}</el-col>
      </el-row>
      <el-row class="item">
        <el-col :span="8" class="label">手机号</el-col>
        <el-col :span="16" class="value">{{ user.phone }}</el-col>
      </el-row>
    </el-main>
    <el-footer class="footer">
      <el-row class="button-row">
        <el-col :span="10" class="button-col">
          <el-button type="primary" class="button">修改个人信息</el-button>
        </el-col>
        <el-col :span="10" class="button-col">
          <el-button type="danger" class="button" @click="user.logout()">登出</el-button>
        </el-col>
      </el-row>
      <el-row class="button-row" v-if="user.admin || user.sampler || user.tester">
        <el-col :span="22" class="button-col">
          <el-button class="button" @click="router.push('/advanced')">高级身份认证</el-button>
        </el-col>
      </el-row>
    </el-footer>
  </el-container>
</template>
<style scoped>
.icon {
  display: flex;
  justify-content: left;
  align-items: center;
  width: 80%;
}

.button {
  font-size: 1.2rem;
  width: 100%;
  height: 100%;
}

.button-col {
  height: 100%;
}

.button-row {
  width: 100%;
  height: 40%;
  align-items: center;
  justify-content: space-around;
  display: flex;
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

.el-header {
  padding: 0;
}

.main {
  display: flex;
  justify-content: start;
  align-items: center;
  flex-direction: column;
  padding: 10% 0;
  margin: 0;
  height: 60vh;
  background-color: #a6ded7;
  border-radius: 1rem;
}

.footer {
  padding: 0;
  margin: 0;
  /* border: 2px solid black; */
  height: 15vh;
  display: flex;
  justify-content: space-around;
  align-items: center;
  flex-direction: column;
}

.item {
  width: 90%;
  height: 8vh;
  /* border: 1px solid black; */
}

.label {
  display: flex;
  justify-content: left;
  align-items: center;
  font-size: 1.2rem;
  font-weight: bold;
}

.value {
  display: flex;
  justify-content: left;
  align-items: center;
  font-size: 1.2rem;
  overflow-wrap: anywhere;
  word-wrap: anywhere;
  word-break: break-all;
}
</style>
