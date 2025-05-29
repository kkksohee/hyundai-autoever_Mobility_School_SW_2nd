//함수 선언문
function sum(a, b) {
  return a + b;
}
//함수 표현식
const mul = function (a, b) {
  return a + b;
};
const divide = (a, b) => a + b;
console.log(sum(3, 4));
console.log(mul(1, 2));
console.log(divide(4, 5));
(function () {
  console.log("즉시 실행");
})();

let a = 10;
{
  let b = 20;
  console.log(`코드 블록 내부 a : ${a}`);
  console.log(`코드 블록 내부 b : ${b}`);
}
console.log(`코드 블록 외부 a : ${a}`);
console.log(`코드 블록 외부 b : ${b}`);
