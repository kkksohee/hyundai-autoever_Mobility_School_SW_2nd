<!-- 부모  -->

<template>
  <UserItem v-for="user in users" :key="user.name" :user="user" />
</template>

<script setup>
import { reactive } from 'vue'

import UserItem from './UserItem.vue'
const users = reactive([])

const fetchedData = [
  { name: '장원영', age: 20, address: '서울 강남구', isAdult: true },
  { name: '안유진', age: 19, address: '서울 마포구', isAdult: false },
  { name: '김민지', age: 22, address: '부산 해운대구', isAdult: true },
  { name: '최수빈', age: 17, address: '인천 연수구', isAdult: false },
  { name: '이도현', age: 25, address: '대구 수성구', isAdult: true },
  { name: '박소영', age: 16, address: '경기 고양시', isAdult: false },
  { name: '윤지후', age: 30, address: '광주 북구', isAdult: true },
  { name: '한서진', age: 21, address: '서울 동작구', isAdult: true },
  { name: '정지훈', age: 18, address: '대전 유성구', isAdult: false },
  { name: '강채영', age: 23, address: '울산 남구', isAdult: true },
]

onMounted(() => {
  users.push(...fetchedData)
})
</script>
