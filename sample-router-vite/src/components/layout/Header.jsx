import { useContext } from "react";
import { UserContext } from "../../store/UserStore";

const Header = () => {
  const { userId, password, userName } = useContext(UserContext);

  return (
    <>
      <header
        style={{
          background: "lightgray",
          padding: 16,
          fontSize: 24,
          width: "100%",
          height: "100%",
          position: "relative",
        }}
      >
        <div
          style={{
            display: "flex",
            flexDirection: "column",
            alignItems: "flex-end",
          }}
        >
          <p
            style={{
              fontSize: "16px",
              margin: "3px",
            }}
          >
            {" "}
            {`아이디: ${userId}`}
          </p>
          <p
            style={{
              fontSize: "16px",
              margin: "3px",
            }}
          >{`비밀번호: ${password}`}</p>
          <p
            style={{
              fontSize: "16px",
              margin: "3px",
            }}
          >{`이름: ${userName}`}</p>
        </div>
      </header>
    </>
  );
};
export default Header;
