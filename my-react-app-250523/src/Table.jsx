// 1. 맵돌리기
// 2. 맵돌리면서 생명주기 관리 하면서
// useState :상태관리 useEffect :생명주기 => hooks문법
import { useState, useEffect } from "react";

//서버로 부터 이 객체가 내려올 수 있겠죠?
const fetchData = [
  { id: 100, name: "카즈하", age: 20 },
  { id: 200, name: "유나", age: 21 },
  { id: 300, name: "안유진", age: 22 },
  { id: 400, name: "해린", age: 24 },
  { id: 500, name: "하니", age: 17 },
];
const TableMap = () => {
  const [members, setmembers] = useState([]);
  useEffect(() => {
    console.log("마운트 이 후 useEffect 호출");
    //원래 비동기 통신(서버에서 데이터 가져옴)
    // 통신 후 await로 대기, 데이터가 수신 되면 상태 변경(명시적으로 해야함)
    setmembers(fetchData); //<-데이터가 수신됨, 랜더링 일어남
  }, []); //의존성 배열, 비어있으면 마운트 시절에 호출 됨/뷰에서는 onMounted

  const memberSelete = (name) => {
    console.log(name);
  };
  return (
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>이름</th>
          <th>나이</th>
        </tr>
      </thead>
      <tbody>
        {/* 이제부터 가변 구간(표현식을 넣어야함)/ 뷰에서는 v-for
      처음에 불려졌을 때 useEffect가 먼저할까 화면이 먼저그려질까?
      ㄴㄴ useEffect는 나타남 다음 그니까 mount된 다음에 
      처음에는 members에 없겠지 서버에서 못받아왔으니까
      그니까 &&를 써서 데이터가 있으면 그려주는걸로  */}

        {/* 여러번 넣을 때 대괄호 아니고 소괄호() 넣어야 함 */}
        {/* map:내부에서 순회해서 반환되는 배열을 받는 것 */}
        {members &&
          members.map((member) => (
            <tr key={member.id} onClick={() => memberSelete(member.name)}>
              <td>{member.id}</td>
              <td>{member.name}</td>
              <td>{member.age}</td>
            </tr>
          ))}
      </tbody>
    </table>
  );
};

export default TableMap;
