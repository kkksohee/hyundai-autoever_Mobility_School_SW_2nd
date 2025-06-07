import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
import App from "./App.jsx";

//리액트는 컴포는트(<App />)를 브라우저에 직접 출력할 수 없음
//브라우저 화면에 그려주려면 HTML의 실제 DOM과 연결하는 작업 필요
createRoot(document.getElementById("root")).render(<App />);
