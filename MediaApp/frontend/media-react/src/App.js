import React, { Component } from 'react';
import LoginPage from './components/LoginPage';
import HomePage from './components/HomePage';
import { BrowserRouter as Router, Route } from "react-router-dom";

import './App.css';

class App extends Component {
  render() {
    return (
      <Router>
        <div>
          <Route exact path="/" component={LoginPage} />
          <Route path="/home/:accessToken" component={HomePage} />
        </div>
      </Router>
    );    
  }
}

export default App;
