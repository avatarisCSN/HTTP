package GOIT;

import java.net.HttpURLConnection;
import java.net.URL;

public class DELETE {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/users/1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");

            int responseCode = conn.getResponseCode();
            System.out.println("DELETE Response Code: " + responseCode);

        } catch (Exception e) {
            System.out.println("Exceptionnn - " + e.getMessage());
        }
    }
}
