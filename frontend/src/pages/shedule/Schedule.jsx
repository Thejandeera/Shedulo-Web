import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './Schedule.css';
import Navbar from '../../components/Navbar';

const Schedule = () => {
  const [categories, setCategories] = useState([]);
  const [authNames, setAuthNames] = useState([]);
  const [profiles, setProfiles] = useState([]); // For storing profile data
  const [formData, setFormData] = useState({
    name: '',
    age: '',
    priorityLevel: '',
    date: '',
    time: '',
    reason: '',
    category: '',
    authName: ''
  });
  const [isDisabled, setIsDisabled] = useState(true);

  useEffect(() => {
    // Fetch categories
    axios.get('http://localhost:8080/admins/categories')
      .then(response => setCategories(response.data))
      .catch(error => console.error('Error fetching categories:', error));

    // Fetch auth names
    axios.get('http://localhost:8080/admins/authNames')
      .then(response => setAuthNames(response.data))
      .catch(error => console.error('Error fetching auth names:', error));

    // Fetch profiles and limit to 7
    axios.get('http://localhost:8080/admins')
    .then(response => {
      const shuffledProfiles = response.data.sort(() => 0.5 - Math.random()); // Shuffle the array randomly
      setProfiles(shuffledProfiles.slice(0, 7)); // Slice first 7 random profiles
    })
    
  }, []);

  useEffect(() => {
    const allFieldsFilled = Object.values(formData).every(value => value !== '');
    setIsDisabled(!allFieldsFilled);
  }, [formData]);

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = () => {
    axios.post('http://localhost:8080/shedule', formData)
      .then(response => alert('Schedule created successfully!'))
      .catch(error => console.error('Error creating schedule:', error));
  };

  // Function to render image or fallback if null
  const renderProfilePic = (image) => {
    if (image) {
      return <img src={`data:image/jpeg;base64,${image}`} alt="Profile" className="profile-pic-img" />;
    } else {
      return <div className="profile-pic-fallback"></div>; // Gray circle fallback
    }
  };

  return (
    <div>
      <Navbar />
      <div className="schedule-container">
        <div className="profile-cards">
          {profiles.map((profile, index) => (
            <div key={index} className="profile-card">
              <div className="profile-pic">
                {renderProfilePic(profile.image)} {/* Render image or fallback */}
              </div>
              <div className="profile-info">
                <p>{profile.authName}</p>
                <p>{profile.specialization}</p> {/* Role = Specialization */}
                <div className="stars">★★★★★</div>
              </div>
            </div>
          ))}
        </div>

        <div className="form-section">
          <div className="make-schedule">
            <h3 className='h3-Schedule'>Make A Schedule</h3>
            <input type="text" name="name" placeholder="Your Name" onChange={handleChange} />
            <input type="number" name="age" placeholder="Your Age" onChange={handleChange} />
            <select name="priorityLevel" onChange={handleChange}>
              <option value="" disabled selected>moderate</option>
              <option value="1">Most Important</option>
              <option value="2">Important</option>
              <option value="3">Moderate</option>
              <option value="4">Normal</option>
              <option value="5">Less Important</option>
            </select>
            <input type="date" name="date" onChange={handleChange} />
            <select name="time" onChange={handleChange}>
              <option value="" disabled selected>Select Time</option>
              {Array.from({ length: 48 }, (_, i) => {
                const hours = String(Math.floor(i / 2)).padStart(2, '0');
                const minutes = i % 2 === 0 ? '00' : '30';
                return <option key={i} value={`${hours}:${minutes}`}>{`${hours}:${minutes}`}</option>;
              })}
            </select>
            <input type="text" name="reason" placeholder="Enter the Reason" onChange={handleChange} />
          </div>

          <div className="selection-box">
            <select name="category" onChange={handleChange}>
              <option value="" disabled selected>Select Category</option>
              {categories.map((category, index) => (
                <option key={index} value={category}>{category}</option>
              ))}
            </select>
            <select name="authName" onChange={handleChange}>
              <option value="" disabled selected>Select Name</option>
              {authNames.map((name, index) => (
                <option key={index} value={name}>{name}</option>
              ))}
            </select>
          </div>
        </div>

        <button className="submit-button" onClick={handleSubmit} disabled={isDisabled}>Submit</button>
      </div>
    </div>
  );
};

export default Schedule;
