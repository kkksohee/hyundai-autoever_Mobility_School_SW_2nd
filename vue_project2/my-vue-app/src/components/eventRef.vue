<template>
  <div class="container">
    <h2>회원 가입</h2>
    <input
      v-model="login.email"
      type="email"
      class="singup"
      placeholder="아이디 입력"
    />
    <p class="id-check">{{ login.check }}</p>
    <input
      v-model="login.pwd"
      type="password"
      class="singup"
      placeholder="비밀번호 입력"
    />
    <p class="id-check"></p>
    <input
      v-model="login.confirmpwd"
      type="password"
      class="singup"
      placeholder="비밀번호 확인 입력"
    />
    <p class="id-check"></p>
    <input
      v-model="login.name"
      type="text"
      class="singup"
      placeholder="이름 입력"
    />

    <!-- :disabled="!isLoginValid" HTML의 disabled속성에 js변수 isLoinValid를 넣겠다
     @click="handleSubmit" 버튼을 클릭했을 때 실행 함수  -->
    <button
      class="btn-member"
      :class="{ enabled: isLoginValid, disabled: !isLoginValid }"
      :disabled="!isLoginValid"
      @click="handleSubmit"
    >
      가입
    </button>
  </div>
</template>

<script setup>
import { reactive, computed } from "vue";
import axios from "axios";
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
  try {
    const payload = {
      email: login.email,
      pwd: login.pwd,
      name: login.name,
    };
    const res = await axios.post(
      "http://222.117.237.119:8111/auth/signup",
      payload
    );
    if (res.data) {
      alert("회원 가입 성공");
    } else {
      alert("회원 가입 실패");
    }
  } catch (err) {
    console.error(err);
    alert("가입 실패! 서버 오류 발생");
  }
};
</script>

<style scoped>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}
.container {
  width: 300px;
  height: 400px;
  box-shadow: 0 0 4px rgba(0, 0, 0, 0.5);
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 20px;
}
.singup {
  width: 200px;
  height: 30px;
  border-radius: 5px;
  border: 1px solid rgb(168 168 168);
}
.btn-member {
  background-color: #6c757d;
  color: aliceblue;
  font-weight: bold;
  width: 200px;
  height: 30px;
  border-radius: 5px;
  border: none;
  text-align: center;
  text-decoration: none;
  font-size: 13px;
  padding: 5px;
}
.btn-member.enabled {
  background-color: #e50d35;
  cursor: pointer;
}
</style>
