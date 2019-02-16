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
    return this.state.loading ? this.getLoadingText() : (
      <h2>
        Welcome: <em>{this.state.firstName}</em>
      </h2>
    );
  }
}

export default HomePage;
