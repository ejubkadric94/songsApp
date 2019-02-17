import React, { Component } from 'react';
import './App.css';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      email: '',
      password: ''
    };
  }

  updateEmail(event) {
    this.setState({
      email: event.target.value
    });
  }

  updatePassword(event) {
    this.setState({
      password: event.target.value
    });
  }

  onLogin = () => {
    const { email, password } = this.state;

    const url = "http://localhost:8081/authorization/authenticate";
    fetch(url, {
        method : "POST",
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body : JSON.stringify({
            email,
            password
        })
    }).then(response => {
      if (response.status === 200) {
        response.json().then(body => window.location.href = document.referrer + 'home/' + body.accessToken.token + '/' + body.bearerToken.token);
      }
    });
  }

  render() {
    return (
      <div className="App">
          <h1 className="login-title">Authorization Server</h1>
          <input
            type="text"
            className="login-input"
            placeholder="Email Adress"
            autoFocus
            value={this.state.email}
            onChange={evt => this.updateEmail(evt)}
          ></input>
          <input
            type="password"
            className="login-input"
            placeholder="Password"
            value={this.state.password}
            onChange={evt => this.updatePassword(evt)}
          ></input>
          <button type="submit" value="Lets Go" className="login-button" onClick={this.onLogin}>Login</button>
      </div>
    );
  }
}

export default App;
