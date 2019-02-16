import React, { Component } from 'react';

class LoginPage extends Component {
  redirectToAuthorizationServer() {
    window.open("http://localhost:3001", "_blank");
  }

  render() {
    return (
      <>
        <h2>Login using authorization server (using OAuth2)</h2>
        <h3>This will redirect you to the auth server.</h3>
        <button onClick={this.redirectToAuthorizationServer}>Login</button>
      </>
    );
  }
}

export default LoginPage;
