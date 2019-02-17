# Songs Application

Songs application is an example app which contains a REST service (created with Spring Boot 2) for storing songs. It contains a separate Authorization server which serves as OAuth2 Auth server. Both servers (resources server and auth server) use the embedded H2 database.

Both `songsApp/AuthorizationApp` and `songsApp/MediaApp` contain a frontend folder. Both of these include a basic ReactJS apps whose point is to demonstrate how OAuth2 login works.

## Installation

Clone the repo:

```bash
git clone https://github.com/ejubkadric94/songsApp.git
```

## Running

Authorization server (runs on port 8081):
```
cd SongsApp
java -jar AuthorizationApp/Server/target/authorization-0.0.1-SNAPSHOT.jar 
```

Authorization client (runs on port 3001):
```
cd SongsApp/AuthorizationApp/Frontend/authorization-react
yarn
yarn start
```


Resources (songs) server (runs on port 8080):
```
cd SongsApp
java -jar SongsApp/MediaApp/Server/target/server-0.0.1-SNAPSHOT.jar 
```

Resources client (runs on port 3000):
```
cd SongsApp/MediaApp/frontend/media-react
yarn
yarn start
```

## Usage
Open `http://localhost:3000`. To login, you can use credentials `admin@songsapp.com:letmein`. Afterwards, use Postman to check out endpoints on resource server.


## License
[MIT](https://choosealicense.com/licenses/mit/)