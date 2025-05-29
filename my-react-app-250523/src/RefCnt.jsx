import { useRef, useEffect, useState } from "react";

const RefCnt = () => {
  const cntRef = useRef(0);
  let cntTest = 0;
  const [flag, setflag] = useState(false);
  const incrementCnt = () => {
    cntRef.current += 1;
    cntTest += 1;
    setflag(!flag);
  };
  console.log("Ref Cnt : ", cntRef.current);
  console.log("Let cnt :", cntTest);

  useEffect(() => {
    const interval = setInterval(incrementCnt, 1000);
    return () => clearInterval(interval); //클리어시점에 지움
  });

  return (
    <>
      <h3>카운트 연습</h3>
      <p>콘솔에서 값 확인</p>
      <button onClick={incrementCnt}>카운터증가</button>
    </>
  );
};

export default RefCnt;
