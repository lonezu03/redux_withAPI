//import React from 'react'

// import { useState } from "react";
import {  useSelector } from "react-redux";

// import companySlice, {
  
//   Fixcompany,
//   Addcompany,
//   Detelecompany,
// } from "../redux/companySlice.jsx";
import { company } from "../redux/selection.jsx";
const Index = () => {
  const Company = useSelector(company);
  //const dispatch = useDispatch();


  return (
 <div>
<ul>
{Company.map((el) => (
            <li
             
              key={el.id}
              style={{
                display: "flex",
                gap: "30px",
                marginBottom: "10px",
                border: "2px solid black",
                width: "400px",
                margin: "auto",
                height: "80px",
                borderRadius: "5px",
                textAlign: "left",
              }}
            >
              <div style={{ padding: "10px" }}>
                {" "}
                <span style={{ fontWeight: "bold", marginRight: "10px" }}>
                  Department name:
                </span>
                {el.companyname}{" "}
              </div>
            </li>
          ))}
</ul>


 </div>
  );
};

export default Index;
