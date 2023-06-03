<script setup lang="ts">
import { reactive } from 'vue'
import { useRouter } from 'vue-router'

const form = reactive({
	name: '',
	id: '',
	passwd: '',
})

const router = useRouter()

const onSubmit = () => {
	console.log(form)
	router.push('/main')
}
</script>
<template>
	<el-form :model="form" class="form">
		<el-form-item class="item">
			<el-input v-model="form.name" placeholder="姓名" class="input"></el-input>
		</el-form-item>
		<el-form-item>
			<el-input v-model="form.id" placeholder="身份证号" class="input"></el-input>
		</el-form-item>
		<el-form-item>
			<el-input v-model="form.passwd" placeholder="密码" class="input"></el-input>
		</el-form-item>
		<el-form-item>
			<el-button type="primary" :link="true" class="forget">忘记密码</el-button>
		</el-form-item>
		<el-form-item>
			<el-button type="primary" class="submit" @click="onSubmit">登录</el-button>
		</el-form-item>
	</el-form>
</template>

<style scoped>

.input {
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

