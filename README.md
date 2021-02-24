## Exchange service ![Build Status]
***
### Description:
This service calls the exchange rate service and returns a gif in response:
* if the dollar rate in relation to the transferred currency has decreased, then the image with the `rich` tag is 
returned.
* In this case, an image with the tag 'no money' is returned.

Images are taken from [here][2]. </br>
Currency rates are taken from [here][1].

### Technologies used in the project:
* Spring Boot
* Feign, as part of Spring Cloud, is used to access external services
* Docker

### Requirements:
* Docker and Docker Compose installed.
* Port 8080 has to be free.

### Run:
1. Put into repository roo  `.env` file with two pair `key=value`:
    * `GIPHY_APP_ID` - API Key for access to Giphy API, which can be obtained from [here][3].
    * `OPEN_EXCH_RATES_APP_ID` - App ID for access to, which can be obtained from [here][4].
2. To start the service use the command: 
    >docker-compose up

### Usage:
Service has one endpoint: `GET /gif`. It requires the argument `cur`, which is the three-letter currency code.</br>
Examples:</br>
* If you build locally:
>http://localhost:8080/gif?cur=RUB

* Or without build (it can take about 30 sec):
>https://afjord-exchange-service.herokuapp.com/gif?cur=RUB

[1]: https://openexchangerates.org/
[2]: https://giphy.com/
[3]: https://developers.giphy.com/dashboard/
[4]: https://openexchangerates.org/account/app-ids
[Build Status]: https://travis-ci.com/aafyodorov/exchange-service.svg?branch=master