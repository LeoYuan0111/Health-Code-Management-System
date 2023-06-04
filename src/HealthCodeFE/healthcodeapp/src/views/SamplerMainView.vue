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
  router.push('/sampler_nucleic_acid')
}

const onClickVaccination  = () => {
  router.push('/sampler_vaccination')
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
      <IconSamplerNucleicAcid class="iconbig"/>
      <el-button type="primary" class="main-button" @click="onClickNucleicAid">核酸检测</el-button>
    </el-main>
    <el-main class="main">
      <SamperVaccinum class="iconbig"/>
      <el-button type="primary" class="main-button" @click="onClickVaccination">疫苗接种</el-button>
    </el-main>
  </el-container>
</template>


<style scoped>
.title {
  color: #01a28c;
  font-size: 20px;
  margin: 0;
  padding: 0;
  display: flex;
  justify-content: left;
  align-items: center;
  height: 10vh;
}

.main {
  display: flex;
  justify-content: end;
  align-items: center;
  flex-direction: column;
  height: 320px;
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
  width: 35%;
}
.el-row {
  display: flex; 
  flex-wrap: wrap;
}
.el-header{
  padding: 0;
  margin: 0;
}

</style>

