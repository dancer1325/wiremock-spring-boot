# WireMock Spring Boot

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.wiremock.integrations/wiremock-spring-boot/badge.svg)](https://search.maven.org/artifact/org.wiremock.integrations/wiremock-spring-boot)

* == library / 👀simplifies WireMock configuration | **Spring Boot** & **JUnit 5** application 👀
  * FULLY declarative [WireMock](https://wiremock.org/) setup
  * Support MULTIPLE `WireMockServer` instances
    * recommendations
      * 👀1 `WireMockServer` instance / HTTP client 👀
  * AUTOMATICALLY sets Spring environment properties
  * NOT pollute Spring application context -- with -- EXTRA beans

## Documentation
* [here](https://wiremock.org/docs/spring-boot/)
* [examples](src/test/java/usecases)

## Credits

* [Maciej Walkowiak](https://github.com/maciejwalkowiak)
* [Spring Cloud Contract WireMock](https://github.com/spring-cloud/spring-cloud-contract/blob/main/spring-cloud-contract-wiremock)
* [Spring Boot WireMock](https://github.com/skuzzle/spring-boot-wiremock)
* [Spring Boot Integration Tests With WireMock and JUnit 5](https://rieckpil.de/spring-boot-integration-tests-with-wiremock-and-junit-5/) by [Philip Riecks](https://twitter.com/rieckpil)
