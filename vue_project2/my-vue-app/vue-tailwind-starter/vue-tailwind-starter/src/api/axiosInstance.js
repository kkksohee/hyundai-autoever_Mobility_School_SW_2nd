import axios from "axios";

const axiosInstance = axios.create({
  baseURL: "http://222.117.237.119:8111",
  //withCredentials: true,
});

axiosInstance.interceptors.request.use((config) => {
  const token = localStorage.getItem("token");
  if (token) {
    // Bearer로 token 검사 토큰가지고 주고받을려면 header에 토큰
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

axiosInstance.interceptors.response.use(
  (response) => response,
  (error) => {
    // 401: 에러 코드
    if (error.response?.status === 401) {
      alert("로그인이 필요합니다.");
      router.push("/login"); // SPA 방식으로 이동
    }
    return Promise.reject(error);
  }
);

export default axiosInstance;
