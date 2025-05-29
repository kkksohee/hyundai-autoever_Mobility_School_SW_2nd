//자바스크립트는 원시 타입을 제외한 모든 값이 객체
//객체 리터럴은 중괄호{} 로 생성, 속성과 값의 쌍으로 구성
const person = {
    title: "지구오락실",
    name: "안유진",
    age: 23,
    job: "IVE",
}

console.log(person);

const member ={
    id: "thgml",
    pwd: "1234",
    addr: {
        home: "서울시 강북구",
        company: "서울시 금천구",
    },
    name: "김소희",
    func1: () => {
        console.log("함수 호출 입니다.");
    },
}
//반환값이 없었어서 undefined가 떴었던 것.
member.func1();
//순회하면 됨
const members = [
    {id: "ive1", pwd: "1234", addr:{home:"서울시 성북구",company: "서울시 강서구"}, name: "안유진"},
    {id: "ive22", pwd: "1234", addr: "서울시 강남구", name: "장원영"},
    {id: "nyz", pwd: "1234", addr: "서울시 강남구", name: "하니"},
    {id: "ive5", pwd: "1234", addr: "서울시 강남구", name: "가을"},
    {id: "newjeans", pwd: "1234", addr: "서울시 강남구", name: "혜린"},
    {id: "aespa1", pwd: "1234", addr: "서울시 강남구", name: "윈터"},
    {id: "po", pwd: "1234", addr: "서울시 강남구", name: "피오"},
    {id: "aespa2", pwd: "1234", addr: "서울시 강남구", name: "카리나"},    
]
//배열 순회
// 리액트에서는 map을 많이 사용
// member:한개한개의 객체
members.map(member=>{
    console.log("아이디 : "+ member.id);
    console.log("비밀번호 : "+ member.pwd);
    console.log("주소 : "+ member.addr.home, member.addr.company);
    console.log("이름 : "+ member.name);
    console.log("---------------------------------------");
})

