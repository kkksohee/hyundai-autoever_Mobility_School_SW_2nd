<template>
  <NewsItem_test
    v-for="newsitem_test in newsList_test"
    :key="newsitem_test.title"
    :newsitem_test1="newsitem_test"
  />
</template>

<script setup>
// NewsList_test의 자식 NewsItem
import NewsItem_test from "./NewsItem_test.vue";

const props = defineProps({
  newsList_test: Array,
});
</script>
