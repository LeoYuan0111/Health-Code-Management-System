export const baseURL = () => {
	if (import.meta.env.DEV) {
		return 'http://10.112.19.13:8888'
	} else {
		return ''
	}
}
export const getURL = (url: string) => {
	return baseURL() + url
}
