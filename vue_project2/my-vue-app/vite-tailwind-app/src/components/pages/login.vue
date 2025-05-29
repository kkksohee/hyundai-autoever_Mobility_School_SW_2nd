<template>
  <!-- <div class="login">
    <h2>로그인</h2>
    <input v-model="login.email" type="email" placeholder="아이디 입력" />
    <input v-model="login.pwd" type="password" placeholder="비밀번호 입력" />
    <button
      class="btn"
      :class="{ enabled: isLoginValid, disabled: !isLoginValid }"
      :disabled="!isLoginValid"
      @click="handleSubmit"
    >
      로그인
    </button>
  </div> -->
  <div class="max-w-sm mx-auto mt-10">
    <h2 class="text-2xl font-bold mb-4">로그인</h2>
    <BaseInput v-model="login.email" type="email" placeholder="이메일" />
    <BaseInput v-model="login.pwd" type="password" placeholder="비밀번호" />
    <BaseButton :disabled="!isLoginValid" @click="handleSubmit"
      >로그인</BaseButton
    >
    <router-link
      to="/signUp"
      class="block px-4 py-2 bg-gray-500 text-white rounded hover:bg-blue-600"
      >회원가입</router-link
    >
    <router-link to="/ThemeSetting">세팅 버튼 화면</router-link>

    <div
      class="min-h-screen flex items-center justify-center bg-blue-500 text-white text-3xl font-bold"
    >
      Tailwind CSS 적용됨! 🎉
    </div>
  </div>
</template>

<script setup>
import axios from "axios";
import { reactive, computed } from "vue";
import BaseInput from "../base/BaseInput.vue";
import BaseButton from "../base/BaseButton.vue";
import { useRouter, RouterLink } from "vue-router";
const router = useRouter();

const login = reactive({
  email: "",
  pwd: "",
});

const isLoginValid = computed(() => {
  return login.email.includes("@") && login.pwd.length >= 4;
});

const handleSubmit = async () => {
  try {
    const res = await axios.get("http://222.117.237.119:8111/users/list");
    const users = res.data;

    const user = users.find(
      (u) => u.email === login.email && u.pwd === login.pwd
    );

    if (user) {
      alert(`${user.name}님 환영합니다!`);
      // 로그인 성공 처리: 로컬스토리지 저장, 페이지 이동 등
      router.push("/members");
    } else {
      alert("이메일 또는 비밀번호가 잘못되었습니다.");
    }
  } catch (err) {
    console.error(err);
    alert("서버 오류");
  }
};
</script>

<!-- <style scoped>
 .login {
  display: flex;
  flex-direction: column;

}
input {
  margin: 10px 0;
  padding: 8px;
}
.btn {
  padding: 8px 16px;
  margin: 10px 0;
  background-color: #3498db;
  color: white;
  border: none;
  cursor: pointer;
}
.btn:disabled {
  background-color: #aaa;
  cursor: not-allowed;
} 
</style> -->
