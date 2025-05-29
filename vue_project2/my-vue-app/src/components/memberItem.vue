<template>
  <div class="card">
    <h2>{{ memberitem_out.name }}</h2>
    <p>{{ memberitem_out.email }}</p>
    <p>{{ memberitem_out.pwd }}</p>
  </div>
</template>

<script setup>
const props = defineProps({
  memberitem_out: Object,
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
