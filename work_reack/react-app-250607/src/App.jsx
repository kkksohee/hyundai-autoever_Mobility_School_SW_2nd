import { use, useEffect, useState } from "react";

import "./App.css";

function WelcomProp(props) {
  return <h2>hello, {props.name}</h2>;
}

function App() {
  const element = <WelcomProp name="소히" />;
  const [todo, setTodo] = useState([
    { id: 1, text: "청소하기" },
    { id: 2, text: "점심먹기" },
    { id: 3, text: "웅이랑 산책하하기" },
  ]);
  const [inputText, setInputText] = useState("");
  const [nextTodoId, setnextTodoId] = useState("4");

  const inputTextTodo = (e) => setInputText(e.target.value);
  const addTodo = () => {
    // const newtodo = todo.concat({
    //   id: nextTodoId,
    //   text: inputText,
    // });
    const newTodo = [...todo, { id: nextTodoId, text: inputText }];
    setnextTodoId(nextTodoId + 1);
    setTodo(newTodo);
    setInputText("");
  };
  useEffect(() => {
    localStorage.setItem("todo", JSON.stringify(todo));
  }, [todo]);
  const onEnter = (e) => {
    if (e.key === "Enter") addTodo();
  };
  const onRemove = (id) => {
    const nextTodoes = todo.filter((todo) => todo.id !== id);
    setTodo(nextTodoes);
  };
  const listTodo = todo.map((todo) => (
    <li key={todo.id} onClick={() => onRemove(todo.id)}>
      {todo.text}
    </li>
  ));

  return (
    <>
      {element}
      <div>
        <p>to do List</p>
        <p>삭제는 해당 항목을 클릭하세요.</p>
        <input value={inputText} onChange={inputTextTodo} onKeyDown={onEnter} />
        <button onClick={addTodo}>추가</button>
        <ul>{listTodo}</ul>
      </div>
    </>
  );
}

export default App;
