import React from "react";
import axios from "axios";

const Home = () => {
  axios.get(`http://127.0.0.1:8090/test_entity/test/seb`).then((response) => {
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
