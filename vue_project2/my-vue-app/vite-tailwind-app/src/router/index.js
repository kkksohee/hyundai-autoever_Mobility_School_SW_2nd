import { createRouter, createWebHistory } from "vue-router";
import Home from "../components/pages/Home.vue";
import about from "../components/pages/about.vue";
import Profile from "../components/pages/Profile.vue";
import login from "../components/pages/login.vue";
import signUp from "../components/pages/signUp.vue";
import memberList from "../components/pages/memberList.vue";
import ThemeSetting from "../components/pages/ThemeSetting.vue";

import Layout from "../Layout.vue";
// import { Children } from "react";

// 라우트의 목록을 정의
// 각 라우트는 path(주소)와 component(보여줄 컴포넌트)로 구성
// const routes = [
//   // /만 적는 이유: 웹사이트의 첫화면(root 경로)
//   { path: "/", component: Home },
//   { path: "/about", component: about },

//   { path: "/", component: logrin },
//   { path: "/signUp", component: SignUp },

//   {
//     path: "/home",
//     component: Layout,
//     Children: [
//       {
//         path: "/aobut",
//         component: about,
//       },
//       { path: "/about", component: about },
//       //   { path: "/Profile:넘겨줄 키값(변수처럼씀)", component: Profile },
//       { path: "/Profile:username", componenst: Profile },
//     ],
//   },
// ];

const routes = [
  { path: "/", component: login },
  { path: "/signUp", component: signUp },

  {
    path: "/members",
    component: Layout,
    children: [{ path: "", name: "MemberList", component: memberList }],
  },
  { path: "/ThemeSetting", component: ThemeSetting },
];

// 라우터 객체 생성
// history모드는 주소에 #없이 깔끔하게 만들어줌
const router = createRouter({
  // 히스토리 스택(네비게이터가 움직이는 개념이 스택과 같음)
  history: createWebHistory(),
  routes,
});
// 만들어진 라우터를 외부에서 사용할 수 있도록 내보냄
export default router;
