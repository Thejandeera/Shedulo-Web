import React from "react";
import "./Navbar.css";
import { FaUser } from "react-icons/fa";

const Navbar = () => {
  return (
    <nav className="navbar">
      <div className="logo">Shedulo</div>
      <ul className="nav-links">
        <li><a href="#">Schedule</a></li>
        <li><a href="#">Categories</a></li>
        <li><a href="#">Manage</a></li>
        <li><a href="#">Contact Us</a></li>
      </ul>
      <div className="user-icon">
        <FaUser />
      </div>
    </nav>
  );
};

export default Navbar;