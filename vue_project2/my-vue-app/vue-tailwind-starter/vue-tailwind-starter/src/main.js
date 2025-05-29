import { createApp } from "vue";
import App from "./App.vue";
import "./assets/tailwind.css";
// import "./assets/tailwind.css";

// 전역 상태 관리
import { createPinia } from "pinia";
import piniaPluginPersistedstate from "pinia-plugin-persistedstate";

// 라우터 설정
import router from "./router";

const app = createApp(App);

// Pinia 플러그인 연결
const pinia = createPinia();
pinia.use(piniaPluginPersistedstate);

// 전체 앱 설정
app.use(pinia); // ✅ 상태 관리
app.use(router); // ✅ 라우터 등록
app.mount("#app"); // ✅ 마운트

// createApp(App).mount('#app')
