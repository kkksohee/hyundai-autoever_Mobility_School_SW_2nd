<template>
  <input class="p-3 m-2 bg-slate-200 border-gray-500" type="text" placeholder="이름 입력" />
  <input class="p-3 m-2 bg-slate-200 border-gray-500" type="text" placeholder="나이 입력" />
</template>

<script setup>
import { reactive, computed, watch, onMounted } from 'vue'

const form = reactive({
  name: '',
  age: 0,
})

const isAdult = computed(() => form.age >= 20)

watch(
  () => form.age,
  (newAge, oldAge) => {
    console.log('나이 변경')
  },
)

onMounted(() => {
  console.log('컴포넌트 마운트')
})

const handleSubmit = () => {
  alert(`${form.name}님은 ${isAdult.value ? '성인' : '미성년자'}입니다.`)
}
</script>
