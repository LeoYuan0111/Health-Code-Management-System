<script setup lang="ts">
import { ref } from 'vue'
import IconReturn from '@/components/icons/IconReturn.vue';
import IconScanQRCode from '@/components/icons/IconScanQRCode.vue';
import { useRouter } from 'vue-router'
import { reactive } from 'vue'
const router = useRouter()

const onReturn = () => {
  router.push('/')
}

const form = reactive({
    tube_id: '', //试管号
    result:true //检测结果
})

const ScanTube = () => {
    console.log("scan tube")
}

const onSubmit = () => {
  console.log(form)
}

const onView = () => {
    console.log("onView")
    router.push('/detector/view_tube')
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
          <h1 class="title">检测者页面</h1>
        </el-col>
      </el-row>
    </el-header>
    <el-main class="main">
      <el-icon size="185">
        <IconScanQRCode class="iconbig" @click="ScanTube"/>
      </el-icon>
      
      <p class="boldtext">请扫描检测试管</p>
    </el-main>
    <el-footer class="footer">
        <el-row class="item-row">
            <el-col :span="10"  class="item">
                试管号
            </el-col>
            <el-col :span="14" class="item">
                12345678
            </el-col>
        </el-row>
        <el-row class="item-row">
			<el-col :span="10"  class="item">
				检测结果
			</el-col>
			<el-col :span="14" class="item">
				<el-form :model="form" class="form">	
					<el-form-item class="formLabel">
					    <el-radio-group v-model="form.result">
							<el-radio :label="true" value=True/>阴性</el-radio>
							<el-radio :label="false" value=False>阳性</el-radio>
						</el-radio-group>
					</el-form-item>
				</el-form>
			</el-col>	
		</el-row>
        <el-button type="primary" class="submit1" @click="onSubmit">提交</el-button>
        <el-button type="primary" class="submit2" @click="onView">查看已报告试管</el-button>
    </el-footer>
  </el-container>
</template>


<style scoped>
.formLabel /deep/ .el-form-item__label {
	font-size: 1.2rem;
	font-weight: bolder;
	color: #000;
  }
  
.el-radio /deep/ .el-radio__label{
    font-size:1.2rem !important;
}

.input {
  height:auto;
  font-size: 1.2rem;
}
.select_item{
  line-height: auto;
  font-size: 1.2rem;
}
.name {
  padding-left: 0px;
  padding-bottom: 1.2rem;
  color: #666666;
  font-size: 1.2rem;
}

.item-row {
	height: auto;
	width: 90%;
	margin-top: 0.2rem;
}
.item {
	font-size: 1.2rem;
	
	font-family: 'Consolas', sans-serif;
	justify-content: left;
	display: flex;
	flex-direction: row;
}

.boldtext {
  color: black;
  font-size: 1.3rem;
  font-weight: bold;
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

.main {
  display: flex;
  justify-content: end;
  align-items: center;
  flex-direction: column;
  height: 350px;
  background: #01A28C61;
  border-radius: 20px;
  padding: 50px;
  margin: 20px;
  height:40vh;

}

.footer {
  display: flex;
  justify-content: end;
  align-items: center;
  flex-direction: column;
  height: auto;
  padding: 15px;
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
  width: 100%;
  margin-bottom: 2rem;
}

.el-row {
  display: flex;
  flex-wrap: wrap;
}

.el-header {
  padding: 0;
  margin: 0;
}


.submit1 {
  width: 100%;
  height: 3rem;
  margin-top:2rem;
  margin-left: 0;
  margin-right: 0;
  font-size: 1.3rem;
}
.submit2 {
  width: 100%;
  height: 3rem;
  margin-top:1rem;
  margin-left: 0;
  margin-right: 0;
  font-size: 1.3rem;
  background-color: #C4C4C4;
  border: none;
;
}
</style>
