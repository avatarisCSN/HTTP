package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GET8 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://api.github.com/users/denis");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "MyJavaApp");
            conn.setRequestProperty("Accept" , "application/vnd.github.v3+json");
            int requestCode = conn.getResponseCode();
            if (requestCode == 200) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(conn.getInputStream())
                );

                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                System.out.println("User data: ");
                System.out.println(response.toString());
            } else {
                System.out.println("Ошибка: " + requestCode);
            }
        } catch (Exception e) {
            System.out.println("Exception");
        }


    }
}
