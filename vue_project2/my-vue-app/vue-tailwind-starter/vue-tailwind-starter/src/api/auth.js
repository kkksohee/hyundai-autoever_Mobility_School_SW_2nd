import axios from "./axiosInstance";

// 외부에 사용가능하도록 내보냄
export const useAuthApi = () => {
  const signup = async (email, pwd, name) => {
    console.log(email, pwd, name);
    return await axios.post("/auth/signup", { email, pwd, name });
  };
  const login = async (email, pw) => {
    return await axios.post("/auth/login", { email, pw });
  };
  const exists = async (email) => {
    return await axios.post(`/auth/exists/${email}`);
  };
  return { login, signup, exists };
};
