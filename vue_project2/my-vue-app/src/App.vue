<script setup>
import dataBinding from "./components/databinding.vue";
import conditionrander from "./components/conditionrander.vue";
import reterble from "./components/reterble.vue";

import classbinding from "./components/classbinding.vue";
import reactiveComponent from "./components/reactiveComponent.vue";
import computed from "./components/computed.vue";
import watch from "./components/watch.vue";

import study_compositionAPI from "./components/study_compositionAPI.vue";
import example from "./components/example.vue";
import soheetest from "./components/soheetest.vue";

import cardView from "./components/cardView.vue";
import exampleProps from "./components/exampleProps.vue";
// import { reactive } from "vue";
// const member = reactive({
//   name: "",
//   job: "",
//   age: 0,
// });
import userCard from "./pages/userCard.vue";

import ChildComponent from "./components/ChildComponent.vue";
import { ref } from "vue";
const message = ref("");

// 자식이 넘겨준 값이 paylod에 넘겨짐
const handleMessage = (payload) => {
  message.value = payload;
};

//실습
import News from "./pages/News.vue";

//5/16
import eventRef from "./components/eventRef.vue"; //회원가입
import userList from "./components/userList.vue"; //로그인인

import eventHandel from "./components/eventHandel.vue";
import selectBox from "./components/selectBox.vue";
import arrayLender from "./components/arrayLender.vue";

import News_test from "./test_sohee/News_test.vue";

//5/19
import memberList from "./components/memberList.vue";
</script>

<template>
  <h5>앱.뷰 영역입니다.</h5>
  <!-- <input v-model="member.name" placeholder="이름 입력" />
  <br />
  <input v-model="member.job" placeholder="직업 입력" />
  <br />
  <input v-model.number="member.age" placeholder="나이 입력" /> -->

  <!-- <dataBinding /> -->
  <!-- <conditionrander /> -->
  <!-- <reterble /> -->
  <!-- <classbinding /> -->

  <!-- <reactive />  -->
  <!-- <computed /> -->
  <!-- <watch /> -->
  <!-- <study_compositionAPI /> -->
  <!-- <example /> -->

  <!-- <soheetest /> -->
  <!-- <cardView :user="member" /> -->
  <!-- <exampleProps :userEX1="member" :userEx2="member" /> -->
  <!-- <userCard /> -->
  <!-- <div>
    <h2>부모 컴포넌트</h2>
    <p>자식에게 받은 메시지: {{ message }}</p>
    <ChildComponent @send-message="handleMessage" />
  </div> -->

  <!-- 실습 -->
  <!-- <News /> -->
  <userList />

  <!-- 5/16 -->
  <!-- <eventRef /> -->

  <!-- <eventHandel /> -->
  <!-- <selectBox /> -->
  <!-- <arrayLender /> -->

  <!-- 5/19 -->
  <!-- <memberList /> -->
</template>

<style scoped>
h1 {
  font-size: 24px;
  color: red;
}
input {
  padding: 8px;
  font-size: 18px;
  margin-top: 10px;
}
</style>
