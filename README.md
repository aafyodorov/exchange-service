## Exchange service ![Build Status]
***
### Description:
This is a microservice that returns a gif image. Depending on whether the rate fell of the transferred 
(as argument) currency relative to USD, then an image with the 'rich' tag will be returned, otherwise it will return
image with tag 'no money'.</br>
Images are taken from [here][2].
Currency rates are taken from [here][1].

### Technologies used in the project:
* Spring Boot
* Feign, as part of Spring Cloud, is used to access external services
* Docker

### Requirements:
* Docker and Docker Compose installed.
* Port 8080 has to be free.

### Run:
1. You need to have two environment variables to run the application:
    * `GIPHY_APP_ID` - API Key for access to Giphy API, which can be obtained from [here][3].
    * `OPEN_EXCH_RATES_APP_ID` - App ID for access to, which can be obtained from [here][4].
2. To start the service use the command: 
    >docker-compose up

### Usage:
Service has one endpoint: `GET /gif`. It requires the argument `cur`, which is the three-letter currency code.
Example:
>http://localhost:8080/gif?cur=RUB

[1]: https://openexchangerates.org/
[2]: https://giphy.com/
[3]: https://developers.giphy.com/dashboard/
[4]: https://openexchangerates.org/account/app-ids
[Build Status]: https://travis-ci.com/aafyodorov/exchange-service.svg?branch=master