import { NavLink as ReactLink, useNavigate } from "react-router-dom";
import { Navbar, NavbarBrand, NavItem, NavLink } from "reactstrap";
import React, { useState } from "react";
import "../styling/CustomNavbar.css";


const CustomNavbar = () => {

  return (
    <div >
        <Navbar className="navbar">
        <NavbarBrand className="navbar__header" tag={ReactLink} to="/"><h3>  MyBlog 💬</h3>
               
                </NavbarBrand>
      
     
        <div className="blog__search">
          <input
            className="search"
            placeholder="Search for a blog"></input>
          
          <button className="submit" >
            Search
          </button>
        
          </div>
  
        <div className="navbar__user__data">
         
          
         
             
              
                 <NavItem>
                            <NavLink className="logout__button" tag={ReactLink} to="/add" >
                            ADD Blog 😦
                            </NavLink>
                            </NavItem>
                
              
           
          
        </div>
        </Navbar>
        </div>
     
  
  )
  }
  
    

export default CustomNavbar;