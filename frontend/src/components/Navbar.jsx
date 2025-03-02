import React from "react";
import "./Navbar.css";
import { FaUser } from "react-icons/fa";
import { useNavigate } from "react-router-dom";

const Navbar = () => {
  const navigate = useNavigate();
  return (
    <nav className="navbar">
      <div className="logo" onClick={() => navigate("/")}>
      Shedulo
    </div>
      <ul className="nav-links">
        <li><a href="schedule">Schedule</a></li>
        <li><a href="categories">Categories</a></li>
        <li><a href="manage">Manage</a></li>
        <li><a href="contact">Contact Us</a></li>
      </ul>
      <div className="user-icon">
        <FaUser />
      </div>
    </nav>
  );
};

export default Navbar;