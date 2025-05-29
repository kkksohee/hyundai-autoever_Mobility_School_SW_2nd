import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";
import path from "path"; // ⬅️ Node의 path 모듈

export default defineConfig({
  plugins: [vue()],
  resolve: {
    alias: {
      "@": path.resolve(__dirname, "./src"), // ⬅️ @ = src 경로
    },
  },
});
