# Health-Code-Project
2022-2023 Software Engineering Course Project @ ZJU, based on B/S structure.

## 1 前端环境配置

`src/HealthCodeFE` path contains the code of backend.

- environment:
  - Node.js latest
  - Npm latest

Use `nvm` to install latest Node.js.

### 1.1 设置后端地址

修改 `src/HealthCodeFE/healthcodeapp/src/utils/url.ts`
```javascript
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
```
修改此处的 IP 地址即可.

### 1.2 运行前端

```bash
cd src/HealthCodeFE/healthcodeapp
npm i
npm run dev
```

这里仅是运行了一个开发服务器，如果要部署到服务器上，需要使用 `npm run build`，然后将 `dist` 文件夹下的文件放到后端，建立一个文件服务器或者直接配 nginx。

### 1.3 扫码

由于目前的浏览器内核禁止了非 `localhost` 或 `https` 的网页调用摄像头，所以要设置 Chrome 浏览器的参数，在 `chrome://flags` 里找到 `Insecure origins treated as secure`，将其设置为 `Enabled`，加入前端的地址，然后重启浏览器（kill 进程）。



## 2 后端环境配置

`/HealthCodeBE` path contains the code of backend.

- environment:
  - Spring Boot v3.1.0
  - OpenJDK 19.0.1

### 2.1 连接数据库

推荐使用 Jetbrains DataGrip 或者 JetBrains IntelliJ IDEA Ultra 的 Database 工具连接数据库。
查看 `src/HealthCodeBE/src/main/resources/application.yml` 中的远程数据库地址账号密码，将其复制到 DataGrip 中连接即可。
