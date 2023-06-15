<script setup lang="ts">
import { ref } from 'vue'
import IconReturn from '@/components/icons/IconReturn.vue';
import IconScanQRCode from '@/components/icons/IconScanQRCode.vue';
import { useRouter } from 'vue-router'
import { reactive } from 'vue'
const router = useRouter()

const onReturn = () => {
	router.push('/sampler')
}



const number = ref(0);

const ScanHealthCode = () => {
  number.value ++ ;
  console.log("scan health code")
}

const ScanTube = () => {
  console.log("scan tube")
}


const onSubmit = () => {
  //vac_time  vac_name user_id
  number.value = 0 ;
  console.log("submit")
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
        <h1 class="title">采样者核酸检测页面</h1>
        </el-col>
      </el-row>
    </el-header>
    <el-main class="main">
      <el-icon size="150">
        <IconScanQRCode class="iconbig" @click="ScanTube"/>
      </el-icon>
      <p class="boldtext">请扫描检测试管</p>
    </el-main>
    <el-footer class="footer">
      <p class="text">试管号:</p>
    </el-footer>
    <el-main class="main">
      <el-icon size="150">
        <IconScanQRCode class="iconbig" @click="ScanHealthCode"/>    
      </el-icon>
        
      <p class="boldtext">请扫描被采样者健康码</p>
    </el-main>
    <el-footer class="footer">
      <p class="text">被采样人数: {{number}}</p>
    </el-footer>
    <el-main>
      <el-button type="primary" class="submit" @click="onSubmit">提交</el-button>
    </el-main>
  </el-container>
</template>


<style scoped>

.text {
  color:black;
  font-size:1.2rem;
}
.boldtext {
  color:black;
  font-size:1.2rem;
  font-weight:bold;
  margin-top: 0.5rem;
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
  height: 28vh;
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
  width: 100%;
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
  font-size: 24px;
}

</style>
