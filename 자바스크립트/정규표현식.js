//test() 문자열에 패턴이 있는지 검사하고 결과를 true / false로 변환
const regEXP = /Hello/;
console.log(regEXP.test("Hello World!!!!"));

//exec() : 문자열애서 패턴에 일치하는 첫 번째 결과를 반환환
const result = /가장+/.exec("가장 큰 실수는 포기입니다");
console.log(result); // ["가장"]

//match() : 문자열에서 배턴에 일치하는 모든 결과를 배열로 반환
const phone = "010-1234-5678 010-5006-6789 010-2040-7252";
const regNum = phone.match(/\d{3}-\d{4}-\d{4}/g);
console.log(regNum);

//웹사이트 주소 찾기
const regex=/https?:\/\/[\w\-\.]+/g;
const urls = "http://naver.com https://google.co.kr dkslkjrlkdlkm";
console.log(urls.match(regex));

//이메일 검사하기
const regex_email = /^([a-z]+\d*)+(\.?\w+)+@\w+(\.\w{2,3})+$/;
console.log(regex_email.test("example@gmail.com")); // true

//비밀번호 정규표현식: 대문자, 소문자, 숫자, 특수문자 2자, 길이는 8자리 이상 16자리이하
const regexPW = /^(?=(?:.*[!@#$%^&*()_\-+=])[2,])(?=.*[A-Z])(?=.*[a-z])(?=.*\d)[A-Za-z\d!@#$%^&*()_\-+=]{8,16}$/;
// console.log(regexPW.match(regexPW));

 const regexPW1 = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]).{8,}$/;
const atest = "tkfkdENDdl92!";
console.log(regexPW1.test(atest));
// console.log(regexPW.match(atest));
