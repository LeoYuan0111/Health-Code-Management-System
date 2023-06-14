<script setup lang="ts">
import { reactive } from 'vue'
import { useRouter } from 'vue-router'

const form = reactive({
	id: '',
	passwd: '',
	role: '',
})

const router = useRouter()

const onSubmit = () => {
	// if (form.role == 'sampler') {
	// 	router.push('/sampler')
	// } else if (form.role == 'detector') {
	// 	router.push('/detector')
	// } else if (form.role == 'manager') {
	// 	router.push('/manager')
	// }
}
</script>
<template>
	<el-form :model="form" class="form">
		<el-form-item>
			<el-input v-model="form.id" placeholder="用户名" class="input"></el-input>
		</el-form-item>
		<el-form-item>
			<el-input v-model="form.passwd" type="password" show-password placeholder="密码" class="input"></el-input>
		</el-form-item>
		<!-- <el-form-item>
			<el-select v-model="form.role" placeholder="请选择角色" class="select">
				<el-option label="采样员" value="sampler" />
				<el-option label="检测员" value="detector" />
				<el-option label="管理员" value="manager" />
			</el-select>
		</el-form-item> -->
		<el-form-item>
			<el-button type="primary" class="submit" @click="onSubmit">采样员</el-button>
		</el-form-item>
		<el-form-item>
			<el-button type="primary" class="submit" @click="onSubmit">检测员</el-button>
		</el-form-item>
		<el-form-item>
			<el-button type="primary" class="submit" @click="onSubmit">管理员</el-button>
		</el-form-item>
	</el-form>
</template>

<style scoped>

.input {
	width: 80%;
	height: 3rem;
	margin: 0.5rem auto;
}
.select {
	width: 80%;
	height: 3rem;
	margin: 0.5rem auto;
}
.submit {
	width: 80%;
	height: 3rem;
	margin: 0.5rem auto;
}
.forget {
	margin: 0 auto;
}
</style>

