<template>
  <div class="w-96 bg-white rounded-xl shadow mb-2 p-2">
    <h2 class="p-2 text-lg font-bold text">{{ memberitem_out.name }}</h2>
    <p class="p-1">이메일: {{ memberitem_out.email }}</p>
    <p class="p-1">비밀번호: {{ memberitem_out.pwd }}</p>
    <p class="p-1">가입 날짜: {{ formattedDate }}</p>
  </div>
</template>

<script setup>
const props = defineProps({
  memberitem_out: Object,
});
//regDate: 백엔드(API 서버)에서 넘겨준 값
const formattedDate = new Date(props.memberitem_out.regDate).toLocaleString(
  "ko-KR",
  {
    year: "numeric",
    month: "2-digit",
    day: "2-digit",
    hour: "2-digit",
    minute: "2-digit",
  }
);
</script>
