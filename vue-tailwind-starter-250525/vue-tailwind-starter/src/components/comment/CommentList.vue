<template>
  <ul class="mt-4 border-t pt-4">
    <li v-for="comment in comments" :key="comment.commentId" class="mb-3">
      <p class="text-sm text-gray-600">
        {{ comment.email }} · {{ formatDate(comment.regDate) }}
      </p>
      <p class="text-gray-800">{{ comment.content }}</p>
    </li>
  </ul>
</template>

<script setup>
const props = defineProps({ comments: Array });

const formatDate = (iso) =>
  new Date(iso).toLocaleString("ko-KR", {
    year: "numeric",
    month: "short",
    day: "numeric",
    hour: "2-digit",
    minute: "2-digit",
  });
</script>
