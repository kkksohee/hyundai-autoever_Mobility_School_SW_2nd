<template>
  <div class="card_test">
    <h2>{{ newsitem_test1.title }}</h2>
    <p>내용: {{ newsitem_test1.content }}</p>
    <p>날짜: {{ newsitem_test1.data }}</p>
    <p>카테고리: {{ newsitem_test1.category }}</p>
  </div>
</template>

<script setup>
const props = defineProps({
  newsitem_test1: Object,
});
</script>

<style scoped>
.card_test {
  background-color: aliceblue;
  padding: 1rem;
  border-radius: 5px;
  width: 200px;
  border: 1px solid black;
  margin: 1rem auto;
}
</style>
