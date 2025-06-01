<template>
  <div class="px-8 pb-40 relative">
    <h1 class="text-center text-2xl font-bold text-gray-800">게시판 목록</h1>
    <!-- <select> :드롭 다운 목록을 만듬, 사용자가 여러 옵션 중 하나 또는 여러개 선택 할 수 있게 해주는 폼요소 -->
    <!-- <option> 와 함께 쓰임-->
    <select
      lass="border rounded px-4 py-2 mt-6 mb-4 w-52"
      v-model="selectedCategory"
    >
      <option value="all">전체</option>
      <option
        v-for="category in categories"
        :key="category.categoryId"
        :value="category.categoryId"
      >
        {{ category.categoryName }}
      </option>
    </select>

    <ul>
      <li
        v-for="board in boardList"
        :key="board.boardId"
        @click="goDetail(board.boardId)"
        class="bg-gray-100 p-4 rounded-lg shadow mb-4 flex items-center cursor-pointer hover:bg-gray-200"
      >
        <!-- board.img 는 borad.js에서 서버에서 받아온 boradList에 속한 속성(swagger 확인) -->
        <img
          :src="board.img || 'http://via.placeholder.com/160'"
          alt="board image"
          class="w-28 h-28 rounded mr-4"
        />
        <div class="flex flex-col flex-1">
          <div class="flex justify-between">
            <h2 class="text-lg font-bold text-blue-500">{{ board.title }}</h2>
            <span class="text-sm italic text-gray-600">{{ board.email }}</span>
          </div>
          <p class="text-sm text-gray-700 mt-2">{{ board.content }}</p>
          <p class="text-right text-xs text-gray-500">
            {{ timeFromNow(board.regDate) }}
          </p>
        </div>
      </li>
    </ul>

    <button
      @click="goWrite"
      class="fixed bottom-6 right-8 bg-slate-700 hover:bg-sky-600 text-white rounded-full w-14 h-14 text-3xl shadow-lg"
    >
      +
    </button>
  </div>
</template>

<script setup>
import { ref, onMounted, watch } from "vue";
import { useRouter } from "vue-router";
import { useBoardApi } from "@/api/board";

// useBoardApi() 함수가 반환한 객체에서 boardList라는 함수를 추출해서 이름을 fetchBoardList로 바꾼 것
// //boardList: API함수,fetchBoardList는 아마도 서버에서 게시글 목록을 가져오는 **비동기 함수(API 호출 함수)
const { cateList, boardList: fetchBoardList } = useBoardApi();
const categories = ref([]);
// boardList:반응형 함수,게시글 목록 데이터를 담을 배열이고, UI에서 사용
const boardList = ref([]);
const selectedCategory = ref("all");
const router = useRouter();

//dayjs 관련 설정
import dayjs from "dayjs"; //날짜 포맷, 계산 표시 등 간편하게
import relativeTime from "dayjs/plugin/relativeTime"; //이 플러그인이 있어야 "5분 전", "2일 전" 같은 기능이 작동
import "dayjs/locale/ko"; //한국어 설정
dayjs.extend(relativeTime); //플러그인을 dayjs에 확장(등록),fromNow()를 쓸 수 있게 해주는 필수 설정
dayjs.locale("ko");

//내부에서 상대 시간 포맷 함수 구현
const timeFromNow = (dateStr) => dayjs(dateStr).fromNow();

const loadBoardList = async () => {
  const res = await fetchBoardList();
  boardList.value =
    selectedCategory.value === "all"
      ? res.data
      : res.data.filter(
          (board) => board.categoryId === parseInt(selectedCategory.value)
        );
};

onMounted(async () => {
  const res = await cateList();
  categories.value = res.data;
  await loadBoardList();
});

// selectedCategory가 바뀔 때마다 → loadBoardList()를 호출해서 목록을 새로 필터링
watch(selectedCategory, async () => {
  await loadBoardList();
});

const goWrite = () => router.push("/boardwrite");
const goDetail = (id) => router.push(`/boarddetail/${id}`);
</script>
