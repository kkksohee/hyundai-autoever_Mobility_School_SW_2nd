<template>
  <div>
    <h2>사용자 정보</h2>
    <p>이름: {{ member.Name }}</p>
    <p>나이: {{ member.age }}</p>
    <p>주소: {{ member.addr }}</p>
    <p>포지션: {{ member.position }}</p>

    <!-- 이름이 입력되면 지정한 값에 바로 반응 ->랜더링 일어남남 -->
    <input v-model="member.name" placeholder="이름입력" />
    <input type="number" v-model="member.age" placeholder="나이 입력" />
    <input v-model="member.addr" placeholder="주소입력" />
    <input v-model="member.position" placeholder="포지션션입력" />
  </div>
</template>

<script setup>
// 뷰라는 모델안에서 reactive뽑아냄
import { reactive } from "vue";
const member = reactive({
  name: "장원영",
  age: 23,
  addr: "서울시 강남구",
  position: "center",
});
</script>
