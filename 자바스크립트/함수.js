const prompt = require("prompt-sync")();

//함수 선언문 : 호이스팅(끌어올림) 됨, 함수는 호출해야 실행됨됨
console.log(sum(100,200));
console.log(sum(1.1,2.2));
console.log(sum("아이브","안유진"));
function sum(a, b) {
    return a+b;
}

//함수표현식: 변수의 익명 또또는 기명 함수 할당
const mul = function(a, b){ //함수이름 없음
    return a*b;
}
console.log(mul(5,3));

//화살표 함수 
const div = (a,b) => a/b;
console.log(div(10,4));

//즉시 실행 함수
(function(){
    console.log("디바이스 정보를 불러와서 셋업...");
})();//작은 괄호()가 실행

//기본값 할당
function sum1(a,b,c=300) {
    return a+b+c;
}
console.log(sum1(100,200));

//콜백 함수 : 비동기 처리와 아주 밀접한 관계를 가짐
// 버튼이 언제 눌려질지 모르기 떄문에(버튼은 같은 버튼이지만 안의 내용은
//다르게 하면됨)
//-> 어떤 일이 일어 났을 때 내가 원하는 곳으로 불러주는 

//콜백함수란? 함수 인자로 다른 함수를 전달하여, 그함수가 실행될 때 호출되는 함수 의미
//사용자 이벤트 처리: btn.addEventListener("click",콜백함수ㅜ{})
// 서버통신시 사용: axios 기반의 비동기 통신(async/ await)
//파일 입출력 시: 속도 차이가 발생하므로 
//의도적으로 지연이 필요한 경우

function birdSing(weather) {
    console.log(weather + "새가 즐겁게 노래합니다.");
}
function catCry() {
    console.log("😿 고양이가 슬프게 웁니다.");
}

function dogDance() {
    console.log("🐶 강아지가 신나게 춤을 춥니다!");
}

function checkAnimalMood(mood){
    if(mood === "happy") birdSing();
    else if(mood === "sad") catCry();
    else dogDance();
}
//콜백함수로
//함수의 매개변수 자리에 함수를 넣음
function checkAnimalMoodCallback(mood, happyAction, sadAction) {
    if(mood === "happy") happyAction();
    else if(mood === "sad") sadAction("비가 와도 ");
}
//함수에 ()가 없으면 등록 개념 
// checkAnimalMoodCallback("happy", dogDance, birdSing);
// checkAnimalMoodCallback("happy", 한줄자리 함수 넣어도 됨, birdSing);

checkAnimalMoodCallback(
    "sad",
    () => {
        console.log("아무것도 안함");
    },
    birdSing
);

//callback 타이머
function buyToy(item, price, quantity, callback) {
    console.log("🧒 아이가 '" + item + "' 장난감을 " + quantity + "개 골라서 엄마에게 가져갔습니다.");
    setTimeout(()=> {
        console.log("💰 계산이 필요합니다.");
        let total = price * quantity;
        callback(total);
    }, 2000);
}

const pay = (total) =>{
    console.log("엄마: '지불할 금액은 " + total + "원입니다.'");
    console.log("🧒 아이: '와! 고마워요, 엄마!' 🎉");
}

buyToy("공룡 장난감", 3000, 3, pay);

//클로저
function Counter() {
    let count =0;
    return {
        increment : function() {
            count++;
            console.log(count);
        },
        decrement : function() {
            count--;
            console.log(count);
        }
    };
};
const myCunt = Counter(); //함수를 변수에 대입하는것 :일급고차함수
myCunt.increment();
myCunt.increment();