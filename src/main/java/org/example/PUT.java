package org.example;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class PUT {
    public static void main(String[] args) throws ProtocolException {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setDoOutput(true);

            String jsonInput = "{\"id\": 1, \"title\": \"updated\", \"body\": \"updated content\", \"userId\": 1}";

            try (OutputStream os = conn.getOutputStream()) {
                os.write(jsonInput.getBytes("utf-8"));
            }

            int responseCode = conn.getResponseCode();
            System.out.println("PUT Response Code: " + responseCode);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
