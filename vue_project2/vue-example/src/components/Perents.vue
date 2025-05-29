<template>
  <div>자식에게 받은 메시지:{{ message }}</div>
  <Child @send-message="handleMessage" />
</template>

<script setup>
import { ref } from 'vue'

import Child from './Child.vue'

const message = ref('')

const handleMessage = (payload) => {
  message.value = payload
}
</script>
