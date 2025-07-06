package org.example;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Patch {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();


            conn.setRequestMethod("POST");
            conn.setRequestProperty("X-HTTP-Method-Override", "PATCH"); // трюк
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setDoOutput(true);
            String jsonInput = "{\"title\": \"patched title\"}";

            try (OutputStream os = conn.getOutputStream()) {
                os.write(jsonInput.getBytes("utf-8"));
            }

            int responseCode = conn.getResponseCode();
            System.out.println("PATCH Response Code: " + responseCode);
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage());
        }
    }
}
