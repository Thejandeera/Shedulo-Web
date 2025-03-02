import React from "react";
import { ToastContainer } from "react-toastify";
import {
  BrowserRouter as Router,
  Routes,
  Route,
} from "react-router-dom";
import Home from "./pages/home/Home.jsx";
import Navbar from "./components/Navbar.jsx";
import Categories from "./pages/categories/Categories.jsx";
import Contact from "./pages/contact/Contact.jsx";
import Manage from "./pages/manage/Manage.jsx";
import Schedule from "./pages/shedule/Schedule.jsx";

const App = () => {
  return (
    <Router> {/* Wrap everything inside Router */}
      <ToastContainer />
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/home" element={<Home />} />
        <Route path="/schedule" element={<Schedule />} />
        <Route path="/manage" element={<Manage />} />
        <Route path="/contact" element={<Contact />} />
        <Route path="/categories" element={<Categories />} />
      </Routes>
    </Router>
  );
};

export default App;
