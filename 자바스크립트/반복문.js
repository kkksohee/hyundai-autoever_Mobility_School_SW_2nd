// const prompt = require("prompt-sync")();
// let num = Number(prompt("정수 입력: "));

//for : for(초기값;최종값;증감값), for ..in(키값 순회), for ..of(이터러블 객체 반복)
// for와 for ..of의 차이 
// for: 구간을 정할 수 있음, 내부 데이터 변경 가능
// for ..of: 내부 데이터 변경할 수 x(이게 장점) 처음부터 끝가지 자동 순회 기능

const prompt = require("prompt-sync")();
// let num = Number(prompt("정수 입력: "));

// //입력받은 정수 범위의 합을 구하기
// let sum =0; //반드시 초기화 해줘야 함
// while(num){
//     sum +=num;
//     num--;
// }
// for(let i=1; i<=num; i++){
//     sum += i;
// }
// let i=1;
// for(; i<=num;){    
//     sum += i;
//     i++;
// }
// console.log(sum);

//while 반복횟수를 알 수 없는 경우 유리
//0~200입력을 정상 입력으로 간주
// let age =0;
// while(true) { //무한 반복문, 반드시 탈출조건 필요
//     age = Number(prompt("나이을 입력하세요: "));
//     if(age>= 0 && age <=200) break;
//     console.log("나이를 잘못 입력하셨습니다.");
// }
// console.log(`당신의 나이는 ${age}입니다. `);

//for문
const cars =["테슬라 모델 y","제네시스 G80","그랜저", "산타페","코나"];
// for(let i=0; i<cars.length; i++){
//     cars[i]+="000";
//     console.log(cars[i]);//인덱스 기반
// }

// for ..of 이터러블 순회 방식
for(let e of cars){
    e+="0000"; //이때는 붙음
    console.log(e);//of:키워드 e:대부분 엘리먼트 요소라는 의미로 다른것 써도 됨
}
for(let e of cars){
    //이때는 안붙음, 원본데이터 건들이지 않음음
    console.log(e);//of:키워드 e:대부분 엘리먼트 요소라는 의미로 다른것 써도 됨
}
