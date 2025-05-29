// const prompt = require("prompt-sync")();
/*
const hnumber = prompt("주민등록 입력: ");
const greeting = document.getElementById("greeting"); //id선택자로 태그를 찾음 html에서

const newYear = new Date().getFullYear();
let hage = Number(hnumber[0]) * 10 + Number(hnumber[1]);

let gen = hnumber[7] == 1 || hnumber[7] == 3 ? "남" : "여";
hage += hnumber[7] == 1 || hnumber[7] == 2 ? 1900 : 2000;

greeting.innerHTML = `성별: ${gen}<br>나이: ${
  newYear - hage
}<br>생년월일: ${hage}년 ${hnumber[2]}${hnumber[3]}월 ${hnumber[4]}${
  hnumber[5]
}일`;
*/
// greeting.insertAdjacentHTML("beforeend", `성별: ${gen}<br>`);
// greeting.insertAdjacentHTML("beforeend", `나이: ${newYear - hage}<br>`);
// greeting.insertAdjacentHTML("beforeend", `생년월일: ${hage}년 ${hnumber[2]}${hnumber[3]}월 ${hnumber[4]}${hnumber[5]}일`);

// greeting.innerText = `성별: ${gen}\n나이: ${newYear-hage}\n생년월일: ${hage}년 ${hnumber[2]}${hnumber[3]}월 ${hnumber[4]}${hnumber[5]}일` ;
// 실습 예제
// 입력 받기
// 입력 받은 길이, - 체크 / 문자열 자르는 subString 사용
// const rrn = prompt("주민번호 입력:");
// const greeting = document.getElementById("greeting");

// const newYear = new Date().getFullYear();
// if (rrn.length !== 14 || !rrn.includes("-")) {
//   alert("다시 입력하세요.");
// } else {
//   let bithYear = Number(rrn[0]) * 10 + Number(rrn[1]);
//   let bithDay = parseInt(rrn.substring(2, 6));
//   let gender1 = parseInt(rrn.charAt(7));
//   // let gender2 = Number(rnn[7]);

//   bithYear += gender1 == 1 || gender1 == 2 ? 1900 : 2000;
//   greeting.innerHTML = `성별: ${gender1 == 1 ? "남" : "여"}<br>
//     나이: ${newYear - bithYear}<br>
//     생년월일: ${bithYear} ${bithDay}`;
// }

//실습문제 음료리스트
const prouctList = [
  {
    name: "레스비",
    price: 700,
  },
  {
    name: "포카리",
    price: 2000,
  },
  {
    name: "코카콜라",
    price: 1500,
  },
  {
    name: "환타",
    price: 1300,
  },
  {
    name: "토레타",
    price: 1800,
  },
];

let inputCoin = 2000;
let len = prouctList.length;
let outputList = [];
for (let i = 0; i < len; i++) {
  if (prouctList[i].price <= inputCoin) outputList.push(prouctList[i]);
}
console.log(outputList);

let outputList2 = prouctList.filter((product) => product.price <= inputCoin);
console.log(outputList2);

//실습 for in of
const iveMember = [
  { id: 1, name: "유진", skills: ["리더십", "보컬"] },
  { id: 2, name: "가을", skills: ["댄스", "랩"] },
  { id: 3, name: "레이", skills: ["랩", "일본어"] },
  { id: 4, name: "원영", skills: ["비주얼", "MC"] },
  { id: 5, name: "리즈", skills: ["보컬", "고음"] },
  { id: 6, name: "이서", skills: ["막내", "퍼포먼스"] },
];

for (let member in iveMember) {
  console.log(iveMember[member]);
}
for (let member of iveMember) {
  console.log(`이름:${member.name}`);
}
