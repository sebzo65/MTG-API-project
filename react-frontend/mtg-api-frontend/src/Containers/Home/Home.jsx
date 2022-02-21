import React from "react";
import axios from "axios";

// http://127.0.0.1:8090/magic_card

const Home = () => {
  axios.get(`http://127.0.0.1:8090/magic_card`).then((response) => {
    console.log(response);
    // setTest(response.data);
  });

  return (
    <div>
      <p>Hi!</p>
    </div>
  );
};

export default Home;
