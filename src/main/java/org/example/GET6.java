package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GET6 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.youtube.com/results?search_query=funny+cats");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode  = conn.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder answer = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    answer.append(line);
                }
                reader.close();
                System.out.println(answer.toString());
            }
        } catch (Exception e) {
            System.out.println("Exception "+ e.getMessage());
        }


    }
}
