import { useState, useEffect } from "react";

const Clock = () => {
  const [time, setTime] = useState(new Date());
  //처음에 마운트 될때 시간이 써졌겠죠~~~

  // 시간을 가게 하려면 타이머가 필요함
  // 매초 마다 읽음

  //콜백함수
  // clock start 될 때 랜더링 될 때마다
  // setInterval이라는 함수가 1초마다 불러줌
  // 밑에 처럼 구현하면 Clock이 매초마다 setInterval이 계속 생김
  // 계속 자기 복제 됨

  // 마운트 될 때만 호출되게 해야함
  // setInterval(() => {
  //   setTime(new Date());
  // }, 1000);

  useEffect(() => {
    const interval = setInterval(() => {
      setTime(new Date());
    }, 1000);
    // MyComponent가 Unmount되면 interval을 해제합니다. (자원반납)
    return () => clearInterval(interval);
  }, []);

  return (
    <>
      <h2>현재시간{time.toLocaleTimeString()}</h2>
    </>
  );
};

export default Clock;
