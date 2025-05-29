<template>
  <form @submit.prevent="submitComment" class="mt-6 space-y-2">
    <input
      v-model="content"
      placeholder="댓글을 입력하세요"
      class="w-full p-2 border rounded"
    />
    <button type="submit" class="px-4 py-2 bg-blue-500 text-white rounded">
      댓글 추가
    </button>
  </form>
</template>

<script setup>
import { ref } from "vue";
import { useBoardApi } from "@/api/board";

const props = defineProps({ boardId: String });
const emit = defineEmits(["comment-added"]);
const content = ref("");
const email = localStorage.getItem("email");

const { commentWrite } = useBoardApi();

const submitComment = async () => {
  if (!content.value) return;
  await commentWrite(email, props.boardId, content.value);
  content.value = "";
  emit("comment-added");
};
</script>
