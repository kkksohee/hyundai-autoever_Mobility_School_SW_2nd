const prompt = require("prompt-sync")();


let productList = [
    {
        name: "레쓰비",
        price: 700
    },
    {
        name: "티오피",
        price: 1000
    },
    {
        name: "비타500",
        price: 800
    },
    {
        name: "포카리스웨트",
        price: 1000
    },
    {
        name: "파워에이드",
        price: 1200
    }
];

const inputCoin = Number(prompt("금액 입력: "));
//구매가능한 제품 목록 출력
//전통적인 for 순회
//for ..of 순회회
//fliter 사용하는 방법 (같이)

for(let i=0; i<productList.length; i++){
    if(productList[i].price<=inputCoin)
        console.log(productList[i].name);
}
console.log("--");
for(let e of productList){
    if(e.price <= inputCoin) console.log(e.name);
}
console.log("--");
productList
    .filter((e)=> e.price <= inputCoin)
    .forEach((e)=> console.log(e.name));

//Math.random():0~1 미만의 임의의 실수 값 반환 
//Math.random()*45 +1:로또 번호 0~45미만의 임의의 실수값 
//두개의 주사위를 굴려서 같은 값이 나오면 무인도 탈출하기 
while(true){
    const rand1 = parseInt(Math.random() * 6)+1;
    const rand2 = parseInt(Math.random() * 6)+1;

    console.log(`주사위1번:${rand1}, 주사위2번:${rand2}`); //값 출력
    if(rand1 == rand2) break;
}
console.log("주사위 값이 같으므로 무인도를 탈출합니다.");


//for ..in : 객체의 키 값 기준 순회
const person = {name:"안유진", age: 23, isAdult: true};
for(const key in person){
    console.log(person[key]);
}
