package mocks;

import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.opentable.extension.BodyTransformer;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;


public class Mock {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);

  /*  public static WireMockRule wireMockRule = new WireMockRule(wireMockConfig()
            .port(8089)
            .extensions(new BodyTransformer())
            .notifier(new ConsoleNotifier(true))
    ); */


    public void successResponse() {
        wireMockRule.stubFor(post("/user/add")
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("success.json")
    }

}
