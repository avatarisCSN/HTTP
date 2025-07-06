package org.example;

/*
GET / HTTP/1.1
Host: example.com
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GET2 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.google.com/search?q=java+http"); // Указываем URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // Открываем соединение
            connection.setRequestMethod("GET"); // Указываем метод запроса

            int responseCode = connection.getResponseCode();  // Получаем код ответа
            System.out.println("Response Code: " + responseCode);

            // Читаем тело ответа, если всё ок (код 200)
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()) );

                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine); }

                in.close();

                System.out.println("Response:\n" + response.toString()); // Выводим результат
            } else {
                System.out.println("GET-запрос не удался"); }

            connection.disconnect(); // Закрываем соединение


        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage());
        }
    }
}
