<template>
  <input v-model="name" placeholder="이름을 입력하세요" />
  <h3 v-if="isLogin">환영합니다. {{ name }}님.</h3>
  <h3 v-else>로그인 후 사용하세요.</h3>
</template>

<script setup>
import { ref, computed } from "vue";

const name = ref("");

// name이 비어있지 않을 때만 로그인된 상태로 간주
const isLogin = computed(() => name.value.trim() !== "");
</script>
