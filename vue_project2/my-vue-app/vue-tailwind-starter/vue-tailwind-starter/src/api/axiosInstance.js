import axios from "axios";

//axios.create : Axios인스턴스를 새로 생성하여 기본 URL을 설정
//이 인스턴스를 통해 모든 API요청을 일관된 방식으로 처리 가능
const axiosInstance = axios.create({
  baseURL: "http://222.117.237.119:8111",
  //withCredentials: true,
});
// interceptors.request.use : 요청 인터셉터, 모든 요청이 나가기전에 access totken을 헤더에 자동 추가가
axiosInstance.interceptors.request.use((config) => {
  const token = localStorage.getItem("token");
  if (token) {
    // Bearer로 token 검사 토큰가지고 주고받을려면 header에 토큰
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

//interceptors.response.use: 응답 인터셉터, API요청 실패시(401) 공통처리
//axios가 자동으로 판단해서 성공이면 첫 번째 함수, 실패면 두 번째 함수 실행
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
