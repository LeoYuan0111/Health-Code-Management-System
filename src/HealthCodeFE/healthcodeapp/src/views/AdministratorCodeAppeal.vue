<script setup lang="ts">
import { ref, reactive, computed } from 'vue'
import IconReturn from '@/components/icons/IconReturn.vue';
import type { Record } from '@/components/CodeAppealRecord.vue';
import VacRecord from '@/components/CodeAppealRecord.vue';
import { useRouter } from 'vue-router'

const router = useRouter()

const onReturn = () => {
  router.push('/administrator')
}

const records = reactive<Record[]>([
  {
		name : '唐可可' , //申诉用户名
    color : '红码' ,//申诉者当前健康码颜色(红/黄/绿）0/1/2
    reason : 'QWQQWQQWQ' , //申诉理由
    time : '2022-5-23 16:10:07' //申诉时间
  },
  {
		name : '唐可可' , //申诉用户名
    color : '红码' ,//申诉者当前健康码颜色(红/黄/绿）0/1/2
    reason : 'QWQQWQQWQ' , //申诉理由
    time : '2022-5-23 16:10:07' //申诉时间
  },
  {
		name : '唐可可' , //申诉用户名
    color : '红码' ,//申诉者当前健康码颜色(红/黄/绿）0/1/2
    reason : 'QWQQWQQWQ' , //申诉理由
    time : '2022-5-23 16:10:07' //申诉时间
  },
  {
		name : '唐可可' , //申诉用户名
    color : '红码' ,//申诉者当前健康码颜色(红/黄/绿）0/1/2
    reason : 'QWQQWQQWQ' , //申诉理由
    time : '2022-5-23 16:10:07' //申诉时间
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
          <h1 class="title">健康码申诉处理</h1>
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
  height: auto;
}
.record {
  margin: 1rem 0;
}



</style>
