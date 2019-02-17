import React, { Component } from 'react';

class HomePage extends Component {
  constructor(props) {
    super(props);
    this.state = {
      loading: true,
    }
  }

  componentDidMount() {
    fetch('http://localhost:8080/user/' + this.props.match.params.accessToken, {
      method : "GET",
      headers: {
        'Accept': 'application/json',
      }
  }).then(response => {
    if (response.status === 200) {
      response.json().then(body => {
        this.setState({
          loading: false,
          firstName: body.message
        });
      })
    }
  });
  }

  getLoadingText() {
    return <h1>Loading...</h1>;
  }

  render() {
    return (<>
      <center>
        <h2>
          Welcome
        </h2>
        Your access token: <em>{this.props.match.params.accessToken}</em> <br></br>
        Your bearer (refresh) token: <em>{this.props.match.params.bearerToken}</em> <br></br><br></br><br></br>

        <b>Note:</b>
        <span>Both tokens should be safely secured!</span>
      </center>
    </>);
  }
}

export default HomePage;
