<template>
  <ul>
    <li v-for="user in users" :key="user.id" @dbclick="removeUser(user.id)">
      {{ user.userName }}
    </li>
  </ul>
</template>

<script setup>
import { ref } from 'vue'

const users = ref([
  { id: 1, userName: '할 일 1' },
  { id: 2, userName: '할 일 2' },
])
const removeUser = (id) => {
  users.value = users.value.filter((user) => user.id !== id)
}
</script>
