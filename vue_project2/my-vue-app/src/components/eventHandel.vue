<!-- 이벤트 핸들링 예제 -->
<template>
  <div>
    <!-- 이벤트 등록만 하고 버튼이 눌러지면 랜더링 일어나면서 바뀜 -->
    <!-- <template>에서는 값을 직접 접근, <script>에서는 값.value로 접근 -->
    <!-- <button @click="onClickEnter">입장</button> -->
    <button @click="() => (message = '안녕하세요')">입장</button>
    <button @click="onClickLeave">퇴장</button>
    <!-- style 값 : value를 넣어야 되는데 이렇게 넣어도 됨 -->
    <h1 :style="{ color }">{{ message }}</h1>
    <!-- () => select() 이렇게 하면 버튼이 눌렸을 때 실행(등록록)
select() 이렇게 하면 버튼이 등록됐을 때 즉시 실행 -->
    <button @click="() => setColor('red')">빨간색</button>
    <button @click="() => setColor('green')">초록색</button>
    <button @click="() => setColor('blue')">파란색</button>
  </div>
</template>

<script setup>
import { ref } from "vue";

const message = ref("");
const color = ref("black"); //디폴드 값

const onClickEnter = () => {
  message.value = "안녕하세요";
};

const onClickLeave = () => {
  message.value = "안녕히 가세요";
};
//매개변수 이름 같으면 안됨됨
const setColor = (val) => {
  color.value = val;
};
</script>
