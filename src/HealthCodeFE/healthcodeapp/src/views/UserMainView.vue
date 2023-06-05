<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'
import moment from 'moment'
import IconQuery from '@/components/icons/IconQuery.vue'
import IconRing from '@/components/icons/IconRing.vue'
import IconSiteCode from '@/components/icons/IconSiteCode.vue'
import IconSite from '@/components/icons/IconSite.vue'
import IconProfile from '@/components/icons/IconProfile.vue'

let router = useRouter();

let getTime = () => {
	return moment().format('HH:mm:ss')
}
let getDate = () => {
	return moment().format('M') + ' 月 ' + moment().format('D') + ' 日'
}

let time = ref(getTime())
let date = ref(getDate())

onMounted(() => {
	setInterval(() => {
		time.value = getTime()
		date.value = getDate()
	}, 1000)
})


</script>

<template>
	<el-container class="container">
		<el-header height="15vh" class="header">
			<h1 class="date">{{ date }}</h1>
			<h1 class="time">{{ time }}</h1>
			<el-divider class="divider" />
		</el-header>
		<el-main class="main">
			<el-row class="name-row">
				唐可可
			</el-row>
			<el-row class="qrcode" justify="center">
				<el-col :span="20">
					<img id="code-canvas" class=""
						src="data:image/png;base64,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" />
				</el-col>
			</el-row>
			<el-row class="result-row" justify="space-between">
				<el-col :span="11">
					<el-row class="result-block">
						<el-row class="rna-time">
							> 3 天
						</el-row>
						<el-row class="rna-result">
							阴性
						</el-row>
					</el-row>
					<el-row class="query-block">
						<el-button class="query-button" @click="router.push('/user/rna_record')">
							核酸检测查询
						</el-button>
					</el-row>

				</el-col>
				<el-col :span="11">
					<el-row class="result-block">
						<el-row class="vac-result">
							已完成加强接种
						</el-row>
					</el-row>
					<el-row class="query-block">
						<el-button class="query-button" @click="router.push('/user/vac_record')">
							疫苗接种查询
						</el-button>
					</el-row>
				</el-col>
			</el-row>
		</el-main>
		<el-footer class="footer">
			<el-row class="nav-row" justify="space-between">
				<el-col :span="4" class="nav-block">
					<el-button type="primary" class="nav-button">
						<el-row class="nav-icon">
							<el-icon :size="30">
								<IconQuery />
							</el-icon>
						</el-row>
						<el-row class="nav-text">
							行程码查询
						</el-row>
					</el-button>

				</el-col>
				<el-col :span="4" class="nav-block">
					<el-button type="primary" class="nav-button">
						<el-row class="nav-icon">
							<el-icon :size="30">
								<IconRing />
							</el-icon>
						</el-row>
						<el-row class="nav-text">
							健康码申诉
						</el-row>
					</el-button>
				</el-col>
				<el-col :span="4" class="nav-block">
					<el-button type="primary" class="nav-button">
						<el-row class="nav-icon">
							<el-icon :size="35">
								<IconSiteCode />
							</el-icon>
						</el-row>
						<el-row class="nav-text">
							场所码申请
						</el-row>
					</el-button>
				</el-col>
				<el-col :span="4" class="nav-block">
					<el-button type="primary" class="nav-button">
						<el-row class="nav-icon">
							<el-icon :size="30">
								<IconSite />
							</el-icon>
						</el-row>
						<el-row class="nav-text">
							采样点查询
						</el-row>
					</el-button>
				</el-col>
				<el-col :span="4" class="nav-block">
					<el-button type="primary" class="nav-button">
						<el-row class="nav-icon">
							<el-icon :size="30">
								<IconProfile />
							</el-icon>
						</el-row>
						<el-row class="nav-text">
							个人信息查询
						</el-row>
					</el-button>
				</el-col>
			</el-row>
		</el-footer>
	</el-container>
</template>


<style scoped>
.time {
	font-size: 2.5rem;
	font-family: 'Consolas', sans-serif;
	font-weight: bolder;
}

.date {
	font-size: 1.5rem;
	font-family: 'Consolas', sans-serif;
	font-weight: bolder;
}

.main {
	display: flex;
	justify-content: start;
	align-items: center;
	flex-direction: column;
	height: 70vh;
	padding-top: 0.5rem;
}

.name-row {
	width: 100%;
	font-size: 1.2rem;
	font-weight: bolder;
}

.qrcode {
	width: 100%;
	height: 50%;
	margin-top: 1rem;
}

#code-canvas {
	width: 100%;
	height: auto;
	border: 1px solid #01a28c;
	padding: 0.6rem;
}

.result-row {
	width: 100%;
	height: 20vh;
	margin-top: 1rem;
	align-self: end;
}

.result-block {
	width: 100%;
	height: 50%;
	/* border: 1px solid #019874; */
	background: #019874;
	border-radius: 1rem;
	align-items: center;
	justify-content: center;
}

.vac-result {
	color: white;
	font-size: 1.2rem;
	font-weight: bold;
	width: 70%;
	justify-content: center;
	text-align: center;
}

.rna-time {
	color: white;
	font-size: 1.5rem;
	font-weight: bold;
	margin: 0 auto;
	height: 50%;
	width: 100%;
	justify-content: center;
	align-items: center;
}

.rna-result {
	color: white;
	font-size: 1.5rem;
	font-weight: bold;
	margin: 0 auto;
	height: 50%;
	width: 100%;
	justify-content: center;
	align-items: center;
}

.query-block {
	height: 50%;
	width: 100%;

}

.query-button {
	width: 90%;
	height: 30%;
	background: #019874;
	border: 0;
	margin: 1rem auto;
	border-radius: 1rem;
	color: white;
	font-size: 1rem;
	font-weight: bolder;
	/* font-family: 'SimHei', sans-serif; */
}

.main-button {
	width: 95%;
	height: 3rem;
	margin: 1rem 0;
	font-size: 1.2rem;
	font-weight: bolder;
}

.header {
	display: flex;
	justify-content: end;
	align-items: center;
	flex-direction: column;
	/* border-bottom: 1px solid #01a28c; */
	width: 100%;
}

.divider {
	margin-bottom: 0;
	margin-top: 0.5rem;
	color: black;
	/* width: 100%; */
}

.container {
	display: flex;
	flex-direction: column;
	justify-content: start;
	align-items: center;
}

.footer {
	position: absolute;
	bottom: 0;

	width: 100%;
	height: 15vh;
	/* border: 1px solid #01a28c; */
	background: rgba(1, 152, 116, 0.5);
	border-radius: 1rem 1rem 0 0;
}

.nav-row {
	width: 100%;
	height: 80%;
	/* border: 1px solid black; */
	margin-top: 0.5rem;
}

.nav-block {
	width: 100%;
	height: 100%;
	/* border: 1px solid black; */
	border-radius: 1rem;
	position: relative;
}

.nav-button {
	width: 100%;
	height: 100%;
	border: 0;
	border-radius: 1rem;
	background: #01a28c;
	color: white;
	font-size: 1.2rem;
	font-weight: bolder;
	padding: 0;
}

.nav-icon {
	position: absolute;
	width: 100%;
	height: 50%;
	left: 0;
	top: 0;
	justify-content: center;
	align-items: center;
}

.nav-text {
	position: absolute;
	width: 100%;
	height: 50%;
	left: 0;
	bottom: 0;
	text-align: center;
	color: white;
	font-size: 0.9rem;
	font-weight: bolder;
	white-space: normal;
	line-height: 1.2rem;
	padding: 0 0.2rem;
}
</style>
