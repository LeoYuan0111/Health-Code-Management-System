<script setup lang="ts">
import { ref, reactive, computed } from 'vue'
import IconReturn from '@/components/icons/IconReturn.vue';
import { useRouter } from 'vue-router'
import { useUserStore } from '@/stores/user'
// import { ElMessage } from 'element-plus';

const router = useRouter()
const user = useUserStore()

const onReturn = () => {
	router.push('/main')
}
const onLogout = () => {
	user.logout()
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
					<h1 class="title">高级身份认证</h1>
				</el-col>
			</el-row>
		</el-header>
		<el-main class="main">

			<el-row class="button-row" v-if="user.sampler">
				<el-col :span="22" class="button-col">
					<el-button type="primary" class="button" @click="router.push('/sampler')">采样员</el-button>
				</el-col>
			</el-row>
			<el-row class="button-row" v-if="user.tester">
				<el-col :span="22" class="button-col">
					<el-button type="primary" class="button" @click="router.push('/detector')">检测员</el-button>
				</el-col>
			</el-row>
			<el-row class="button-row" v-if="user.admin">
				<el-col :span="22" class="button-col">
					<el-button type="primary" class="button" @click="router.push('/manager')">管理员</el-button>
				</el-col>
			</el-row>
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

.button {
	font-size: 1.2rem;
	width: 100%;
	height: 100%;
}

.button-col {
	height: 100%;
}

.button-row {
	width: 100%;
	height: 10%;
	align-items: center;
	justify-content: space-around;
	display: flex;
	margin: 1rem 0;
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
</style>
