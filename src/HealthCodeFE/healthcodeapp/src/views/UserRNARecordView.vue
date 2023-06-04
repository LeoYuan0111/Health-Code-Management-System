<script setup lang="ts">
import { ref, reactive, computed } from 'vue'
import IconReturn from '@/components/icons/IconReturn.vue';
// import { Record } from '@/components/RNARecord.vue';
import type { Record } from '@/components/RNARecord.vue';
import RNARecord from '@/components/RNARecord.vue';
import { useRouter } from 'vue-router'

const router = useRouter()

const onReturn = () => {
  router.push('/main')
}


const records = reactive<Record[]>([
  {
    result: true,
    time: '2022-12-05 21:41:33',
    sample_time: '2022-12-05 17:12:16'
  },
  {
    result: false,
    time: '2022-12-05 21:41:33',
    sample_time: '2022-12-05 17:12:16'
  },
  {
    result: true,
    time: '2022-12-05 21:41:33',
    sample_time: '2022-12-05 17:12:16'
  },
  {
    result: false,
    time: '2022-12-05 21:41:33',
    sample_time: '2022-12-05 17:12:16'
  },
  {
    result: true,
    time: '2022-12-05 21:41:33',
    sample_time: '2022-12-05 17:12:16'
  },
  {
    result: false,
    time: '2022-12-05 21:41:33',
    sample_time: '2022-12-05 17:12:16'
  },
  {
    result: true,
    time: '2022-12-05 21:41:33',
    sample_time: '2022-12-05 17:12:16'
  },
  {
    result: false,
    time: '2022-12-05 21:41:33',
    sample_time: '2022-12-05 17:12:16'
  },
  {
    result: true,
    time: '2022-12-05 21:41:33',
    sample_time: '2022-12-05 17:12:16'
  },
  {
    result: false,
    time: '2022-12-05 21:41:33',
    sample_time: '2022-12-05 17:12:16'
  }
])

const currentPage = ref(1)
const pageSize = ref(4)

const currentRecords = computed(() => {
  return records.slice(currentPage.value, currentPage.value + pageSize.value)
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
          <h1 class="title">核酸检测记录</h1>
        </el-col>
      </el-row>
    </el-header>
    <el-main class="main">
      <RNARecord v-for="(record, index) in currentRecords" :key="index" :record="record" class="record" />
      <el-pagination
        layout="prev, pager, next"
        :total="records.length"
        :page-size="pageSize"
        v-model:current-page="currentPage"
        background
      />
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
