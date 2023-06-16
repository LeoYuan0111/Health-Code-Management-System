import { ref } from 'vue'
import { defineStore } from 'pinia'
import { useRouter } from 'vue-router'
import { getURL } from '@/utils/url'
import { fetchGetJSON, fetchPostJSON, fetchPostText } from '@/utils/fetch'

// const { setToken, fetchPostJSON, fetchPostText } = useTokenStore()

import hmacSHA256 from 'crypto-js/hmac-sha256'
import Hex from 'crypto-js/enc-hex'

export const useUserStore = defineStore('user', () => {
  const name = ref('')
  const id = ref('')
  const phone = ref('')
  const token = ref('')
  const router = useRouter()

  const admin = ref(false)
  const sampler = ref(false)
  const tester = ref(false)
  
  const salt = '_healthcodeapp2023SE'

  function setToken (value: string) {
    token.value = value
    localStorage.setItem('token', value)
  }

  async function getinfo () {
    const { code, data } = await fetchPostJSON(getURL('/account/identify_info'), {}, {})
    if (code === 200) {
      ;(id.value = data.idNumber), (phone.value = data.phoneNumber)
      admin.value = data.admin
      sampler.value = data.sampler
      tester.value = data.tester
    }
    const { code: code2, data: data2 } = await fetchGetJSON(getURL('/person/user/user_info'), {})
    if (code2 === 200) {
      name.value = data2.realName
    }
  }

  async function login (form_id: string, passwd: string) {
    const passwd_hash = Hex.stringify(hmacSHA256(passwd, salt))
    // console.log(passwd_hash)
    try {
      const { code, data } = await fetchPostJSON(
        getURL('/account/login'),
        { user_id: form_id, passwd: passwd_hash },
        {}
      )
      if (code !== 200) {
        return false
      }
      id.value = form_id

      phone.value = data.phoneNumber
      localStorage.setItem('token', data.token)
      setToken(data.token)
      await getinfo()

      return true
    } catch (e) {
      return false
    }
  }
  async function register (form_name: string, form_id: string, form_phone: string, passwd: string) {
    const passwd_hash = Hex.stringify(hmacSHA256(passwd, salt))
    console.log(passwd_hash)
    const { code } = await fetchPostText(
      getURL('/account/register'),
      {
        user_id: form_id,
        passwd: passwd_hash,
        phone: form_phone,
      }, {}
    )
    console.log(code)
    if (code !== 200) {
      return { code: 400, msg: '注册失败' }
    }

    return { code: 200, msg: 'success' }
  }

  function logout () {
    name.value = ''
    id.value = ''
    phone.value = ''
    setToken('')

    localStorage.removeItem('token')
    router.push('/')
  }

  function load () {
    const cached_token = localStorage.getItem('token')
    if (cached_token) {
      setToken(cached_token)
      return true
    }
    return false
  }

  async function checkLogin () {
    if (!load()) {
      logout()
      return false
    }
    const { code, data } = await fetchPostText(getURL('/account/checklogin'), {}, {})
    if (code !== 200) {
      logout()
      return false
    }
    setToken(data)
    await getinfo()
    return true
  }

  return { name, id, phone, admin, sampler, tester, login, register, logout, load, checkLogin }
})
