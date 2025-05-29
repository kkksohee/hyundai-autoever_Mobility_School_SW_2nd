<template>
  <CateTemplate>
    <!-- 자식 component가 발생시키는 insert이벤트를 부모가 듣고 실행할 함수 연결 -->
    <!-- 개발자가 자식 컴포넌트에서 emit('insert')로 정의한 이벤트 이름 -->
    <CateInsert @insert="onInsert" />
    <CateList :cates="categories" @remove="onRemove" />
  </CateTemplate>
</template>

<script setup>
import { ref, onMounted } from "vue";
import CateInsert from "../components/category/CateInsert.vue";
import CateList from "../components/category/CateList.vue";
import CateTemplate from "../components/category/CateTemplate.vue";

import { useBoardApi } from "@/api/board";
const { cateList, cateInsert, cateDelete } = useBoardApi();

import { useModalStore } from "@/stores/modal";
const modal = useModalStore();

const email = localStorage.getItem("email");
const categories = ref([]);
const selectedCategoryId = ref(null);

const loadCategory = async () => {
  const res = await cateList();
  categories.value = res.data;
};
onMounted(loadCategory);

const onInsert = async (text) => {
  try {
    const res = await cateInsert(email, text);
    if (res.data) await loadCategory(); //cateInsert()요청 성공 -> 데이터 반환 -> 카테고리 목록 불러와서 화면 최신 상태로 유지
  } catch (error) {
    modal.open({
      title: "오류",
      meessage: "카테고리 추가에 실패했습니다.",
    });
  }
};

// CateList(자식)이 보내준 이벤트 받아서 함수 실행
const onRemove = (id) => {
  selectedCategoryId.value = id;
  modal.open({
    title: "오류",
    message: "카테고리를 정말 삭제하시겠습니까?",
    hasCancel: true,
    onConfirm: confirmMoal,
  });
};

const confirmMoal = async () => {
  try {
    const res = await cateDelete(selectedCategoryId.value);
    if (res.data) await loadCategory();
  } catch (error) {
    modal.open({
      title: "오류",
      message: "카테고리 삭제에 실패했습니다.",
    });
  }
};
</script>
