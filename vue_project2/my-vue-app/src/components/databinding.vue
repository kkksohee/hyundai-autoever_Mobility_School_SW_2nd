<template>
  <!--화면을 그려주는 부분-->
  <h2>{{ refName }}</h2>
  <h2>{{ name }}</h2>
  <input :value="Name" @input="updateName($event)" />
</template>

<script setup>
// 데이터 로직을 정의하는 부분
//ref :원시 값을 감싸는 반응형 래퍼
// 변경의 유뮤를 감지하는 것
import { ref } from "vue"; //구조 분해, {} 해당모듈에서 ref만 가져 옴
const refName = ref("장원영");
const name = "안유진";

// const updateName = (e) => {
//   refName.value = e.target.value;
// };
const updateName = (e) => {
  name.value = e.target.value;
};
</script>
