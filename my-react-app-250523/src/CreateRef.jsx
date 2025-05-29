import { useRef } from "react";

//실제 DOM을 제어하기 위해 사용되는 useRef()
const CreateRef = () => {
  const inputRef = useRef(null);

  const handelFous = () => {
    inputRef.current.disabledc = false;
    inputRef.current.focus();
  };

  return (
    <>
      {/* 실제 태그에 영향을 줌 */}
      <input disabled ref={inputRef} />
      <button onClick={handelFous}>활성화</button>
    </>
  );
};

export default CreateRef;
