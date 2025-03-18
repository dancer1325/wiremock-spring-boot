package usecases;

import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.ok;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestClient;
import org.wiremock.spring.ConfigureWireMock;
import org.wiremock.spring.EnableWireMock;

@SpringBootTest(classes = ExampleConfigurationDeclarativeTests.AppConfiguration.class)
@ActiveProfiles("test") // pick "application-test.properties"
@EnableWireMock( // run 1 WireMock instance / declarative configuration
    @ConfigureWireMock( // TODO: Why do I NOT see any change?
        baseUrlProperties = {"customUrl", "sameCustomUrl"},
        portProperties = "customPort",
        name = "custom-wiremock",   // | run test, check logs
        port = 8888                 // | run test, check logs
    )
)
public class ExampleConfigurationDeclarativeTests {
  @Value("${wiremock.server.baseUrl}")
  private String wireMockUrl;

  @Value("${customUrl}")
  private String customUrl;

  @Value("${sameCustomUrl}")
  private String sameCustomUrl;

  @Value("${customPort}")
  private String customPort;

  @Test
  void returns_a_ping() {
    stubFor(get("/ping").willReturn(ok("pong")));

    RestClient client = RestClient.create();
    // String body = client.get().uri(wireMockUrl + "/ping").retrieve().body(String.class);
    String body = client.get().uri(customUrl + "/ping").retrieve().body(String.class);

    assertThat(body).isEqualTo("pong");
  }

  @SpringBootApplication
  static class AppConfiguration {}
}
