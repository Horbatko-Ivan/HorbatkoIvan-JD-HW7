package org.goit.hw7.html;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {

    public void askStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter HTTP status code");
        String httpCode = scanner.nextLine();
        try {
            int statusCode = Integer.parseInt(httpCode);
            imageDownload(statusCode);
        } catch (NumberFormatException | IOException e) {
            System.out.println("Please enter valid number");
        }
    }

    private void imageDownload(int statusCode) throws IOException {
        try {
            new HttpStatusImageDownloader().downloadStatusImage(statusCode);
        } catch (FileNotFoundException e) {
            System.out.println("There is not image for HTTP status" + statusCode);
        }
    }
}
