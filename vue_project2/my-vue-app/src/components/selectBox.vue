<!-- select요소 핸들링, 라디오 버튼 -->
<template>
  <select v-model="fruit">
    <option disabled value="">과일을 선택하세요</option>
    <!-- value에 있는 값이 fruit에 등록됨 -->
    <option value="alpple">사과</option>
    <option value="banana">바나나</option>
    <option value="mango">망고</option>
  </select>
  <h3>선택된 과일: {{ fruit }}</h3>
  <!-- 서버로 날리고 싶으면 fruit를 axios에 실어서 날리면 됨 -->

  <label><input type="checkbox" value="apple" v-model="selected" /> 사과</label>
  <label
    ><input type="checkbox" value="orange" v-model="selected" /> 오렌지</label
  >
  <label><input type="checkbox" value="mango" v-model="selected" /> 망고</label>
  <p>선택된 과일: {{ selected.join(",") }}</p>
</template>

<script setup>
import { ref } from "vue";
const fruit = ref("");

const selected = ref(["apple"]);
</script>
