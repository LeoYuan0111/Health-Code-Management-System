<script setup lang="ts">
import { ref } from 'vue'
import LoginForm from '../components/LoginForm.vue'
import RegisterForm from '@/components/RegisterForm.vue';

const login_drawer = ref(false)
const register_drawer = ref(false)
const advanced_drawer = ref(false)

</script>

<template>
	<el-container>
		<el-header height="30vh">
			<h1 class="title">健康码管理系统</h1>
		</el-header>
		<el-main class="main">
			
		</el-main>
		<el-footer>

		</el-footer>
	</el-container>
	
</template>


<style scoped>
.title {
	color: #01a28c;
	font-size: 20px;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 10vh;
}

.main {
	display: flex;
	justify-content: end;
	align-items: center;
	flex-direction: column;
	height: 80vh;
}

.main-button {
	width: 95%;
	height: 3rem;
	margin: 1rem 0;
	font-size: 1.2rem;
	font-weight: bolder;
}
</style>
