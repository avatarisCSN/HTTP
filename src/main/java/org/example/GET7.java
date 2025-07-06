package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GET7 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://api.openweathermap.org//data/2.5/weather?q=London&units=metric&appid=YOUR_API_KEY");
            HttpURLConnection conn =  (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");


            int resp = conn.getResponseCode();
            System.out.println(resp);

            if(resp == HttpURLConnection.HTTP_UNAUTHORIZED) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                while((line = reader.readLine()) != null) {
                    System.out.println(line);

                }
                reader.close();
            }
        } catch (Exception e ) {
            System.out.println(e.getMessage() + "hello");
        }

    }
}
