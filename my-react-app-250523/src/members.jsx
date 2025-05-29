// const Members = (props) => {
//   const { name, age, addr, isAdult } = props;
//   return (
//     <>
//       {/* <h3>이름은: {props.name}</h3>
//       <p>나이: {props.age}</p>
//       <p>주소: {props.addr}</p>
//       <p>성인 여부: {props.isAdult ? "성인" : "미성년자"}</p> */}

//       {/* 구조 분해 또는 비구조화 할당 */}
//       <h3>이름은: {name}</h3>
//       <p>나이: {age}</p>
//       <p>주소: {addr}</p>
//       <p>성인 여부: {isAdult ? "성인" : "미성년자"}</p>
//     </>
//   );
// };

//디폴드 값도 줄 수 있음음
const Members = ({
  name = "없음",
  age = "0",
  addr = "부산",
  isAdult = true,
}) => {
  return (
    <>
      <h3>이름은: {name}</h3>
      <p>나이: {age}</p>
      <p>주소: {addr}</p>
      <p>성인 여부: {isAdult ? "성인" : "미성년자"}</p>
    </>
  );
};
export default Members;
