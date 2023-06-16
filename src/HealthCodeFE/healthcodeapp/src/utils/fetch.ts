export async function fetchPost (url: string, params: any, data: any) {
  let token = localStorage.getItem('token')
  if (!token) {
    token = ''
  }
  const urlParams = new URLSearchParams()
  for (const key in params) {
    urlParams.append(key, encodeURIComponent(params[key]))
  }
  url = url + '?' + urlParams.toString()
  const res = await fetch(url, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json;charset=utf-8',
      Accept: 'application/json',
      Authorization: token,
      freshToken: token
    },
    body: JSON.stringify(data)
  })
  return { code: res.status, data: res }
}
export async function fetchPostJSON (url: string, params: any, data: any) {
  const { code, data: res } = await fetchPost(url, params, data)
  const body = await res.json()
  return { code, data: body }
}
export async function fetchPostText (url: string, params: any, data: any) {
  const { code, data: res } = await fetchPost(url, params, data)
  const body = await res.text()
  return { code, data: body }
}
export async function fetchPostBlob (url: string, params: any, data: any) {
	const { code, data: res } = await fetchPost(url, params, data)
	const body = await res.blob()
	return { code, data: body }
}
export async function fetchGet (url: string, params: any) {
  let token = localStorage.getItem('token')
  if (!token) {
    token = ''
  }
  const urlParams = new URLSearchParams()
  for (const key in params) {
    urlParams.append(key, encodeURIComponent(params[key]))
  }
  url = url + '?' + urlParams.toString()
  const res = await fetch(url, {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json;charset=utf-8',
      Accept: 'application/json',
      Authorization: token,
      freshToken: token
    },
  })
  return { code: res.status, data: res }
}
export async function fetchGetJSON (url: string, params: any) {
  const { code, data: res } = await fetchGet(url, params)
  const body = await res.json()
  return { code, data: body }
}
