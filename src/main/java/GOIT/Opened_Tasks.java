package GOIT;



import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class Opened_Tasks {
    public static void main(String [] args) {
        try {

            URL url = new URL("https://jsonplaceholder.typicode.com/users/1/todos");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "MyJavaApp");
            conn.setRequestProperty("Content-Type" , "application/json; charset=UTF-8");

            int responseCode = conn.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                StringBuilder builder = new StringBuilder();
                try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    String line;

                    while ((line = in.readLine()) != null) {
                        builder.append(line);
                        System.out.println(line);
                    }
                }
                JSONArray array = new JSONArray(builder.toString());

                for (int i = 0; i < array.length(); i++) {
                    JSONObject obj = array.getJSONObject(i);
                    if (obj.getBoolean("completed") == false) {
                        System.out.println(obj);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Exceptionnn - " + e.getMessage());
        }

    }
}
