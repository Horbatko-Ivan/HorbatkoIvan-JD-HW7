package org.goit.hw7.html;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HttpStatusChecker {

    private static final String BASE_URL = "https://http.cat/";

    public String getStatusImage(int code) {

        String url = BASE_URL + code + ".jpg";

        try {
            Connection connection = Jsoup.connect(url).ignoreContentType(true);
            Connection.Response response = connection.execute();
            if (response.statusCode() == 200) {
                return url;
            } else {
                throw new FileNotFoundException();
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
