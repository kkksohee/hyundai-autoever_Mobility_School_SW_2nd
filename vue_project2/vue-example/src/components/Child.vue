<template>
  <button @click="send">부모에게 메시지 보내기</button>
</template>

<script setup>
//이벤트 정의
const emit = defineEmits(['send-message'])

const send = () => {
  emit('send-message', '안녕 난 자식')
}
</script>
