<template>
  <div>
    <h1>홈입니다</h1>
    <p>가장 먼저 보이는 페이지입니다.</p>
    <router-link to="/about">소개 페이지로 이동</router-link>
    <!-- <router-link to=></router-link> -->
    <input v-model="name" @keyup.enter="goToProfile" placeholder="프로필보기" />
    <button @click="goToProfile"></button>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
const name = ref("");
const router = useRouter();
const goToProfile = () => {
  router.push(`/profile/${name.value}`);
};
</script>
