import "./App.css";
import Home from "./pages/Home";
import About from "./pages/About";
import Profile from "./pages/Profile";
import Layout from "./pages/Layout";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import NewsList from "./components/news/NewsList";
import News from "./pages/News";

import UserStore from "./store/UserStore";
import Login from "./pages/Login";
import SignUp from "./pages/SignUp";

function App() {
  return (
    <UserStore>
      {" "}
      {/* { 이 밑에가 전부 childrenL UserStore의 열림태그 닫힘태그 사이의 모든 것것 } */}
      {/* { 페이지 이동 영역 } */}
      <Router>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/signup" element={<SignUp />} />
          <Route element={<Layout />}>
            path에 대소문자 구분 x, _사용 x
            <Route path="/home" element={<Home />} />
            <Route path="/about" element={<About />} />
            :username: URL 파라미터로 넘길때 변수이름
            <Route path="/profiles/:username" element={<Profile />} />
          </Route>
        </Routes>
      </Router>
    </UserStore>
  );
}

// const App = () => {
//   return <News />;
// };

export default App;
