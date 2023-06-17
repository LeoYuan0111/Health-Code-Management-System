<script setup lang="ts">
import { ref, onMounted } from 'vue'
import IconReturn from '@/components/icons/IconReturn.vue';
import IconScanQRCode from '@/components/icons/IconScanQRCode.vue';
import { useRouter } from 'vue-router'
import { reactive } from 'vue'
import { Html5QrcodeScanner, Html5Qrcode } from "html5-qrcode";
import { getURL } from '@/utils/url'
import { fetchPostText } from '@/utils/fetch';
import { ElMessage } from 'element-plus';

const router = useRouter()

const onReturn = () => {
  router.push('/sampler')
}

const form = reactive({
  user_id: '',
  vac_name: '',
  vac_num: '',
  vac_time: '',
  address: ''
})



const ScanHealthCode = ()=>{
  console.log("scan health code")
}

onMounted(() => {
  
  const html5QrcodeScanner = new Html5QrcodeScanner("reader", {
    fps: 10, qrbox: {
      width: 250, height: 250
    }
  }, false);


  html5QrcodeScanner.render(onScanSuccess, onScanFailure);
})

function onScanSuccess(decodedText: string, decodedResult: any) {
  console.log(`Scan result: ${decodedText}`, decodedResult);
  form.user_id = decodedText.split('#')[0]
  // Handle on success condition with the decoded text or result.
}
function onScanFailure(error: any) {
  // handle on error condition, with error.message
  console.log(error)
}

const onSubmit = async () => {
  // fetchPostText(getURL('/sampled_info'), {
  //   tube_id: tube_id.value,
  //   user_id: user_id.value
  // }, {}).then((res) => {
  //   ElMessage.success('提交成功')
  //   tube_id.value = ''
  //   user_id.value = ''
  // }).catch(e => {
  //   ElMessage.error('提交失败')
  // })
  ElMessage.success('提交成功')
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
          <h1 class="title">采样者疫苗接种页面</h1>
        </el-col>
      </el-row>
    </el-header>
    <el-main class="main">
      <!-- <div class="greenback"></div>
      <el-icon size="185">
        <IconScanQRCode class="iconbig" @click="ScanHealthCode"/>
      </el-icon> -->
      <div id="reader" width="600px"></div>
      <p class="boldtext">请扫描疫苗接种者健康码</p>
    </el-main>
    <el-footer class="footer">
      <!-- <el-row class="item-row">
        <el-col :span="7" class="item">
          身份证号
        </el-col>
        <el-col :span="14" class="item">
          <el-input v-model="form.user_id" style="width: 100%"></el-input>
        </el-col>
      </el-row>
      <p class="name"></p> -->
      <el-form :model="form" class="form">
        <el-form-item label="身份证号">
          <el-input v-model="form.user_id" style="width: 100%"></el-input>
        </el-form-item>
        <el-form-item label="接种针数">
          <el-select v-model="form.vac_num" :placeholder="' '" class="input">
            <el-option label="第一针" value=1 class="select_item"/>
            <el-option label="第二针" value=2 class="select_item"/>
            <el-option label="加强针" value=3 class="select_item"/>
          </el-select>
        </el-form-item>
        <el-form-item label="接种地点">
          <el-input v-model="form.address" class="input" type="textarea" :rows="2"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" class="submit" @click="onSubmit">提交</el-button>
        </el-form-item>
      </el-form>
    </el-footer>
  </el-container>
</template>


<style scoped>
.form /deep/ .el-form-item__label {
	font-size: 1.2rem;
	color: #000;
  }
  
.form /deep/ .el-option__label{
	font-size:1.2rem !important;
}

.input {
  height:auto;
  font-size: 1.2rem;
}
.select_item{
  line-height: auto;
  font-size: 1.2rem;
}
.name {
  padding-left: 0px;
  padding-bottom: 1.2rem;
  color: #666666;
  font-size: 1.2rem;
}

.item-row {
	height: auto;
	width: 100%;
	margin-top: 0.2rem;
}
.item {
  font-size: 1.2rem;
}
.boldtext {
  color: black;
  font-size: 1.05rem;
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
  background: #01A28C61;
  border-radius: 20px;
  padding: 50px;
  margin: 20px;
  height:40vh;

}

.footer {
  display: flex;
  justify-content: end;
  align-items: center;
  flex-direction: column;
  height: auto;
  padding: 15px;
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
  margin-bottom: 2rem;
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
