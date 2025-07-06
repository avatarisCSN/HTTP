package GOIT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;

public class POST {
    public static void main(String[] args) {
        try {
            User wrapper = new User();
            User user = wrapper.defaultt();
            Gson gson = new Gson();

            String json = gson.toJson(user);

            URL url = new URL("https://jsonplaceholder.typicode.com/users");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type" , "application/json; charset=UTF-8");
            conn.setRequestProperty("User-Agent" , "MyJavaApp");



            // String json = gson.toJson(new Post("Updated Title", "Updated Body", 1));

            try ( OutputStream os = conn.getOutputStream() )  {
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
                // os.write(input);
                // os.write(json.getBytes("utf-8"));
            }

            int responseCode = conn.getResponseCode();
            System.out.println("PUT Response Code: " + responseCode);

            try (BufferedReader in = new BufferedReader( new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                String line;
                while (( line = in.readLine() ) != null) {
                    System.out.println(line);
                }
            }


        } catch(Exception e) {
            System.out.println(e.getMessage() + "Exception");
        }
    }
}
