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
        <el-col :span="21">
        <h1 class="title">场所码管理</h1>
        </el-col>
      </el-row>
    </el-header>
    <el-main class="main">
      
    </el-main>
  
  </el-container>
</template>


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

.main {
  display: flex;
  justify-content: end;
  align-items: center;
  flex-direction: column;
  height: auto;
  background: #01A28C61;
  border-radius: 20px;
  padding:50px;
  margin:20px;

}
.footer{
  display: flex;
  justify-content: end;
  align-items: center;
  flex-direction: column;
  height: auto;
  padding:15px;
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
