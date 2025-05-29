<template>
  <div class="w-96 bg-white rounded-xl shadow mb-2 p-2">
    <h2 class="p-2 text-lg font-bold text">{{ memberitem_out.name }}</h2>
    <p class="p-1">{{ memberitem_out.email }}</p>
    <p class="p-1">{{ memberitem_out.pwd }}</p>
  </div>
</template>

<script setup>
const props = defineProps({
  memberitem_out: Object,
});

// function regDataVal(data){
//   const data =`${memberitem_out.regData()}`
// }
</script>
