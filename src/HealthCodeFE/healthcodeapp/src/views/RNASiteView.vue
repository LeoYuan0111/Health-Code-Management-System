<script setup lang="ts">
import { ref, reactive, computed, onMounted } from 'vue'
import IconReturn from '@/components/icons/IconReturn.vue';
import { useRouter } from 'vue-router'
import { useUserStore } from '@/stores/user';
import AMapLoader from '@amap/amap-jsapi-loader';

window._AMapSecurityConfig = {
  securityJsCode: 'd4b91d7c5af90033e18b9579a4d608cd',
}



const latitude = ref(0.0)
const longitude = ref(0.0)



const router = useRouter()
const user = useUserStore()


const onReturn = () => {
  router.push('/main')
}
const onLogout = () => {
  user.logout()
}
const title = ref('')
const address = ref('')
const time = ref('')
const sites = reactive([
  {
    potision: [120.122946, 30.263776],
    title: '采样点1',
    address: '采样点1地址',
    time: '2022-12-05 21:41:33',
  }
])
onMounted(async () => {
  AMapLoader.load({
    "key": "c4fcce6e6b3a40101395cb1574664012",              // 申请好的Web端开发者Key，首次调用 load 时必填
    "version": "2.0",   // 指定要加载的 JS API 的版本，缺省时默认为 1.4.15
    "plugins": [],           // 需要使用的的插件列表，如比例尺'AMap.Scale'等
  }).then((AMap) => {
    let map = new AMap.Map('container', {
      center: [120.122946, 30.263776],
      zoom: 15,
      resizeEnable: true
    });
    sites.forEach((site, i) => {
      let marker = new AMap.Marker({
        position: site.potision,
        title: site.title,
      });
      marker.number = i
      marker.title = site.title
      marker.address = site.address
      marker.time = site.time
      marker.on('click', (e) => {
        console.log(e.target.number);
        title.value = e.target.title
        address.value = e.target.address
        time.value = e.target.time
        // router.push('/main/rna-site-detail')
      })
      // marker.number = 
      // var content = [
      //   "电话 : 010-84107000",
      // ];

      // // 创建 infoWindow 实例	
      // var infoWindow = new AMap.InfoWindow({
      //   content: content.join("<br>")  //传入 dom 对象，或者 html 字符串
      // });
      // infoWindow.open(map, site.potision)
      map.add(marker)
    })
  }).catch(e => {
    console.log(e);
  })
})
</script>
<template>
  <el-container>
    <el-header style="text-align: left">
      <el-row>
        <el-col :span="3" class="icon" @click="onReturn">
          <IconReturn />
        </el-col>
        <el-col :span="19">
          <h1 class="title">采样点查询</h1>
        </el-col>
      </el-row>
    </el-header>
    <el-main class="main" id="container">

    </el-main>
    <el-footer class="footer">
      <el-row class="item" >
        <el-col :span="8" class="label">名称</el-col>
        <el-col :span="16" class="value">{{ title }}</el-col>
      </el-row>
      <el-row class="item" >
        <el-col :span="8" class="label">地址</el-col>
        <el-col :span="16" class="value">{{ address }}</el-col>
      </el-row>
      <el-row class="item" >
        <el-col :span="8" class="label">时间</el-col>
        <el-col :span="16" class="value">{{ time }}</el-col>
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
  width: 40%;
  height: 60%;
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
  margin: 2px 0;
  /* border: 2px solid black; */
  height: 15vh;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  background-color: #a6ded7;
  border-radius: 1rem;
}
.item {
  width: 90%;
  height: 4vh;
  /* border: 1px solid black; */
}
.label {
  display: flex;
  justify-content: left;
  align-items: center;
  font-size: 1rem;
  font-weight: bold;
}
.value {
  display: flex;
  justify-content: left;
  align-items: center;
  font-size: 1rem;
  overflow-wrap: anywhere;
  word-wrap: anywhere;
  word-break: break-all;
}
</style>
