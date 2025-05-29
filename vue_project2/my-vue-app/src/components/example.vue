<template>
  <div class="form-container">
    <h2>사용자 정보 입력</h2>

    <div class="form-group">
      <label>이름</label>
      <input v-model="form.name" type="text" />
    </div>

    <div class="form-group">
      <label>나이</label>
      <input v-model.number="form.age" type="number" />
    </div>

    <p>
      👉 현재 상태: <strong>{{ isAdult ? "성인" : "미성년자" }}</strong>
    </p>

    <button @click="handleSubmit">제출</button>
  </div>
</template>

<script setup>
import { ref, reactive, computed, watch, onMounted } from "vue";
const member = reactive({
  name: "",
  age: 0,
});

// 불필요한 함수 호출 방지(계산이 필요할 때만 함수가 필요하니까 computed 사용)
// isAdult:이전에 성인인지 아닌지 판별한 값을 저장해둠
// 계산이 일어날 조건은 member.age>19일때만 뷰는 자동으로
// ()=> member.age >19 -> 이 자체가 함수 등록 실행은 내부 값이 바뀌었을 때 computed가 실행함=> 캐싱되있는 값 넘겨줌
// 랜더링이 무수히 많이 일어나니까 필요함.<- 뷰나 리액트 화면을 빨리주는 특징
// 여기서 랜더링을 해주는게 reactiv 하나 그래도 랜더링은 무수히 많이 일어날 수 있음
//선생님: 불필요한 함수의 호출 방지, 리랜더링 시 함수 호출이 일어나지 않는 경우는 이전값 유지
const isAdult = computed(() => member.age > 19);

//watch 리랜더링 이후 동작 명시
// 리액트:useEffect  변화된 상태값 넣어주는 부분 없음
//선생님: 상태 변경이 일어나면, 화면 리랜더링 일어나고, 이후 동작(서버갔다옴)을 작성
watch(
  () => member.age,
  (newAge, oldAge) => {
    console.log(`나이 변경: ${oldAge}-> ${newAge}`);
  }
);

//onMounted해당 컴포넌트가 최초 보이는 시점
//선생님: 화면이 처음그려질 때 동작작
onMounted(() => {
  console.log("해당 컴포넌트가 마운트됨됨~~~");
});
</script>

<style scoped>
.form-container {
  width: 360px;
  margin: 40px auto;
  padding: 24px;
  border: 1px solid #ccc;
  border-radius: 8px;
  background-color: #f9f9f9;
  font-family: sans-serif;
}

h2 {
  font-size: 20px;
  margin-bottom: 16px;
}

.form-group {
  margin-bottom: 16px;
}

label {
  display: block;
  margin-bottom: 4px;
  font-weight: bold;
}

input {
  width: 100%;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
  font-size: 14px;
}

button {
  padding: 8px 16px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}
</style>
