<!-- components/BaseInput.vue -->
<template>
  <div class="mb-4">
    <input
      :type="type"
      :placeholder="placeholder"
      :value="modelValue"
      @input="$emit('update:modelValue', $event.target.value)"
      class="border border-gray-300 px-4 py-2 rounded w-full focus:ring-2 focus:ring-blue-400 focus:outline-none"
    />
  </div>
</template>

<script setup>
defineProps({
  modelValue: String,
  type: {
    type: String,
    default: "text",
  },
  placeholder: String,
});

// const emit = defineEmits(["update:modelValue"]);
</script>
