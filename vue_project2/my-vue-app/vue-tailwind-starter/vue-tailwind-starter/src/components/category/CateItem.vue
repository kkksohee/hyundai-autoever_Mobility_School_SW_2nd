<template>
  <div
    class="flex justify-between items-center px-4 py-2 border-b hover:bg-gray-100"
  >
    <div class="text-gray-700">{{ cateItem.categoryName }}</div>
    <button
      @click="$emit('remove', cateItem.categoryId)"
      class="text-red-500 hover:text-red-600"
    >
      ❌
    </button>
  </div>
</template>

<script setup>
defineProps({ cateItem: Object });
</script>

<!-- 1.
@click="$emit('remove', cateItem.categoryID)"
2.
@click="onRemove(cateItem.categoryID)"
const emit = defineEmits(["remove"]);
const onRemove = (id) => {
  emit("remove", id);
};

둘 다 같은 의미 -->
