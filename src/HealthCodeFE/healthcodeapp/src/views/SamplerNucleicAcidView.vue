<script setup lang="ts">
import { onMounted, ref } from 'vue'
import IconReturn from '@/components/icons/IconReturn.vue';
import IconScanQRCode from '@/components/icons/IconScanQRCode.vue';
import { useRouter } from 'vue-router'
import { reactive } from 'vue'
import { Html5QrcodeScanner, Html5Qrcode } from "html5-qrcode";
import { getURL } from '@/utils/url'
import { fetchPostText } from '@/utils/fetch';
import { ElMessage } from 'element-plus';
// import { QrStream } from 'vue3-qr-reader'
// import QrScanner from 'qr-scanner'
const router = useRouter()

const onReturn = () => {
  router.push('/sampler')
}



const number = ref(0);

const tube_id = ref('');
const user_id = ref('');
const error = ref('')

const ScanHealthCode = () => {
  number.value++;
  console.log("scan health code")
}

const ScanTube = () => {
  console.log("scan tube")
}




const camera = ref('123')


function onScanSuccess(decodedText: string, decodedResult: any) {
  console.log(`Scan result: ${decodedText}`, decodedResult);
  user_id.value = decodedText.split('#')[0]
  // Handle on success condition with the decoded text or result.
}
function onScanFailure(error: any) {
  // handle on error condition, with error.message
  console.log(error)
}


onMounted(() => {
  
  const html5QrcodeScanner = new Html5QrcodeScanner("reader", {
    fps: 10, qrbox: {
      width: 250, height: 250
    }
  }, false);


  html5QrcodeScanner.render(onScanSuccess, onScanFailure);
})

const onSubmit = async () => {
  fetchPostText(getURL('/sampled_info'), {
    tube_id: tube_id.value,
    user_id: user_id.value
  }, {}).then((res) => {
    ElMessage.success('提交成功')
    tube_id.value = ''
    user_id.value = ''
  }).catch(e => {
    ElMessage.error('提交失败')
  })
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
    <!-- <el-main class="main">
      <el-icon size="150">
        <IconScanQRCode class="iconbig" @click="ScanTube"/>
      </el-icon>
      <p class="boldtext">请扫描检测试管</p>
    </el-main> -->
    <!-- <el-footer class="footer">
      <p class="text">试管号:</p>
    </el-footer> -->
    <el-main class="main">
      <!-- <el-icon size="150">
        <IconScanQRCode class="iconbig" @click="ScanHealthCode"/>    
      </el-icon> -->
      <div id="reader" width="600px"></div>
      <!-- <qr-stream @decode="onDecode">
        <div></div>
      </qr-stream> -->
      <p class="boldtext">请扫描被采样者健康码</p>
    </el-main>
    <!-- <el-footer class="footer">
      <p class="text">被采样人数: {{number}}</p>
    </el-footer> -->
    <el-main>
      用户 ID: {{ user_id }}
      <el-input class="tube_id" placeholder="请输入试管编号" v-model="tube_id"></el-input>
      <el-button type="primary" class="submit" @click="onSubmit">提交</el-button>
    </el-main>
  </el-container>
</template>


<style scoped>
.text {
  color: black;
  font-size: 1.2rem;
}

.boldtext {
  color: black;
  font-size: 1.2rem;
  font-weight: bold;
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
  height: 65vh;
  background: #01A28C61;
  margin: 20px;
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

.el-header {
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
