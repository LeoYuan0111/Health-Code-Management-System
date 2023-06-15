<script setup lang="ts">
import IconReturn from '@/components/icons/IconReturn.vue';
import { useRouter } from 'vue-router'
import Icon1Administrator from '@/components/icons/Icon1Administrator.vue';
import Icon2Administrator from '@/components/icons/Icon2Administrator.vue';
import Icon3Administrator from '@/components/icons/Icon3Administrator.vue';
import Icon4Administrator from '@/components/icons/Icon4Administrator.vue';
import Icon5Administrator from '@/components/icons/Icon5Administrator.vue';
import Icon6Administrator from '@/components/icons/Icon6Administrator.vue';

const router = useRouter()

const onReturn = () => {
	router.push('/')
}

const onClickIcon1 = () => {
  router.push('/manager/code_change')
}

const onClickIcon2  = () => {
  console.log("code_appeal")
  router.push('/manager/place_code')
}

const onClickIcon3 = () => {
  console.log("code_appeal")
  router.push('/manager/code_appeal')
}

const onClickIcon4 = () => {
  router.push('/manager/user_info')
}

const onClickIcon5 = () => {
  router.push('/manager/na_place')
}

const onClickIcon6 = () => {
  router.push('/manager/user_authorization')
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
        <h1 class="title">管理者页面</h1>
        </el-col>
      </el-row>
    </el-header>
    <el-main class="main">
      <el-icon size="195">
        <Icon1Administrator class="iconbig" @click="onClickIcon1"/>
      </el-icon>
      <el-icon size="195">
        <Icon2Administrator class="iconbig" @click="onClickIcon2"/>
      </el-icon>
      
    </el-main>
    <el-main class="main">
      <el-icon size="195">
        <Icon3Administrator class="iconbig" @click="onClickIcon3"/>
      </el-icon>
      <el-icon size="195">
        <Icon4Administrator class="iconbig" @click="onClickIcon4"/>
      </el-icon>
    </el-main>

    <el-main class="main">
      <el-icon size="195">
        <Icon5Administrator class="iconbig" @click="onClickIcon5"/>
      </el-icon>
      <el-icon size="195">
        <Icon6Administrator class="iconbig" @click="onClickIcon6"/>
      </el-icon>
    </el-main>
  </el-container>
</template>


<style scoped>
.el-header{
  margin-left:-28px;
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
  align-items: center;
  flex-direction:row;
  height: auto;
  height: 28vh;
}

.icon {
  display: flex;
  justify-content: left;
  align-items: center;
  width: 75%;
}
.iconbig {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 80%;
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

