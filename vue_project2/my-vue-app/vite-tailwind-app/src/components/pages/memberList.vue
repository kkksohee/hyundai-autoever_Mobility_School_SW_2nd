<template>
  <memberItem
    v-for="memberitem in users"
    :key="memberitem.name"
    :memberitem_out="memberitem"
  />
  <p v-if="users.length === 0">불러오는 중 또는 회원이 없습니다.</p>
</template>

<script setup lang="ts">
import axios from "axios";
import { ref, onMounted } from "vue";
import memberItem from "./memberItem.vue";

const users = ref([]);
onMounted(async () => {
  const res = await axios.get("http://222.117.237.119:8111/users/list");

  users.value = res.data;
});

// const props = defineProps({
//   member: Array,
// });
</script>
