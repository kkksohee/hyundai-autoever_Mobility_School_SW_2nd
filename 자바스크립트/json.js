let memberInfo = [
  {
    name: "이영지",
    age: 21,
    job: "래퍼",
    addr: "서울시 강남구 청담동",
  },
  {
    name: "미미",
    age: 24,
    job: "오마이걸",
    addr: "서울시 강남구 역삼동",
  },
  {
    name: "안유진",
    age: 20,
    job: "아이브",
    addr: "서울시 강북구",
  },
];

const json = JSON.stringify(memberInfo);
console.log(json);

const objectJson = JSON.parse(json);
console.log(objectJson);

// HTML에 출력할 부모 요소 선택
const container = document.getElementById("container");

// map을 이용해 JSON 객체 데이터를 HTML 형식으로 변환
const htmlContent = jsonObject
  .map(
    (person) => `
    <div class="person">
        <h2>${person.name}</h2>
        <p>나이: ${person.age}</p>
        <p>학생 여부: ${person.isStudent ? "예" : "아니오"}</p>
        <p>과목: ${person.courses.join(", ")}</p>
        <p>주소: ${person.address.city}, 우편번호: ${person.address.zipcode}</p>
    </div>
`
  )
  .join("");
