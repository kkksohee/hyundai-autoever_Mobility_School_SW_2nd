<template>
  <div class="max-w-2xl mx-auto p-6 bg-green-200 rounded shadow">
    <!-- 상단 작성자 정보 영역 -->
    <div class="flex items-center justify-between mb-4">
      <!-- 왼쪽: 이미지 +제목 / 내용 -->
      <div class="flex items-center gap-4">
        <img
          :src="board.img || 'http://via.placeholder.com/120'"
          alt="작성자 이미지"
          class="w-24 h-24 rounded"
        />
        <div>
          <h2 class="text-xl font-bold text-gray-800">{{ board.title }}</h2>
          <p class="text-gray-700">{{ board.content }}</p>
        </div>
      </div>
      <!-- 오른쪽 작성 시간 -->
      <p class="text-sm text-gray-600">{{ formatTime(board.regDate) }}</p>
    </div>

    <!-- 댓글 보기/숨기기 +삭제 버튼  -->
    <div class="flex justify-center gap-2 mb-4">
      <button
        @click="toggleComments"
        class="bg-green-500 text-white px-4 py-1 rounded"
      >
        {{ showComments ? "댓글 숨기기" : `댓글${comments.length}개 보기` }}
      </button>
      <button
        v-if="email === board.email"
        @click="deleteBoard"
        class="bg-green-500 text-white px-4 py-1 rounded"
      >
        삭제
      </button>
    </div>
    <!-- 댓글 입력 -->
    <CommentForm :boardId="route.params.id" @comment-added="loadComments" />
    <!-- 댓글 목록 -->
    <CommentList v-if="showComments" :comments="comments" />
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useBoardApi } from "@/api/board";
import CommentForm from "../comment/CommentForm.vue";
import CommentList from "../comment/CommentList.vue";

const { boardDetail, commentList, boardDelete } = useBoardApi();

const board = ref({});
const comments = ref([]);
const route = useRoute();
const router = useRouter();
const showComments = ref(false);
const email = localStorage.getItem("email");

const loadBoard = async () => {
  // 게시글 가져오기
  const res1 = await boardDetail(route.params.id);
  board.value = res1.data;
  console.log(route.params); //디버그
  const res2 = await commentList(route.params.id);
  comments.value = res2.data;
  // 댓글 가져오기
};

const loadComments = async () => {
  const res = await commentList(route.params.id);
  comments.value = res.data;
};

const toggleComments = () => {
  showComments.value = !showComments.value;
  if (showComments.value) loadComments();
};
const deleteBoard = async () => {
  if (confirm("정말 삭제하시겠습니까?")) {
    await boardDelete(route.params.id);
    alert("삭제 되었습니다.");
    router.push("/board");
  }
};

const formatTime = (iso) =>
  new DataTransfer(iso).toLocaleString("ko-KR", {
    year: "numeric",
    month: "2-dighit",
    day: "2-digit",
    hour: "2-2-dighit",
    minute: "2-2-dighit",
  });

onMounted(() => {
  loadBoard();
});
</script>
