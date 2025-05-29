<template>
  <div style="padding: 2rem">
    <h2>computed 예제</h2>
    <input v-model.number="num0" placeholder="숫자 1 입력" />
    <input v-model.number="num1" placeholder="숫자 1 입력" />
    <input v-model.number="num2" placeholder="숫자 2 입력" />
    <p>합계 : {{ sum }}</p>
  </div>
</template>

<script setup>
import { ref, computed } from "vue";
const num0 = ref(0);
const num1 = ref(0);
const num2 = ref(0);

//conputed는 의존하는 값이 변경될 때만 재계산됨
// 함수가 달라도 매번 불림
//값이 입력될 때마다 랜더링
//계산을 안할 때는 기존값을 유지 - 캐싱

const sum = computed(() => {
  console.log("sum 값 재계산");
  return num1.value + num2.value;
});
</script>
<style scoped>
input {
  padding: 8px;
  margin-right: 8px;
  width: 120px;
}
p {
  margin-top: 1rem;
  font-weight: bled;
}
</style>
