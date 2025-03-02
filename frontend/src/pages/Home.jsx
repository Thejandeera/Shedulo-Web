/* Home.jsx */
import React from "react";
import "./Home.css";

const Home = () => {
  return (
    <div className="home-container">
      <div className="card1">
        <h2>Plan Your Day</h2>
        <p>
          Stay organized and boost productivity by scheduling your tasks efficiently.
          Add, edit, and track your daily activities in one place.
        </p>
        <ul>
          <li>Create and manage daily schedules</li>
          <li>Set reminders for important tasks</li>
          <li>Track progress and stay on top of deadlines</li>
        </ul>
        <button>Get Start</button>
      </div>
      <div className="card2">
        <h2>View Schedules</h2>
        <p>
          Access your scheduled tasks anytime, anywhere. Keep track of meetings,
          deadlines, and priorities with an easy-to-use interface.
        </p>
        <ul>
          <li>View all upcoming tasks at a glance</li>
          <li>Filter by date, priority, or category</li>
          <li>Sync with your calendar for scheduling</li>
        </ul>
        <button>View Now</button>
      </div>
    </div>
  );
};

export default Home;