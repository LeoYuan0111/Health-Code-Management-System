<script setup lang="ts">
import { ref, reactive } from 'vue'
import type { FormInstance, FormRules } from 'element-plus'
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'

const router = useRouter()

import { useUserStore } from '@/stores/user'

const ruleFormRef = ref<FormInstance>()

const user = useUserStore()

const form = reactive({
	name: '',
	id: '',
	phone: '',
	passwd: '',
	repeat_passwd: ''
})


const checkPasswdRepeat = (rule: any, value: string, callback: any) => {
	if (value === '') {
		callback(new Error('请再次输入密码'))
	} else if (value !== form.passwd) {
		callback(new Error('两次输入密码不一致!'))
	} else {
		callback()
	}
}
const checkPasswd = (rule: any, value: string, callback: any) => {
	if (value === '') {
		callback(new Error('请输入密码'))
	} else {
		if (form.repeat_passwd !== '') {
			ruleFormRef.value?.validateField('repeat_passwd')
		}
		callback()
	}
}

const rules = reactive<FormRules>({
	name: [{
		required: true,
		message: '请输入姓名',
		trigger: 'blur'
	}],
	id: [{
		required: true,
		message: '请输入身份证号',
		trigger: 'blur'
	}],
	phone: [{
		required: true,
		message: '请输入电话',
		trigger: 'blur'
	}],
	passwd: [
		{ validator: checkPasswd, trigger: 'blur' }
	],
	repeat_passwd: [
		{ validator: checkPasswdRepeat, trigger: 'blur' }
	]

})


const onSubmit = (formEl: FormInstance | undefined) => {
	if (!formEl) return
	formEl.validate((valid) => {
		if (valid) {
			console.log('submit!')
			user.register(form.name, form.id, form.phone, form.passwd).then((res) => {
				if (res.code === 200) {
					ElMessage({
						type: 'success',
						message: '注册成功',
					})
					// location.reload()
					formEl.resetFields()
				} else {
					ElMessage({
						type: 'error',
						message: '注册失败!' + res.msg,
					})
				}
			})
		} else {
			console.log('error submit!!')
		}
	})
	
	console.log(form)
}

</script>
<template>
	<el-form ref="ruleFormRef" :model="form" class="form" :rules="rules">
		<el-form-item class="item" prop="name">
			<el-input v-model="form.name" placeholder="姓名" class="input"></el-input>
		</el-form-item>
		<el-form-item class="item" prop="id">
			<el-input v-model="form.id" placeholder="身份证号" class="input"></el-input>
		</el-form-item>
		<el-form-item class="item" prop="phone">
			<el-input v-model="form.phone" placeholder="电话" class="input"></el-input>
		</el-form-item>
		<el-form-item class="item" prop="passwd">
			<el-input v-model="form.passwd" type="password" show-password autocomplete="off" placeholder="密码"
				class="input"></el-input>
			
		</el-form-item>
		<el-form-item class="item" prop="repeat_passwd">
			<el-input v-model="form.repeat_passwd" type="password" show-password autocomplete="off" placeholder="确认密码"
				class="input"></el-input>
			
		</el-form-item>
		<el-form-item>
			<el-button type="primary" class="submit" @click="onSubmit(ruleFormRef)">提交</el-button>
		</el-form-item>
	</el-form>
</template>

<style scoped>
.input {
	width: 100%;
	height: 3rem;
	margin: 0.5rem auto;
}

.submit {
	width: 80%;
	height: 3rem;
	margin: 0.5rem auto;
}
.item {
	height: 4rem;
	width: 80%;
	margin: 0.8rem auto;
}
.forget {
	margin: 0 auto;
}
</style>
