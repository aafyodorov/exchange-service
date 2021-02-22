##Exchange service
***
###Description:
This is a microservice that returns a gif image. Depending on whether the rate fell of the transferred 
(as argument) currency relative to USD, then an image with the 'rich' tag will be returned, otherwise it will return
image with tag 'no money'.</br>
Images are taken from [here][2].
Currency rates are taken from [here][1].

###Technologies used in the project:
* Spring Boot
* Feign, as part of Spring Cloud, is used to access external services
* Docker

###Requirements:
* Docker and Docker Compose installed.
* Port 8080 has to be free.

###Run:
To run the application you need to have two environment variables:
1. `GIPHY_APP_ID` - API Key for access to Giphy API, which be obtained from [here][3].
2. `OPEN_EXCH_RATES_APP_ID` - App ID for access to, which can be obtained from [here][4].

###Usage:

[1]: https://openexchangerates.org/
[2]: https://giphy.com/
[3]: https://developers.giphy.com/dashboard/
[4]: https://openexchangerates.org/account/app-ids