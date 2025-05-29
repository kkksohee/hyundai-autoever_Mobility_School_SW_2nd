<template>
  <div>
    <button @click="() => send('전체')">전체</button>
    <button @click="() => send('정치')">정치</button>
    <button @click="() => send('경제')">경제</button>
    <button @click="() => send('사회')">사회</button>
    <button @click="() => send('문화')">문화</button>
    <button @click="() => send('과학')">과학</button>
  </div>

  <div class="newList">
    <button v-for="val in categories" :key="val" @click="() => send(val)">
      {{ val }}
    </button>
  </div>
</template>

<script setup>
//버튼 눌렀을 때 이벤트 타입과 내용을 부모에게 날려줌
const emit = defineEmits(["send-news"]);
const send = (cat) => {
  emit("send-news", cat);
};

const categories = ["전체", "정치", "경제", "사회", "문화", "과학"];
</script>

<!-- NewsCategory.vue(자식)
버튼 클릭시 -> send("경제") 실행됨
send 함수 내부에서 -> emit("send-news", 경제)

=>

News.vue (부모)
<NewsCategory @send-news="selectCategory" />
→ "경제"라는 값이 selectCategory 함수의 인자로 전달됨 -->
