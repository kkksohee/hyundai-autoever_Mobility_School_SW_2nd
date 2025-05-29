<template>
  <div class="p-4 max-w-md mx auto bg-white shadow rounded">
    <h2 class="text-xl font-semibold mb-4">사용자 정보 입력</h2>

    <div class="mb-2">
      <label class="block mb-1">이름</label>
      <input v-model="form.name" class="border px-2 py-1 w-full" />
    </div>
    <div class="mb-1">
      <label class="block mb-1">나이</label>
      <input v-model="form.age" type="number" class="border px-2 py-1 w-full" />
    </div>

    <p class="mb-4">
      현재 상태: <strong>{{ isAdult ? "성인" : "미성년자" }}</strong>
    </p>

    <button
      @click="handleSubmit"
      class="bg-blue-500 text-whit px-4 py-2 rounded"
    ></button>
  </div>
</template>

<script setup>
import { ref, reactive, computed, watch, onMounted } from "vue";

//1. 사용자 입력 상태
const form = reactive({
  name: "",
  age: 0,
});
//2. computed로 성인 여부 판단
const isAdult = computed(() => form.age >= 20);

//3. 나이 변화 추적
watch(
  () => form.age,
  (newAge, oldAge) => {
    console.log(`나이가 ${oldAge} -> ${newAge}로 변경됨`);
  }
);
//4. onMounted : 초기 실행
onMounted(() => {
  console.log("폼 컴포넌트가 마운트 되었습니다.");
});
//5. 제출처리
const handleSubmit = () => {
  alert(`$(form.name)님은 ${isAdult.value ? "성인" : "미성년자"}입니다.`);
};
</script>
