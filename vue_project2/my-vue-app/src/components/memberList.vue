<template>
  <MemberItem
    v-for="memberitem in users"
    :key="memberitem.name"
    :memberitem_out="memberitem"
  />
</template>

<script setup lang="ts">
import axios from "axios";
import { ref, onMounted } from "vue";
import MemberItem from "./memberItem.vue";

const users = ref([]);
onMounted(async () => {
  const res = await axios.get("http://222.117.237.119:8111/users/list");
  users.value = res.data;
});

// const props = defineProps({
//   member: Array,
// });
</script>
