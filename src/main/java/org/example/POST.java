package org.example;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class POST {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setDoOutput(true);
            String jsonInput = "{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}";

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInput.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code: " + responseCode);

        } catch (Exception e) {
            System.out.println("");
        }
    }
}
