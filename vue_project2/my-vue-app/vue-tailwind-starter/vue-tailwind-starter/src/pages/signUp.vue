<template>
  <div
    class="flex flex-col items-center justify-center min-h-screen bg-white px-4"
  >
    <h2 class="text-2xl font-semibold mb-8">회원 가입</h2>
    <div class="w-full max-w-md mx-auto space-y-4">
      <BaseInput v-model="login.email" type="email" placeholder="아이디 입력" />
      <p class="id-check">{{ login.check }}</p>
      <BaseInput
        v-model="login.pwd"
        type="password"
        placeholder="비밀번호 입력"
      />
      <p class="id-check"></p>
      <BaseInput
        v-model="login.confirmpwd"
        type="password"
        placeholder="비밀번호 확인 입력"
      />
      <p class="id-check"></p>
      <BaseInput v-model="login.name" type="text" placeholder="이름 입력" />

      <!-- :disabled="!isLoginValid" HTML의 disabled속성에 js변수 isLoinValid를 넣겠다
     @click="handleSubmit" 버튼을 클릭했을 때 실행 함수  -->
      <BaseButton
        type="primary"
        class="mx-auto block w-full"
        @click="handleSubmit"
        :disabled="!isLoginValid"
      >
        로그인
      </BaseButton>
    </div>
  </div>
</template>

<script setup>
import { reactive, computed } from "vue";
import axios from "axios";
import BaseButton from "../components/base/BaseButton.vue";
import BaseInput from "../components/base/BaseInput.vue";
import { useRouter } from "vue-router";
const router = useRouter();

import { useAuthApi } from "../api/auth";
const { signup, exists } = useAuthApi();

const login = reactive({
  email: "",
  pwd: "",
  confirmpwd: "",
  name: "",
  check: "",
});

//필드 확인 속성
const isLoginValid = computed(() => {
  return (
    login.email &&
    login.pwd &&
    login.confirmpwd &&
    login.name &&
    login.pwd === login.confirmpwd
  );
});

//회원가입 정규표현식
const regexID = /^[A-Za-z0-9_]{8,20}$/;
const regexPW =
  /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]).{8,}$/;
const RegexEmail = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
const RegexPhNum = /^010-\d{4}-\d{4}$/;

function validateInput(input, regex, targetKey) {
  //입력값 참
  if (regex.text(inputValue));
}
//유효성 검사
function isAllValid() {
  const emailVaild = validateInput(login.email, RegexEmail, login.check);
  //   const pwVaild = validateInput(login.pwd, regexPW, pwCheck);

  //   const nameVaild = validateInput(login.name, RegexPhNum, phNumCheck);

  return emailVaild; // && pwVaild && emailVaild && phNumVaild;
}

//가입클릭시 서버 요청
const handleSubmit = async () => {
  //swagger -> auth-controller -< POST /auth/signup 에서
  const res = await signup(login.email, login.pwd, login.name);
  console.log(res);
  if (res.data) {
    router.push("/");
  } else {
    alert("회원 가입 실패");
  }
  // try {
  //   const payload = {
  //     email: login.email,
  //     pwd: login.pwd,
  //     name: login.name,
  //   };
  //   const res = await axios.post(
  //     "http://222.117.237.119:8111/auth/signup",
  //     payload
  //   );
  //   if (res.data) {
  //     alert("회원 가입 성공");
  //     //회원 정보 Pinia전역상태관리 등록
  //     MemStore.setuser(res.data);
  //     router.push("/");
  //   } else {
  //     alert("회원 가입 실패");
  //   }
  // } catch (err) {
  //   console.error(err);
  //   alert("가입 실패! 서버 오류 발생");
  // }
};
</script>
