//axiosInstance를 axios란 이름으로 가져옴
//이걸로 API요청(GET, POST 등)을 함
//즉, 토큰 자동추가 + 에러 공통 처리된 axios를 사용하는 것
import axios from "./axiosInstance";

export const useBoardApi = () => {
  const cateList = async () => {
    return await axios.get("/api/category/list");
  };
  const cateInsert = async (email, categoryName) => {
    return await axios.post("/api/category/new", { email, categoryName });
  };
  const cateDelete = async (categoryId) => {
    return await axios.delete(`/api/category/delete/${categoryId}`);
  };
  const boardList = async () => {
    return await axios.get("/api/board/list");
  };
  const boardWrite = async (email, title, content, categoryId, img) => {
    return await axios.post("/api/board/new", {
      title,
      content,
      categoryId,
      email,
      img,
    });
  };
  const boardDetail = async (id) => {
    return await axios.get(`/api/board/detail/${id}`);
  };
  const boardDelete = async (id) => {
    return await axios.delete(`/api/board/delete/${id}`);
  };
  const commentList = async (id) => {
    return await axios.get(`/api/comment/list/${id}`);
  };
  const commentWrite = async (email, boardId, content) => {
    return await axios.post("/api/comment/new/", { email, boardId, content });
  };
  return {
    cateList,
    cateInsert,
    cateDelete,
    boardList,
    boardWrite,
    boardDetail,
    boardDelete,
    commentList,
    commentWrite,
  };
};
