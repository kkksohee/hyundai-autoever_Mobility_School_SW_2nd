<template>
  <div class="card">
    <h2>{{ newsitem_out.title }}</h2>
    <p>내용: {{ newsitem_out.content }}</p>
    <p>날짜: {{ newsitem_out.date }}</p>
    <p>카테고리 : {{ newsitem_out.content }}</p>
  </div>
</template>

<script setup>
const props = defineProps({
  newsitem_out: Object,
});
</script>

<style scoped>
.card {
  border: 1px solid #ccc;
  padding: 1rem;
  border-radius: 6px;
  width: 300px;
  background-color: rgba(245, 240, 112, 0.8);
  margin: 1rem auto;
}
</style>
