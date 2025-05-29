<template>
  <div class="overflow-y-auto max-h-96">
    <CateItem
      v-for="cate in cates"
      :key="cate.categoryId"
      :cateItem="cate"
      @remove="onRemove"
    />
  </div>
</template>

<script setup>
import CateItem from "./CateItem.vue";

defineProps({ cates: Array });

// Category.vue (부모) 에게 전달
const emit = defineEmits(["remove"]);
const onRemove = (id) => emit("remove", id);
</script>
