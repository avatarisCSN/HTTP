package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GET4 {
    public static void main(String[] args) {
        try  {
            URL url = new URL("https://api.example.com/users?page=2&sort=desc");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            int responseCode = conn.getResponseCode();

            if ( responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                StringBuilder builder = new StringBuilder();
                while((line = in.readLine()) != null) {
                    System.out.println(line);
                    builder.append(line);
                }
                in.close();
                System.out.println(builder.toString());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage() + "  exception");
        }
    }
}
