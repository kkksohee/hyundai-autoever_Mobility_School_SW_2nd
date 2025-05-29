//연산자 :수학적인 계산을 위해 사용되거나 , 참과 거짓을 판별할 때 사용
//산술연산자 : + - * / % **
//대입연산지 : = += -= /= %=
//증감연산자 : ++ --
//비교연산자 :
//논리연산자
//삼항연산자 : 참과 거짓을 구분하는 간단한 조건식, 연산자 취급
//비트연산자
//전개연산자

let a = 10;
let b =4;
console.log(a + b);
console.log(a -b);
console.log(a*b);
console.log(a/b); //나눗셈
console.log(parseInt(a/b)); //몫을 구하기 위해서 정수로 형변환
console.log(Math.floor(a/b)); //소수점 이하를 날림 
console.log(a%b);
console.log(a **3 );

console.log(++a);  //11 //선증가, 후대입입
console.log(a); //11

console.log(a++); //11, 선대입 후 증가
console.log(a); //12

let c =10;
console.log(c += 2); // c=c+2
console.log(c-=2); //10
console.log(c*= 2); //20
console.log(c /=2); //10
console.log(c%=2); //0

// 비교연산자 ==(값 판별), ===(값,타입 판별)
console.log(100 !=="100");

const age =20;
console.log(`당신은 ${age>19 ? "성인": "미성년자"} 입니다.`);



//형변환:정해진 타입을 다른 타입으로 변경하는 것
// 묵시적, 명시적 형변환
// 묵시적: 알아서 바꿔줌 , 유리하다고 생각 하는 것으로 
const rst = 100+ 3.14;
console.log(rst);
console.log(10+10+"10");
//명시적
console.log(100 +Number("3.14"));

//윤년 계산하기 
// 규칙1 년도가 4로 나누어 떨어짐
// 규칙2 100으로 나누어 떨어지면 윤년 x
// 규칙3 400으로 나누어 지면 윤년
let year=2025;

const prompt = require("prompt-sync")();

// 정수로 변환 parseInt
let num = parseInt(prompt("정수 입력:"));
console.log(num);
if(year%4 === 0 || year%100 !== 0 && year %400 ===0){
    console.log(`${year}은 윤년입니다.`);
}
else {
    console.log(`${year}은 윤년이 아닙니다.`);
}

//주민등록 번호 입력받음: 010222-3144414
//성별
//나이
//생년월일 출력하기
// 문자열의 인덱싱과 슬라이싱 사용 : slice(시작인덱스 종료 인덱스)
//new Date().getfullTear() : 올해가 몇년인지
//7번인덱스가 1과 2면 19xx년, 3,4면 2xxx년년, 1,3이면 남, 2,4면 여여

//연습문제 1
/*
const prompt2 = require("prompt-sync")();

let hnumber = (prompt("주민등록 입력:"));

const newYear=new Date().getFullYear();
let hage = (Number(hnumber[0])*10) +(Number(hnumber[1]));
if(hnumber[7] == 1 || hnumber[7]==3) {
    console.log("성별: 남");
}
else if(hnumber[7] == 2 || hnumber[7]==4) {
    console.log("성별: 여");
}
if(hnumber[7] == 1 || hnumber[7]==2) {
    hage += 1900;
    // hage = newYear-(hage+1900);
}
else if(hnumber[7] == 3 || hnumber[7]==4) {
    hage += 2000;
} 
console.log(`나이: ${newYear-hage}`);
console.log(`생년월일: ${hage}년 ${hnumber[2]}${hnumber[3]}월 ${hnumber[4]}${hnumber[5]}일`)
*/
//연습하기 2
/*
const hnumber = prompt("주민등록 입력: ");
const greeting = document.getElementById("greeting"); //id선택자로 태그를 찾음 html에서 

const newYear=new Date().getFullYear();
let hage = (Number(hnumber[0])*10) +(Number(hnumber[1]));

let gen = (hnumber[7] == 1 || hnumber[7] == 3) ? "남" : "여";
hage += (hnumber[7] == 1 || hnumber[7] == 2) ? 1900 : 2000;

greeting.innerHTML = `성별: ${gen}<br>나이: ${newYear - hage}<br>생년월일: ${hage}년 ${hnumber[2]}${hnumber[3]}월 ${hnumber[4]}${hnumber[5]}일`;

// greeting.insertAdjacentHTML("beforeend", `성별: ${gen}<br>`);
// greeting.insertAdjacentHTML("beforeend", `나이: ${newYear - hage}<br>`);
// greeting.insertAdjacentHTML("beforeend", `생년월일: ${hage}년 ${hnumber[2]}${hnumber[3]}월 ${hnumber[4]}${hnumber[5]}일`);

// greeting.innerText = `성별: ${gen}\n나이: ${newYear-hage}\n생년월일: ${hage}년 ${hnumber[2]}${hnumber[3]}월 ${hnumber[4]}${hnumber[5]}일` ;
*/

//강사님 
const prompt5 = require("prompt-sync")();
const currYear = new Date().getUTCFullYear();
const jumin = prompt("주민버호 입력: ");

const year5 = parseInt(jumin.slice(0,2));
const month5= parseInt(jumin.slice(2,4));
const day5= parseInt(jumin.slice(4,6));
const val= parseInt(jumin[7]);

const birthday = `${year5}년 ${month5}월 ${day5}일`;
const gender = (val ==1 || val == 3) ? "남" : "여";
const ageage =(val == 1 || val == 2) ? currYear -(1900+ year5) : currYear-(2000+ year5) ;

//결과
console.log(currYear);
console.log("생년월일: "+ birthday);
console.log("성별: " +gender);
console.log("나이: "+ageage);