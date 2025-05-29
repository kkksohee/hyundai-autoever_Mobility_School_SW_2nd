<template>
  <NewsItem
    v-for="newsitem in news"
    :key="newsitem.title"
    :newsitem_out="newsitem"
  />
  <!-- :자식 컴포넌트에서 props으로 받을 이름 ="지금 반복중인 유저객체체" -->
</template>

<script setup>
import NewsItem from "./NewsItem.vue";

const props = defineProps({
  news: Array,
});
</script>
