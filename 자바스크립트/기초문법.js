//변수이름은 카멜표기법 준수(첫번째 소문자 두번째 대문자) ,스네이크 표기법
let userName = "안유진"; 
let _score =100;
let $value =50;
let _1val = 1;

//변수와 상수 
//let 변수 선언 시 사용, 블록스코프, ES6
//const 상수 선언 시 , 재할당 불가 
//var : 예전 사용 방식, 사용 금지, 호이스팅이 일어남
// var tmp;
// console.log(tmp);
// tmp=100;

// console.log(tmp);
// var tmp = 100;

//템플릿 문자열 : ES6애서 추가된 문법
//자바스크립트는 문자열을 출력할 때 "", '' 구분하지 않음, 문자와 문자열 구분하지 않음(전부 문자열)
//``도 사용용
const name2 = "장원영";
const age = 22;
const addr = "서울시 강남구 역삼동"

//{}에는 연산자 다 넣을 수 있음, 3항 연산자도
console.log(`이름: ${name2}, 나이: ${age}, 주소: ${addr}`);

// 숫자형 (Number) :정수의 실수형을 포함해서 숫자형으로 취급
//근사치 계산법으로 계산되기 때문에 정확한 값 표현이 안됨
console.log(0.1 + 0.2);

//논리형: 참, 거짓으로 값 표현
console.log(Boolean(10)); //true
console.log(Boolean(0)); //false
console.log(Boolean("")); //false
console.log(Boolean(" ")); //true
console.log(Boolean(0.0001)); //true
console.log(Boolean(undefined)); //false
console.log(Boolean(null)); //false
console.log(Boolean(NaN)); //false

//배열: 
//알고있는 것: 크기를 정해야 되고 동일한 메모리공간이 연속적으로 있는 것, index기반으로 값을 찾는 것(O(1))
// 동일한 데이터 타입이 연속된 공간에 저장되는 방식, index를 가지고 값을 찾는 방식
//자바스크립트 : 동일한 데이터 타입 아니여도 됨.
const arr1 = ["아이브",
     "안유진",
      23, 
      true, [100, 90, 56], 
["대전시","서울 시","수원시"], {posiiton: "리더"}];
console.log.apply(arr1);
//인덱싱 :인덱스로 원하는 값을 추출하는 것
console.log(arr1[1]);
console.log(arr1[5][0]);
console.log(arr1[5][0][1]);
console.log(arr1[6]["position]"]);

//객체: 키와 값으로 구성
const person = {
    name2: "민지",
    addr: {
        city: "서울시",
        gu: "강북구",
        dong: "역삼동",
    },
}

console.log(person);    
console.log(person.name2);
console.log(person.addr.city);

//  객체 타입: 객체 타입이라는 건 주소를 찹조하는 타입입
const person1 = person;
person1.name = "하니";
person1.name.city="태국";
console.log(person.name1);
console.log(person.addr.city);