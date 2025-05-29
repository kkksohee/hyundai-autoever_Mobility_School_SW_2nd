import { defineStore } from "pinia";

export const useMemberStore = defineStore("userinfo", {
  state: () => ({
    user: {
      name: "",
      email: "",
      pwd: "",
    },
  }),
  actions: {
    setuser(newUser) {
      this.user = newUser;
    },
  },
  persist: true, // ✅ 자동으로 localStorage에 저장됨
});
