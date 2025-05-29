<template>
  <div class="login">
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
    <!-- <a href=""></a> -->
  </div>
</template>

<script setup>
import axios from "axios";
import { reactive, computed } from "vue";
import memberItem from "./memberItem.vue";

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
    } else {
      alert("이메일 또는 비밀번호가 잘못되었습니다.");
    }
  } catch (err) {
    console.error(err);
    alert("서버 오류");
  }
};
</script>

<style scoped>
.login {
  display: flex;
  flex-direction: column;
  /* gap: 10px; */
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
</style>
