package GOIT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GET_Username {
    public static void main(String[] args) {
        String x = "Antonette";
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/users?username=" + x);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "MyJavaApp");
            conn.setRequestProperty("Content-Type" , "application/json; charset=UTF-8");

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {

                try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    String line;
                    while ((line = in.readLine()) != null) {
                        System.out.println(line);
                    }
                }

            }

        } catch (Exception e) {
            System.out.println("Exceptionnn - " + e.getMessage());
        }
    }
}
