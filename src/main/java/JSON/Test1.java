package JSON;

import GOIT.User;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

public class Test1 {
    public static void main(String[] args) {
        String Str2 = """
  {
  "name": "Denis",
  "address": {
    "city": "Kyiv",
    "zipcode": "01001"
  }
}
""";
        String jsonStr = "{\"name\":\"Denis\", \"age\":25}";

        JSONObject json = new JSONObject(jsonStr);
        String name = json.getString("name");
        int age = json.getInt("age");// org
        System.out.println(name + " " +age);

        JSONObject json2 = new JSONObject();
        json2.put("name", "Denis");
        json2.put("age", 25);


        JSONObject json3 = new JSONObject(Str2);
        System.out.println("HOLAAAAAAAA");
        System.out.println(json3.get("address"));
        JSONArray array = new JSONArray("[\n" +
                "  {\n" +
                "    \"city\": \"Kyiv\",\n" +
                "    \"zipcode\": \"01001\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"city\": \"Lviv\",\n" +
                "    \"zipcode\": \"79000\"\n" +
                "  }\n" +
                "]");
        JSONObject address = new JSONObject("""
  {
    "city": "Kyiv",
    "zipcode": "01001"
}
""");
        System.out.println(array);
        JSONObject objArray = new JSONObject();
        objArray.put("array:", array);
        System.out.println("We have a new array with name  ----- " + objArray);
        System.out.println("We have a new array with name  -----222222 " + objArray.toString(2));

        System.out.println(address);

        System.out.println(json3.toString(1));
        System.out.println(json3.toString(2));
        System.out.println(json3.toString(3));
        System.out.println(json3.toString(4));
        JSONObject addressObj = json3.getJSONObject("address");

        String city = addressObj.getString("city");

        System.out.println(city); // Kyiv

    }
}
