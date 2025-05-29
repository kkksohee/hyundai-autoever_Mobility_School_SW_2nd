<script setup>
import HelloWorld from "./components/HelloWorld.vue";
// import baseButton from "./components/base/baseButton.vue";

import login from "./components/pages/login.vue";
import signUp from "./components/pages/signUp.vue";
import memberList from "./components/pages/memberList.vue";

const handleClick = () => {
  console.log("부모 컴포넌트: 버튼이 눌렸습니다!");
};

import { useThemeStore } from "@/stores/theme";
const themeStore = useThemeStore();
</script>

<template>
  <!-- <div>
    <a href="https://vite.dev" target="_blank">
      <img src="/vite.svg" class="logo" alt="Vite logo" />
    </a>
    <a href="https://vuejs.org/" target="_blank">
      <img src="./assets/vue.svg" class="logo vue" alt="Vue logo" />
    </a>
  </div>
  <HelloWorld msg="Vite + Vue" /> -->
  <!-- <div class="flex flex-col items-center justify-center min-h-screen space-y-4">
    <baseButton @click="handleClick">회원 가입</baseButton>
    <baseButton @click="handleClick">로그인</baseButton>
    <baseButton @click="handleClick" class="bg-green-500 hover:bg-green-600">
      다른 색 버튼
    </baseButton>
  </div> -->

  <!-- <login /> -->
  <!-- <signUp /> -->
  <!-- <memberList /> -->

  <!-- router-link : 페이지 새로고침 없이 이동시켜줌 -->
  <!-- <nav>
 <   <router-link to="/">홈</router-link>
    <router-link to="/about">소개</router-link>
  </nav> -->

  <!-- router-view는 현재 URL에 해당하는 컴포넌트를 이자리에 보여줌 -->
  <!-- <div>
    <router-view />
  </div> -->

  <!-- 5/20 -->
  <div
    :style="{ backgroundColor: themeStore.color }"
    class="min-h-screen transition-all"
  >
    <router-view />
  </div>
</template>

<!-- <style scoped>
 .logo {
  height: 6em;
  padding: 1.5em;
  will-change: filter;
  transition: filter 300ms;
}
.logo:hover {
  filter: drop-shadow(0 0 2em #646cffaa);
}
.logo.vue:hover {
  filter: drop-shadow(0 0 2em #42b883aa);
} 
</style> -->
