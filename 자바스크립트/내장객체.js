//문자열을 다루는 string 객체
// 특정 문자열 포함 여부 : includes(), indexOf()

const email = "thgml@gmail.com";
if (!email.includes("@")) {
  console.log("올바른 이메일이 아닙니다.");
}

// if(email.indexOf("@")==-1) {
//     console.log("올바른 이메일이 아닙니다.");
// }
console.log(email.indexOf("@"));

//슬라이싱: 문자열에서 특정 부분 문자열 추출
const fruits = "apple, banana, orange";
const subStr = fruits.slice(0, -1); //-1은 맨뒤를 의미함 -1미만까지 -2(끝에서 두번째)
const subStr2 = fruits.substring(1, 5); //음수를 허용하지 않음
console.log(subStr);
console.log(subStr2);

//문자열 지우기
let str = "지구오락실, 이영지, 안유진, 미미,이은지";
let n = str.replace("이은지", "");
console.log(n);

//문자열 결합
let text = "안녕하세요.";
text += "오늘은 ";
text += "날씨가 아주 별로얏!";
text += "집에 가고 싶어!!!ㅜ";
console.log(text);

//리액트에서 내부의 값을 변경하기 위해 밑의 방법을 써야함.->주소가 바뀌어야 함
const text1 = "안녀하세요.";
const text2 = text1.concat("오늘은 ");
const text3 = text2.concat("날씨가 별로얏!");
const text4 = text3.concat("집에 가고 싶어!!!ㅜ");
console.log(text4);

//forEach()
const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
numbers.forEach((num) => {
  console.log(num);
});

//map es5에서 도입 배열의 각 요소를 변형-> 새로운 배열을 만듬
// 리액트에서 핵심
const doubled = numbers.map((num) => num * 2);
console.log(doubled);

//filter() 조건에 맞는 요소만 추출해서 새로운 배열 생성
const even = numbers.filter((num) => num % 2 == 0);
console.log(even);

//reduce(): 합이나 곱을 구할 때 사용
// 1+ 2=3 쓰면 소모가 됨
// 그럼 a=3 b=3 +=6
// a=6, b=4;
const sum = numbers.reduce((a, b) => a + b, 0 /*초기값*/);
console.log(sum);
