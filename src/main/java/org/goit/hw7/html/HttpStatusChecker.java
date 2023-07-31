package org.goit.hw7.html;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

public class HttpStatusChecker {

    public String getStatusImage(int code) {

        final String BASE_URL = "https://http.cat/";
        String url = BASE_URL + code + ".jpg";

        try {
            Connection connection = Jsoup.connect(url).ignoreContentType(true);
            Connection.Response response = connection.execute();
            if (response.statusCode() == 200) {
                return url;
            } else {
                return "Error request for " + url;
            }

        } catch (IOException e) {
            return "Error request for " + url;
        }
    }
}
