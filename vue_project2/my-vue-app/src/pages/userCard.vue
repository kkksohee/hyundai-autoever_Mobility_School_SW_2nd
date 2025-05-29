<template>
  <div class="container">
    <h2>회원 정보</h2>
    <userItem v-for="user in users" :key="user.name" :user="user" />
  </div>
</template>

<script setup>
import { reactive, onMounted } from "vue";
import userItem from "../components/userItem.vue";
const users = reactive([]);

const fetchedData = [
  { name: "장원영", age: 22, addr: "서울 강남", isAdult: true },
  { name: "닝닝", age: 21, addr: "서울 강북", isAdult: true },
  { name: "하니", age: 20, addr: "서울 노원", isAdult: true },
  { name: "지젤", age: 28, addr: "의정부 민락", isAdult: true },
  { name: "민지", age: 29, addr: "서울 중구", isAdult: true },
  { name: "혜린", age: 19, addr: "서울 중구", isAdult: false },
];

//화면이 처음 나타나는 시작점
onMounted(() => {
  // onMounted 될때 서버로 데이터를 요청하고 ->
  // 데이터가 전달되면 아래의 동작 진행
  //사실의  await의 return값이 fetchedData임
  // 받아오면 랜더링
  users.push(...fetchedData);
});
</script>

<style scoped>
.container {
  width: 500px;
  margin: 40px auto;
  text-align: center;
  background-color: antiquewhite;
}
</style>
