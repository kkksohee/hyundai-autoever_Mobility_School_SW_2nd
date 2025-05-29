<template>
  <!-- form태그: 폼 데이터를 제출할 수 있는 역할 -->
  <!-- @submit : v-on:submit의 축약형, submit이벤트 리스너 추가 -->
  <!-- .prevent : HTML기본 동작을 막음 vue로 이벤트처리->브라우저의 기본 폼 제출(페이지 새로고침)방지 
   ㄴform은 기본적으로 데이터를 서버에 제출 하면서 페이지를 새로 고침-->
  <!-- =>사용자 폼 제출 -페이지 새로 고침 x, onSubmit()호출 -->
  <form @submit.prevent="onSubmit" class="flex bg-gray-600">
    <input
      v-model="value"
      type="text"
      placeholder="카테고리 입력"
      class="flex-1 px-4 py-2 text-white bg-transparent border-none outline-none placeholder-gray-300"
    />
    <button
      type="submit"
      class="px-4 text-white bg-gray-500 hover:bg-green-400"
    >
      ➕
    </button>
  </form>
</template>

<script setup>
import { ref } from "vue";
const emit = defineEmits(["insert"]);
const value = ref("");

const onSubmit = () => {
  emit("insert", value.value); //부모에게 값 전달
  value.value = ""; //입력값 초기화
};
</script>
