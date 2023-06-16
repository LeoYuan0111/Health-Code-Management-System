<script setup lang="ts">
import { ref, reactive, computed, onMounted, watch } from 'vue'
import IconReturn from '@/components/icons/IconReturn.vue';
import { useRnaRecordStore } from '@/stores/rna_record'
// import { Record } from '@/components/RNARecord.vue';
import type { RnaRecord } from '@/stores/rna_record'
import RNARecord from '@/components/RNARecord.vue';
import { useRouter } from 'vue-router'

const record = useRnaRecordStore()

const router = useRouter()

const onReturn = () => {
  router.push('/main')
}

const currentPage = ref(1)
const pageSize = ref(4)
const currentRecords = ref<RnaRecord[]>([])
const records = reactive<RnaRecord[]>([])

// const currentRecords = computed(() => {
//   return records.slice(currentPage.value, currentPage.value + pageSize.value)
// })
watch(currentPage, (newVal, oldVal) => {
  currentRecords.value = records.slice((newVal - 1) * pageSize.value, newVal * pageSize.value)
})


onMounted(async () => {
  await record.getRecords()
  records.push(...record.records)
  currentRecords.value = records.slice(0, 1 * pageSize.value)
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
