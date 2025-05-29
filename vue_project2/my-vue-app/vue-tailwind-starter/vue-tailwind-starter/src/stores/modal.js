import { defineStore } from "pinia";

export const useModalStore = defineStore("modal", {
  state: () => ({
    isOpen: false,
    title: "",
    message: "",
    onConfirm: null,
    hasCancel: false,
  }),
  actions: {
    open({ title, message, onConfirm }) {
      this.title = title;
      this.message = message;
      this.onConfirm = onConfirm;
      this.isOpen = true;
    },
    close() {
      this.isOpen = false;
      this.onConfirm = null;
    },
    confirm() {
      //onConfirm이라는 게 실제 함수인지 확인
      if (typeof this.onConfirm === "function") {
        this.onConfirm(); // ✅ 부모에서 전달한 콜백 실행
      }
      this.close(); // ✅ 모달 닫기
    },
  },
});
