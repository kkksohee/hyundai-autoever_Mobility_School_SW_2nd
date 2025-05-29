// for(let i = 1; i<=9; i++) {
//     console.log(`2 x ${i} =  ${2 * i}`);
// }

// const num = Number(prompt("숫자 입력 : "));

// if(num >= 0) {
//     //console 형태로 출력
//     // console.log(`${num}은 1양수 입니다.`)
//     //브라우저 에서 출력하기 (html문법 사용)
//     document.write("<h1>양수입니다</h1>");
// }
// else {
//     //console 형태로 출력
//     // console.log(`${num}은 음수 입니다.`)
//     //브라우저 에서 출력하기
//     document.write("<h1>음수입니다</h1>");
// }


// const PI=3.14;
// console.log(PI * 20);

//프롬프트prompt 입력받기 : 자바스크립트는 기본적으로 웹기반의 언어 이므로 콜솔 입력이 없음-웹에서 입력을 받아야함
const name1 = prompt("이름을 입력 하세요.");
const greeting = document.getElementById("greeting"); //id선ㅌ택자로 태그를 찾음 html에서 
if(name1) {
    greeting.innerText = `${name1}님, 환영합니다.`;
}
else {
    greeting.innerText ="이름을 입혁하지 않으셨습니다.";
}