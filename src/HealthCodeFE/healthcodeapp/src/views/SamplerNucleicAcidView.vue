<script setup lang="ts">
import IconReturn from '@/components/icons/IconReturn.vue';
import IconScanQRCode from '@/components/icons/IconScanQRCode.vue';
import { useRouter } from 'vue-router'
import { reactive } from 'vue'
const router = useRouter()


const onReturn = () => {
	router.push('/sampler_main')
}

const form = reactive({
  user_id : '',
  vac_name : '',
  vac_num : '',
  vac_time : '',
  address : ''
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
        <el-col :span="18">
        <h1 class="title">采样者核酸检测页面</h1>
        </el-col>
      </el-row>
    </el-header>
    <el-main class="main">
      <IconScanQRCode class="iconbig"/>
      <p class="boldtext">请扫描检测试管</p>
    </el-main>
    <el-footer class="footer">
      <p class="text">试管号:</p>
    </el-footer>
    <el-main class="main">
      <IconScanQRCode class="iconbig"/>
      <p class="boldtext">请扫描被采样者健康码</p>
    </el-main>
    <el-footer class="footer">
      <p class="text">被采样人数:</p>
    </el-footer>
    <el-main>
      <el-button type="primary" class="submit" @click="onSubmit">提交</el-button>
    </el-main>
  </el-container>
</template>


<style scoped>
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
  font-size: 20px;
  margin: 0;
  padding: 0;
  display: flex;
  justify-content: left;
  align-items: center;
  height: 10vh;
}

.main {
  display: flex;
  justify-content: end;
  align-items: center;
  flex-direction: column;
  height: 250px;
  background: #01A28C61;
  margin:20px;
  border-radius: 20px;
}
.footer {
  display: flex;
  justify-content: end;
  align-items: center;
  flex-direction: column;
  height: auto;
}
.main-button {
  width: 90%;
  height: 3rem;
  margin: 1rem 0;
  font-size: 1.2rem;
  font-weight: bolder;
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
  align-items: center;
  width: 60%;
}
.el-row {
  display: flex; 
  flex-wrap: wrap;
}
.el-header{
  padding: 0;
  margin: 0;
}

.submit {
	width: 100%;
	height: 3rem;
	margin: 0.5rem auto;
}

</style>
