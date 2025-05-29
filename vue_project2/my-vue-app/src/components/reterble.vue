<template>
  <ul>
    <!-- 변경점 감지를 위해 유일한 식별자 id를 넣어주는 것 -->
    <li v-for="item in items" :key="item.id">{{ item.name }}</li>
  </ul>
</template>

<script setup>
const items = [
  { id: 1, name: "React" },
  { id: 2, name: "vue" },
  { id: 3, name: "swift" },
];
</script>
