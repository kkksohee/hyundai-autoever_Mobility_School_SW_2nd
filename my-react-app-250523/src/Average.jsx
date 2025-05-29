import { useState, useMemo } from "react";

const getAverage = (numbers) => {
  console.log("평균값 계산중");
  if (numbers.length === 0) return 0;
  const sum = numbers.reduce((a, b) => a + b);
  return sum / numbers.length;
};

const Average = () => {
  const [list, setList] = useState([]);
  const [number, setNumber] = useState("");
  const onChange = (e) => {
    setNumber(e.target.value);
  };

  // input창에서 받은 숫자는 문자열 이기 때문에 정수로 바꿈
  // 리액트는 배열 내부를 건들면 안됨 새로운 주소여야지만 랜더링 해줌
  const onInsert = (e) => {
    const nextList = list.concat(parseInt(number));
    setList(nextList);
    setNumber("");
  };

  //list가 바뀔때 getAverage 가 바뀜뀜
  const avg = useMemo(() => getAverage(list), [list]);
  return (
    <>
      <input value={number} onChange={onChange} />
      <button onclick={onInsert}>등록</button>

      <ul>
        {list.map((value, index) => (
          <li key={index}>{value}</li>
        ))}
      </ul>
      {/* 즉시 호출이니까 () 필요 */}
      <p>평균값: {avg}</p>
    </>
  );
};

export default Average;
