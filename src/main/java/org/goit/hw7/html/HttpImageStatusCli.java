package org.goit.hw7.html;

import java.util.Scanner;

public class HttpImageStatusCli {

    public void askStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter HTTP status code");
        String httpCode = scanner.nextLine();
        int code;

        if (!httpCode.matches("^\\d{1,3}$")) {
            System.out.println("Please enter valid number");
            askStatus();
        } else {
            code = Integer.parseInt(httpCode);
            try {
                new HttpStatusImageDownloader().downloadStatusImage(code);
            } catch (Exception e) {
                System.out.println("There is not image for HTTP status " + code);
            }
        }
    }
}
