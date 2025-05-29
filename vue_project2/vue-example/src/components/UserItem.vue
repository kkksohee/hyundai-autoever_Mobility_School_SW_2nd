<!-- 자식 -->

<template>
  <p>{{ user.name }}</p>
  <p>{{ user.age }}</p>
</template>

<script setup>
const props = defineProps({
  user: Object,
})
</script>
