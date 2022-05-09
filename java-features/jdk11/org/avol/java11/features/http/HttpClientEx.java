package org.avol.java11.features.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * @author Lovababu P.
 * DateTime: 09-05-2022
 * Project Name: java11feataures
 **/
public class HttpClientEx {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient httpClient = java.net.http.HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(20))
                .build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://github.com/lovababu/core-java-example"))
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        assert httpResponse.body().contains("lovababu");
        assert httpResponse.statusCode() == 200;
    }
}
