<script setup lang="ts">
import { reactive } from 'vue'

const form = reactive({
	name: '',
	id: '',
	phone: '',
	passwd: '',
	repeat_passwd: ''
})

const onSubmit = () => {
	console.log(form)
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
			<el-input v-model="form.phone" placeholder="电话" class="input"></el-input>
		</el-form-item>
		<el-form-item>
			<el-input v-model="form.passwd" type="password" show-password placeholder="密码" class="input"></el-input>
		</el-form-item>
		<el-form-item>
			<el-input v-model="form.repeat_passwd" type="password" show-password placeholder="确认密码" class="input"></el-input>
		</el-form-item>
		<el-form-item>
			<el-button type="primary" class="submit" @click="onSubmit">提交</el-button>
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
