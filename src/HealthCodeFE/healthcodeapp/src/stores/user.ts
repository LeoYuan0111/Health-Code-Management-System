import { ref } from 'vue'
import { defineStore } from 'pinia'
import { useRouter } from 'vue-router'

import hmacSHA256 from 'crypto-js/hmac-sha256'
import Base64 from 'crypto-js/enc-base64'



export const useUserStore = defineStore('user', () => {
  const name = ref('')
	const id = ref('')
	const phone = ref('')
	const router = useRouter()
	const salt = '_healthcodeapp2023SE'
	async function login(form_name: string, form_id: string, passwd: string) {
		name.value = form_name
		id.value = form_id
		const passwd_hash = Base64.stringify(hmacSHA256(passwd, salt))
		console.log(passwd_hash)
		const user = { name: name.value, id: id.value, phone: phone.value }
		localStorage.setItem('user', JSON.stringify(user))
		return { code: 200, msg: 'success' }
	}
	async function register(form_name: string, form_id: string, form_phone: string, passwd: string) {
		// name.value = form_name
		// id.value = form_id
		// phone.value = form_phone
		const passwd_hash = Base64.stringify(hmacSHA256(passwd, salt))
		console.log(passwd_hash)
		return { code: 200, msg: 'success' }
	}
	function logout() {
		name.value = ''
		id.value = ''
		phone.value = ''
		localStorage.removeItem('token')
		localStorage.removeItem('user')
		router.push('/')
	}
	function load() {
		const user = localStorage.getItem('user')
		if (user) {
			const user_json = JSON.parse(user)
			name.value = user_json.name
			id.value = user_json.id
			phone.value = user_json.phone
			return true
		}
		return false
	}
	async function checkLogin() {
		if (!load()) {
			logout()
			return false
		}
		return true
	}
  

  return { name, id, phone, login, register, logout, load, checkLogin }
})
