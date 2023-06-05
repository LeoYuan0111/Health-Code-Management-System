<script setup lang="ts">
import { ref, reactive, computed } from 'vue'
import IconReturn from '@/components/icons/IconReturn.vue';
// import { Record } from '@/components/RNARecord.vue';
import type { Record } from '@/components/VacRecord.vue';
import VacRecord from '@/components/VacRecord.vue';
import { useRouter } from 'vue-router'

const router = useRouter()

const onReturn = () => {
  router.push('/main')
}

const records = reactive<Record[]>([
  {
    vacnum: '第一针',
		name: '新冠疫苗 (Vero 细胞)',
    time: '2022-12-05 21:41:33',
    site: '浙江大学医学院'
  },
	{
    vacnum: '第二针',
		name: '新冠疫苗 (Vero 细胞)',
    time: '2022-12-05 21:41:33',
    site: '浙江大学医学院'
  },
	{
    vacnum: '第三针',
		name: '新冠疫苗 (Vero 细胞)',
    time: '2022-12-05 21:41:33',
    site: '浙江大学医学院'
  },
])




</script>

<template>
  <el-container>
    <el-header style="text-align: left">
      <el-row>
        <el-col :span="3" class="icon" @click="onReturn">
          <IconReturn />
        </el-col>
        <el-col :span="19">
          <h1 class="title">核酸检测记录</h1>
        </el-col>
      </el-row>
    </el-header>
    <el-main class="main">
      <VacRecord v-for="(record, index) in records" :key="index" :record="record" class="record" />
      
    </el-main>
  </el-container>
</template>

<style scoped>
.icon {
  display: flex;
  justify-content: left;
  align-items: center;
  width: 80%;
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
  padding: 0;
  margin: 0;
  height: 70vh;
}
.record {
  margin: 1rem 0;
}
</style>
