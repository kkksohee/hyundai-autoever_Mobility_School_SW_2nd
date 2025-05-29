import { useReducer } from "react";

const Counter = () => {
  const reducer = (state, action) => {
    switch (action.type) {
      case "INCREMENT":
        return { value: state.value + 1 };
      case "DECREMENT":
        return { value: state.value - 1 };
      default:
        return state;
    }
  };
  const [state, dispatch] = useReducer(reducer, { value: 0 });
  return (
    <>
      <p>현재 count: {state.value}</p>
      <button onClick={() => dispatch({ type: "INCREMENT" })}>증가</button>
      <button onClick={() => dispatch({ type: "DECREMENT" })}>감소</button>
    </>
  );
};

export default Counter;
