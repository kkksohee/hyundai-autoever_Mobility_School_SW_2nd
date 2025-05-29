<template>
  <div class="card">
    <h2>이름:{{ userEX1.name }}</h2>
    <p>직업: {{ userEX1.job }}</p>
    <p>나이 :{{ userEX1.age }}</p>
  </div>
  <div class="card">
    <h2>이름:{{ userEX2.name }}</h2>
    <p>직업: {{ userEX2.job }}</p>
    <p>나이 :{{ userEX2.age }}</p>
  </div>
</template>

<script setup>
const props = defineProps({
  userEX1: Object,
  userEX2: Object,
});
</script>

<style scoped>
.card {
  border: 1px solid #ccc;
  padding: 1rem;
  border-radius: 8px;
}
</style>
