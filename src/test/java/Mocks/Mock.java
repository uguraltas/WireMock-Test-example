package Mocks;

import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.opentable.extension.BodyTransformer;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;


public class Mock {

    public static WireMockRule wireMockRule = new WireMockRule(wireMockConfig()
            .port(8089)
            .extensions(new BodyTransformer())
            .notifier(new ConsoleNotifier(true))
    );


    public static void response(String response) {
        wireMockRule.start();
        wireMockRule.stubFor(post(urlEqualTo("/user/add"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile( response + ".json" )
                        .withTransformers("body-transformer")
                        .withTransformerParameter("urlRegex",
                                "/user/add/(?<userName>.*?)/&rolName=(?<roleName>.*?)")
                ));
    }

}
