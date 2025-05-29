<template>
  <div class="newList">
    <button class="bt" @click="() => send('전체')">전체</button>
    <button class="bt" @click="() => send('정치')">정치</button>
    <button class="bt" @click="() => send('경제')">경제</button>
    <button class="bt" @click="() => send('사회')">사회</button>
    <button class="bt" @click="() => send('문화')">문화</button>
    <button class="bt" @click="() => send('과학')">과학</button>
  </div>

  <div class="newList">
    <button v-for="val in categories" :key="val" @click="() => send(val)">
      {{ val }}
    </button>
  </div>
</template>

<script setup>
const emit = defineEmits(["send-news1"]);

const send = (val) => {
  //부모에게 데이터 전달
  emit("send-news1", val);
};

const categories = ["전체", "정치", "경제", "사회", "문화", "과학"];
</script>
