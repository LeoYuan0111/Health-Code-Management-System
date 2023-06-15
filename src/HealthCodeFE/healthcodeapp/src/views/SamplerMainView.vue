<script setup lang="ts">
import { ref } from 'vue'
import IconReturn from '@/components/icons/IconReturn.vue';
import IconSamplerNucleicAcid from '@/components/icons/IconSamplerNucleicAcid.vue'
import SamperVaccinum from '@/components/icons/IconSamperVaccinum.vue'
import { useRouter } from 'vue-router'

const router = useRouter()

const onReturn = () => {
  router.push('/')
}

const onClickNucleicAid = () => {
  router.push('/sampler/nucleic_acid')
}

const onClickVaccination = () => {
  router.push('/sampler/vaccination')
}


</script>

<template>
  <el-container>
    <el-header style="text-align: left">
      <el-row>
        <el-col :span="3" class="icon" @click="onReturn">
          <IconReturn />
        </el-col>
        <el-col :span="19">
          <h1 class="title">采样者页面</h1>
        </el-col>
      </el-row>
    </el-header>
    <el-main class="main">
      <el-row class="icon-row">
        <el-icon :size="150">
          <IconSamplerNucleicAcid />
        </el-icon>
      </el-row>
      <el-row class="button-row">
        <el-button type="primary" class="main-button" @click="onClickNucleicAid">
          核酸检测
        </el-button>

      </el-row>
      <el-row class="icon-row">
        <el-icon :size="150">
          <SamperVaccinum />
        </el-icon>
      </el-row>
      <el-row class="button-row">
        <el-button type="primary" class="main-button" @click="onClickVaccination">
          疫苗接种
        </el-button>

      </el-row>
    </el-main>
  </el-container>
</template>


<style scoped>
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
  justify-content: start;
  align-items: center;
  flex-direction: column;
  /* height: 320px; */
}

.main-button {
  width: 90%;
  height: 3rem;
  margin: 1rem 0;
  font-size: 1.2rem;
  font-weight: bolder;
}

.button-row {
  width: 100%;
  justify-content: center;
  margin-top : 0;
  padding-top : 0;
}
.icon-row {
  width: 80%;
  height: 23vh;
  justify-content: center;
  align-items: flex-end;
  margin: 1rem 0;
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
  width: 35%;
}

.el-row {
  display: flex;
  flex-wrap: wrap;
}

.el-header {
  padding: 0;
  margin: 0;
}
</style>

