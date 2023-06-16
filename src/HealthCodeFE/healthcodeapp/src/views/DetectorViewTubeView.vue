<script setup lang="ts">
import { ref, reactive, computed } from 'vue'
import IconReturn from '@/components/icons/IconReturn.vue';
import type { Record } from '@/components/DetectorTubeRecord.vue';
import TubeRecord from '@/components/DetectorTubeRecord.vue';
import { useRouter } from 'vue-router'

const router = useRouter()

const onReturn = () => {
  router.push('/detector')
}

const records = reactive<Record[]>([
  {
    tube_id : '1' ,
		result : true 
  },
  {
    tube_id : '2' ,
		result : false 
  },
  {
    tube_id : '3' ,
		result : true 
  },
  {
    tube_id : '4' ,
		result : true 
  },
  {
    tube_id : '5' ,
		result : true 
  },
  {
    tube_id : '6' ,
		result : true 
  },
  {
    tube_id : '7' ,
		result : false 
  },
  {
    tube_id : '8' ,
		result : true 
  },
  {
    tube_id : '9' ,
		result : true 
  },
  {
    tube_id : '10' ,
		result : true 
  },
  {
    tube_id : '11' ,
		result : false 
  },
  {
    tube_id : '12' ,
		result : true 
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
          <h1 class="title">查看已报告试管</h1>
        </el-col>
      </el-row>
    </el-header>
    <el-main class="main">
      <el-row class="item-row">
        <el-col :span="8" class="item">
            试管号
        </el-col>
        <el-col :span="8" class="item">
            检测结果
        </el-col>
        <el-col :span="8" class="item">
            撤销
        </el-col>
      </el-row>
      <TubeRecord v-for="(record, index) in records" :key="index" :record="record" class="record" />
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
.item-row {
	height: auto;
	width: 100%;
	margin-top: 0.2rem;
}
.item {
  text-align: center;
  font-size:1.3rem;
  font-weight: 500;
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
  height: auto;
  background-color: #a6ded7;
	display: flex;;
}
.record {
  margin: 1rem 0;
}



</style>
