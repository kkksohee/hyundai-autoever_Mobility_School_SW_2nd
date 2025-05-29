<template>
  <h2>이름과 나이를 입력하세요</h2>
  <input v-model="name" placeholder="이름" />
  <input v-model="age" placeholder="나이" />
  <p>성인/ 미성년 : {{ adult }}</p>
  <p>이름: {{ name }}, 나이: {{ age }}</p>
  <!-- <p>나이가 변경됐나요? {{ ageChange }}</p> -->
</template>

<script setup>
import { ref, watch, computed, onMounted } from "vue";
const name = ref("");
const age = ref(0);
const ageChange = ref("");

//나이에 따라 성인 여부 자동 계산산
const adult = computed(() => {
  if (age.value !== "") {
    if (19 < age.value) {
      console.log("성인");
      return "성인";
    } else if (0 < age.value && age.value < 20) return "미성년";
  }
});
// 나이 변경시 로그 출력
watch(age, (newVal, oldVal) => {
  console.log(`나이 변경 : ${oldVal}->${newVal}`);
  //   ageChange = "네";
});

onMounted(() => {
  console.log("컴포넌트가 마운트 됨~~~");
  //   const init.value = "컴포넌트가 마운트 됨~~~";
});
</script>

<style scoped></style>
