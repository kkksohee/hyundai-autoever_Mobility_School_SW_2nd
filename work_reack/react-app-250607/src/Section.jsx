import React from "react";

function Headign(props) {
  return <h3>{props.text}</h3>;
}
function Paragraph(props) {
  return <h3>{props.text}</h3>;
}
function Section(props) {
  return (
    <div>
      <Headign text={props.title} />
      <Paragraph text={props.content} />
    </div>
  );
}

export default Section;
