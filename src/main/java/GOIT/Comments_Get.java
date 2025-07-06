package GOIT;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class Comments_Get {
    public static void main(String [] args) {

        try {



            URL url = new URL("https://jsonplaceholder.typicode.com/posts/10/comments");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "MyJavaApp");
            conn.setRequestProperty("Content-Type" , "application/json; charset=UTF-8");

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {

                try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                     FileWriter output = new FileWriter("src/main/resources/user-" + Comments_Helper.getName() + "-post-10-comments.json")) {
                    String line;
                    StringBuilder builder = new StringBuilder();
                    while ((line = in.readLine()) != null) {
                        output.write(line);
                        System.out.println(line);
                    }

                }

            }
        } catch (Exception e) {
            System.out.println("Exceptionnn - " + e.getMessage());
        }

    }
}
