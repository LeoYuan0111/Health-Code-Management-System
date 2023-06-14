<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'
import moment from 'moment'
import IconQuery from '@/components/icons/IconQuery.vue'
import IconRing from '@/components/icons/IconRing.vue'
import IconSiteCode from '@/components/icons/IconSiteCode.vue'
import IconSite from '@/components/icons/IconSite.vue'
import IconProfile from '@/components/icons/IconProfile.vue'
import { useUserStore } from '@/stores/user'
import { useRnaRecordStore } from '@/stores/rna_record'
import { fetchPostBlob } from '@/utils/post'
import { getURL } from '@/utils/url'

let user = useUserStore()
let record = useRnaRecordStore()

let router = useRouter();

let getTime = () => {
	return moment().format('HH:mm:ss')
}
let getDate = () => {
	return moment().format('M') + ' 月 ' + moment().format('D') + ' 日'
}

let time = ref(getTime())
let date = ref(getDate())
let qrcode = ref('')
let record_date = ref('')
let record_result = ref('')

onMounted(async () => {
	setInterval(() => {
		time.value = getTime()
		date.value = getDate()
	}, 1000)
	const { data: blob } = await fetchPostBlob(getURL('/health-code/user/health_code'), {}, {})
	const reader = new FileReader()
	reader.onload = () => {
		qrcode.value = reader.result as string
		// console.log('qrcode: ', reader.result)
	}
	reader.readAsDataURL(blob)
	await record.getRecords()
	const { diff, result } = await record.getLatestRecord()
	record_date.value = diff
	record_result.value = result
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
			<el-row class="name-row" justify="space-between">
				<el-col :span="6" class="name">
					{{ user.name }}
				</el-col>
				<el-col :span="18" class="id">
					{{ user.id }}
				</el-col>
			</el-row>
			<el-row class="qrcode" justify="center">
				<el-col :span="20">
					<img id="code-canvas" class=""
						:src="qrcode" />
				</el-col>
			</el-row>
			<el-row class="result-row" justify="space-between">
				<el-col :span="11">
					<el-row class="result-block">
						<el-row class="rna-time">
							{{ record_date }}
						</el-row>
						<el-row class="rna-result">
							{{ record_result }}
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
							场所码扫描
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
					<el-button type="primary" class="nav-button" @click="router.push('/rna_site')">
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
					<el-button type="primary" class="nav-button" @click="router.push('/user/info')">
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
	
}
.name {
	font-size: 1.2rem;
	font-weight: bolder;
}
.id {
	font-size: 1.1rem;
	font-weight: bolder;
	align-items: center;
	justify-content: right;
	display: flex;
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
	padding: 0;
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
