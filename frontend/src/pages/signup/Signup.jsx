import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import "./Signup.css";
import { toast } from "react-toastify";

const SignUp = () => {
  const [user, setUser] = useState({ username: "", email: "", password: "" });
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post("http://localhost:8080/api/users/register", user);
      console.log(response)
      
      if (response.data === "User registered successfully!") {
        navigate("/login");
        toast.success("Please Login Now !");
      } else {
        toast.error(response.data || "Signup failed");
      }
    } catch (error) {
      if (error.response?.data === "Email already exists!") {
        toast.error(error.response.data);
      } else {
        toast.error(error.response?.data || "Signup failed");
      }
    }
  };

  return (
    <div className="signup-container">
      <div className="signup-box">
        <h2 className="h2-signup" >Sign Up</h2>
        <form onSubmit={handleSubmit}>
          <input
            type="text"
            placeholder="Username"
            onChange={(e) => setUser({ ...user, username: e.target.value })}
          />
          <input
            type="email"
            placeholder="Email"
            onChange={(e) => setUser({ ...user, email: e.target.value })}
          />
          <input
            type="password"
            placeholder="Password"
            onChange={(e) => setUser({ ...user, password: e.target.value })}
          />
          <button className='signup-button' type="submit">Sign Up</button>
        </form>
        <p className="login-link">Already have an account? <span onClick={() => navigate("/login")}>Login here</span></p>
      </div>
    </div>
  );
};

export default SignUp;
