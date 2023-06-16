import { reactive, computed } from 'vue'
import { defineStore } from 'pinia'
import { getURL } from '@/utils/url'
import { fetchPostJSON } from '@/utils/fetch'
import moment from 'moment'

export interface RnaRecord {
  date: string
  result: number
}
export const useRnaRecordStore = defineStore('rna_record', () => {
  const records = reactive<RnaRecord[]>([])
  async function getRecords () {
    const { data } = await fetchPostJSON(getURL('/rna_detect_result'), {}, {})
		records.splice(0, records.length)
		// console.log(data)
    data.forEach((record: any) => {
      records.push({
        date: record.date,
        result: record.result
      })
    })
  }
  async function getLatestRecord () {
    await getRecords()
		if (records.length === 0) {
			return {
				diff: '无结果',
				result: '无结果'
			}
		}
    console.log(records)
    const record = records[0]
    const record_date = moment(record.date)
    const getdiff = (date: moment.Moment) => {
      const now = moment()
      const diff_day = now.diff(date, 'day')
      const diff_hour = now.diff(date, 'hour')
      if (diff_hour <= 72) {
        return diff_hour + ' 小时'
      }
      return diff_day + ' 天'
    }
    const diff = getdiff(record_date)
    const getresult = (result: number) => {
      if (result === 0) {
        return '报告未出'
      } else if (result === 1) {
        return '阴性'
      } else {
        return '阳性'
      }
    }
    const result = getresult(record.result)
    return {
      diff,
      result
    }
  }
	const currentRecords = computed((currentPage: number, pageSize: number) => {
		return records.slice(currentPage, currentPage + pageSize)
	})
	function getLength() {
		return records.length
	}
	return {
		records,
		getRecords,
		getLatestRecord,
		currentRecords,
		getLength
	}
})
