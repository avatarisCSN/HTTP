package GOIT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class Comments_Helper {
    public static String getName() {
        String result = "";
        try {

            JSONObject json;

            URL url = new URL("https://jsonplaceholder.typicode.com/users/1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "MyJavaApp");
            conn.setRequestProperty("Content-Type" , "application/json; charset=UTF-8");

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {

                try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));) {
                    String line;
                    StringBuilder builder = new StringBuilder();
                    while ((line = in.readLine()) != null) {
                        builder.append(line);
                        System.out.println(line);
                    }
                    json = new JSONObject(builder.toString());
                    result = json.getString("name");
                    System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA");
                    System.out.println(result);
                }

            }
        } catch (Exception e) {
            System.out.println("Exceptionnn - " + e.getMessage());
        }
        return result;
    }
}
