<script setup lang="ts">
import { ref, reactive } from 'vue'
import { useRouter } from 'vue-router'

import { useUserStore } from '@/stores/user'
import type { FormInstance, FormRules } from 'element-plus'
import { ElMessage } from 'element-plus'

const form = reactive({
	// name: '',
	id: '',
	passwd: '',
})
const ruleFormRef = ref<FormInstance>()

const rules = reactive<FormRules>({
	// name: [{
	// 	required: true,
	// 	message: '请输入姓名',
	// 	trigger: 'blur'
	// }],
	id: [{
		required: true,
		message: '请输入身份证号',
		trigger: 'blur'
	}],
	passwd: [{
		required: true,
		message: '请输入密码',
		trigger: 'blur'
	}],

})

const user = useUserStore()

const router = useRouter()

const onSubmit = (formEl: FormInstance | undefined) => {
	if (!formEl) return
	console.log(form)
	formEl.validate((valid) => {
		if (valid) {
			user.login(form.id, form.passwd).then((res) => {
				if (res) {
					ElMessage({
						type: 'success',
						message: '登录成功',
					})
					router.push('/main')
				} else {
					ElMessage({
						type: 'error',
						message: '登录失败!',
					})
				}
			})
		}
	})


}

</script>
<template>
	<el-form ref="ruleFormRef" :model="form" class="form" :rules="rules">
		<!-- <el-form-item class="item" prop="name">
			<el-input v-model="form.name" placeholder="姓名" class="input"></el-input>
		</el-form-item> -->
		<el-form-item class="item" prop="id">
			<el-input v-model="form.id" placeholder="身份证号" class="input"></el-input>
		</el-form-item>
		<el-form-item class="item" prop="passwd">
			<el-input v-model="form.passwd" type="password" show-password placeholder="密码" class="input"></el-input>
		</el-form-item>
		<el-form-item>
			<el-button type="primary" :link="true" class="forget">忘记密码</el-button>
		</el-form-item>
		<el-form-item>
			<el-button type="primary" class="submit" @click="onSubmit(ruleFormRef)">登录</el-button>
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

