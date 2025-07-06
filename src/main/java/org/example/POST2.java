package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class POST2 {
    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("https://jsonplaceholder.typicode.com/posts");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setRequestProperty("User-Agent", "MyJavaApp");
            conn.setDoOutput(true);
            String request = "{\n" +
                    "  \"title\": \"Hello world\",\n" +
                    "  \"body\": \"This is a test post\",\n" +
                    "  \"userId\": 5\n" +
                    "}";

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = request.getBytes("utf-8");
                os.write(input, 0, input.length);
            }


            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code: " + responseCode);

            try (BufferedReader br = new BufferedReader( new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    System.out.println(responseLine);
                }
            }

        } catch (Exception e) {
            System.out.println("ExceptioN " + e.getMessage());
        }
    }
}