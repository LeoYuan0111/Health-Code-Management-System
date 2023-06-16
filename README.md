# Health-Code-Project
2022-2023 Software Engineering Course Project @ ZJU, based on B/S structure.

# Frontend

`/HealthCodeFE` path contains the code of backend.

- environment:
  - Node.js latest
  - Npm latest

Use `nvm` to install latest Node.js.

## Run
```bash
cd src/HealthCodeFE/healthcodeapp
npm i
npm run dev
```
这里仅是运行了一个开发服务器，如果要部署到服务器上，需要使用 `npm run build`，然后将 `dist` 文件夹下的文件放到后端，建立一个文件服务器或者直接配 nginx。
## 如何更改后端地址
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
修改此处的地址即可
## 如何连接数据库
推荐使用 Jetbrains DataGrip 或者 JetBrains IntelliJ IDEA Ultra 的 Database 工具连接数据库。
查看 `src/HealthCodeBE/src/main/resources/application.yml` 中的远程数据库地址账号密码，将其复制到 DataGrip 中连接即可。

## 前端设计

[Figma 项目地址](https://www.figma.com/file/A1PlJti30dm8VdjjISuA2r/Medical-Consultation-App-(Community)?type=design&node-id=0-1&t=oqQAOl96lOKB802q-0)

目前完成的功能有
- 一般用户
  - 登录/注册（注册的名字没有用）
  - 健康码颜色（数据库里直接加的用户没有颜色）
  - 核酸记录/时间
  - 疫苗记录（假的）
  - 个人信息（并没有修改功能，注册的用户没有名字，修改名字到 person 这张表里改）
  - 高级用户认证（在个人信息里）
  - 查询核酸点，点击地图上的标记信息会显示在下面
- 采样者
  - 核酸采样 （打不开扫描就手动输入），**目前只支持一人一管**
- 检测者
  - 输入试管和结果
  - 查看记录（假的）
- 管理者
  - 全是假的页面，没有实现功能，建议直接改数据库

## 如何扫码
由于目前的浏览器内核禁止了非 `localhost` 或 `https` 的网页调用摄像头，所以要设置 Chrome 浏览器的参数，在 `chrome://flags` 里找到 `Insecure origins treated as secure`，将其设置为 `Enabled`，加入前端的地址，然后重启浏览器（记得杀进程）。



# Backend

`/HealthCodeBE` path contains the code of backend.

- environment:
  - Spring Boot v3.1.0
  - OpenJDK 19.0.1

## Postman
[Postman 项目地址](https://winter-star-87776.postman.co/workspace/New-Team-Workspace~7c81e5dd-3c31-4fd4-bed1-dab7cf16f3e0/request/27529165-586d2ba0-b620-4d7c-99b9-4ea5ea4f8529)

