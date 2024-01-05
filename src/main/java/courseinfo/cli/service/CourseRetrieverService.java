package courseinfo.cli.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CourseRetrieverService {
    private static final String PS_URI = "https://app.pluralsight.com/profile/data/author/%s/all-content/";
    private static final HttpClient CLIENT = HttpClient
            .newBuilder()
            .followRedirects(HttpClient.Redirect.ALWAYS)
            .build();
    public String getCourses(String authorID) {
        HttpRequest request = HttpRequest
                .newBuilder(URI.create(PS_URI.formatted(authorID)))
                .GET()
                .build();

        try {
            HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            // return response, deal with error codes
            return switch(response.statusCode()) {
                case 200 -> response.body();
                case 404 -> "Not found";
                default -> throw new RuntimeException("Pluralsight API failed with status code: " + response.statusCode());
            };
        } catch (IOException | InterruptedException e){
            throw new RuntimeException("Could not call Pluralsight API", e);
        }
    }

}
