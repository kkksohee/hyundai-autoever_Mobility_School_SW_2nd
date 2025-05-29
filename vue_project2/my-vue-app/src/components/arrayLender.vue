<!-- <template>
  <ul>
    <li v-for="user in users" :key="user.id">
      이름: {{ user.userName }}, 이메일: {{ user.email }}
    </li>
  </ul>
</template>

<script setup>
const users = [
  { id: 1, userName: "안유진", email: "test1@naver.com" },
  { id: 2, userName: "카리나", email: "test2@naver.com" },
  { id: 3, userName: "장원영", email: "test3@naver.com" },
];
</script> -->

<template>
  <input v-model="inputText" @keydown.enter="addTodo" />
  <button @click="addTodo">추가</button>
  <ul>
    <li
      v-for="user in users"
      :key="user.id"
      @dblclick="() => removeTodo(user.id)"
    >
      {{ user.toDo }}
    </li>
  </ul>
</template>

<script setup>
import { ref, watch } from "vue";
const stored = localStorage.getItem("users");
const users = ref(
  stored
    ? JSON.parse(stored)
    : [
        { id: 1, toDo: "HTML 공부" },
        { id: 2, toDo: "CSS 복습" },
      ]
);

//ref 배열도 됨. watch()같은걸로 reactive로 감시할때 무거워서 안되는 경우가 있음
// const users = ref([
//   { id: 1, toDo: "HTML 공부" },
//   { id: 2, toDO: "CSS 복습" },
// ]);

//상태변화?
const inputText = ref("");
const nextId = ref(3);

// 좌우 공백 제거한 다음에 좌우input값이 없을 때 return
const addTodo = () => {
  if (!inputText.value.trim()) return;
  // push 배열에 값을 집어 넣는것 (리액트는 push 안됨 주소값이 바뀌어야 하니까 새로운 배열을 매번 만들어줘야함)
  users.value.push({ id: nextId.value++, toDo: inputText.value });
  inputText.value = "";
};

// ref 값 추적하려면 value는 써야함
// filter뒤어 입력하는 조건 만 users.value에 들어감
const removeTodo = (id) => {
  users.value = users.value.filter((user) => user.id !== id);
};
watch(
  users,
  (newVal) => {
    localStorage.setItem("users", JSON.stringify(newVal));
  },
  { deep: true }
);
</script>
