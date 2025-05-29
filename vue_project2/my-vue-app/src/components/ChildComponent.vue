<template>
  <div>
    <h3>자식 컴포넌트</h3>
    <button @click="send">부모컴포넌트에 메시지 보내기</button>
  </div>
</template>

<script setup>
// 버튼 눌러졌을 때 이벤트 타입과, 내용을 날려줌 부모에게
// defineEmits(['여기안에 이벤트 타입 작성'])
const emit = defineEmits(["send-message"]);
const send = () => {
  emit("send-message", "안녕하세요! 자식입니다.");
};
</script>

<style scoped></style>
