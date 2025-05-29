<template>
  <div
    class="flex flex-col items-center justify-center min-h-screen bg-white px-4"
  >
    <h1 class="text-2xl font-semibold mb-8">로그인</h1>

    <div class="w-full max-w-md mx-auto space-y-4">
      <BaseInput v-model="email" type="email" placeholder="이메일" />
      <BaseInput v-model="pw" type="password" placeholder="비밀번호" />
      <BaseButton
        type="primary"
        class="mx-auto block w-full"
        @click="onLogin"
        :disabled="!canLogin"
      >
        로그인
      </BaseButton>

      <div class="text-sm text-center mt-4">
        계정이 없으신가요?
        <router-link to="/signup" class="text-blue-500 hover:underline">
          회원가입
        </router-link>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, computed } from "vue";
import axios from "axios";

import { useRouter } from "vue-router";
const router = useRouter();

import BaseInput from "../components/base/BaseInput.vue";
import BaseButton from "../components/base/BaseButton.vue";

import { useModalStore } from "@/stores/modal";
const modal = useModalStore();

const email = ref("");
const pw = ref("");

// 로그인 조건: 이메일과 비밀번호가 모두 입력되었을 때
const canLogin = computed(() => email.value.length > 0 && pw.value.length > 0);

const loginAction = () => {
  localStorage.setItem("isLogin", "TRUE");
  localStorage.setItem("email", email.value);
  router.push("/Home");
};

async function onLogin() {
  if (!canLogin.value) return;

  try {
    //const user = await login(id.value, pw.value);
    const payload = {
      email: email.value,
      pwd: pw.value,
    };
    const res = await axios.post(
      "http://222.117.237.119:8111/auth/login",
      payload
    );
    if (res.data) {
      modal.open({
        title: "로그인 성공",
        message: `${email.value} 로 로그인에 성공 했습니다`,
        onConfirm: loginAction,
      });
    } else {
      modal.open({
        title: "로그인 실패",
        message: `이메일 또는 비밀번호를 확인 하세요`,
      });
    }
  } catch (err) {
    modal.open({
      title: "로그인 실패",
      message: `서버 통신 실패 : 에러 코드를 확인 하세요`,
    });
  }
}
</script>

<style scoped>
.input-box {
  @apply w-full px-4 py-3 border border-gray-400 rounded-full;
}
</style>
