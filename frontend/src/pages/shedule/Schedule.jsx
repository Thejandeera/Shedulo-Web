import React from 'react'
import './Schedule.css'
import Navbar from '../../components/Navbar'



const Schedule = () => {
  return (
    <div><Navbar/>
    <div className="schedule-container">
      <div className="profile-cards">
        {[...Array(7)].map((_, index) => (
          <div key={index} className="profile-card">
            <div className="profile-pic"></div>
            <div className="profile-info">
              <p>Name</p>
              <p>Role</p>
              <div className="stars">★★★★★</div>
            </div>
          </div>
        ))}
      </div>

      <div className="form-section">
        <div className="make-schedule">
          <h3 className='h3-Schedule' >Make A Schedule</h3>
          <input type="text" placeholder="Your Name" />
          <input type="number" placeholder="Your Age" />
          <select>
            <option>Priority Level</option>
          </select>
          <input type="date" />
          <select>
            <option>Select Time</option>
          </select>
          <input type="text" placeholder="Enter the Reason" />
        </div>

        <div className="selection-box">
          <label>Select Category: <input type="text" /></label>
          <label>Select Name: <input type="text" /></label>
        </div>
      </div>

      <button className="submit-button">Submit</button>
    </div></div>
  );
};

export default Schedule;
