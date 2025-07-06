package org.example;

import java.net.HttpURLConnection;
import java.net.URL;

public class GET10 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {

            }

        } catch(Exception e) {
            System.out.println(e.getMessage() + "Exception");
        }
    }
}
