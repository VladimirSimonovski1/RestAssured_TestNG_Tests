package config;

import org.apache.http.client.utils.URIBuilder;

public class Hostname {

    public static String hostname(String path) {
        return new URIBuilder()
                .setScheme("https")
                .setHost("reqres.in/api")
                .setPath(path).toString();
    }
}
