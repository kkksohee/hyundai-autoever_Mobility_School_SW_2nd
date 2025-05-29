import { Link } from "react-router-dom";

const Home = () => {
  const role = "frontend";

  return (
    <div>
      <h1>여기가 홈 입니다.</h1>
      <p>가장 먼저 보여지는 페이지 입니다.</p>
      <Link to="/about">소개페이지로 이동</Link>
      <br />
      {/* <Link to ="/profiles/frontend">Frontend 프로필로 이동</Link> */}
      <Link to={`/profiles/${role}`}>Frontend 프로필로 이동</Link>
      <br />
    </div>
  );
};
export default Home;
