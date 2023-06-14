<script setup lang="ts">
import { ref } from 'vue'
import LoginForm from '../components/LoginForm.vue'
import RegisterForm from '@/components/RegisterForm.vue';
import AdvancedForm from '@/components/AdvancedForm.vue';
import HomePic from '@/components/HomePic.vue';
import IconBubble from '@/components/icons/IconBubble.vue'

const login_drawer = ref(false)
const register_drawer = ref(false)
const advanced_drawer = ref(false)

</script>

<template>
  <el-container>
    <el-header>
      <el-row>
        <el-col :span="4" :offset="2" class="icon">
          <IconBubble />
        </el-col>
        <el-col :span="18">
          <h1 class="title">健康码管理系统</h1>
        </el-col>
      </el-row>
    </el-header>
    <el-main class="main">
      <HomePic class="main-pic"/>
      <el-button type="primary" class="main-button" @click="login_drawer = true">登录</el-button>
      <el-button type="primary" class="main-button" @click="register_drawer = true">注册</el-button>
      <el-button type="primary" class="main-button" @click="advanced_drawer = true">高级身份认证</el-button>
    </el-main>
  </el-container>
  <el-drawer v-model="login_drawer" title="登录" direction="btt" size="60%" :show-close="false" :with-header="false">
    <LoginForm />
  </el-drawer>
  <el-drawer v-model="register_drawer" direction="btt" size="80%" :show-close="false" :with-header="false">
    <RegisterForm />
  </el-drawer>
  <el-drawer v-model="advanced_drawer" direction="btt" size="80%" :show-close="false" :with-header="false">
    <AdvancedForm />
  </el-drawer>
</template>


<style scoped>
.title {
  color: #01a28c;
  font-size: 20px;
  margin: 0;
  padding: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 10vh;
}

.main {
  display: flex;
  justify-content: end;
  align-items: center;
  flex-direction: column;
  height: 80vh;
}

.main-button {
  width: 95%;
  height: 3rem;
  margin: 1rem 0;
  font-size: 1.2rem;
  font-weight: bolder;
}
.main-pic {
  width: 90%;
  margin: 1rem 0;
}

.icon {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 80%;
}

</style>
