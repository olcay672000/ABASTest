import netscape.javascript.JSObject;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AbasApiTest {

    public static void runForGetResponse()
    {

        String url = "https://catfact.ninja/fact";

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("GET Request");
            JSONObject jo = new JSONObject(response.body());
            System.out.printf("Cevap Kodu : %d\n", response.statusCode());
            System.out.printf("Gerçek : %s \nUzunluk : %d", jo.get("fact"), jo.get("length"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void runForPostRequest()
    {
        String url = "https://reqres.in/api/users";

        JSONObject data = new JSONObject();
        data.put("name", "Olcay Çetin");
        data.put("job", "Java Developer");

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(data.toString()))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jo = new JSONObject(response.body());
            System.out.printf("Cevap Kodu : %d\n", response.statusCode());
            System.out.printf("Ad-Soyad : %s \nİş : %s\nID : %s\nZaman : %s", jo.get("name"), jo.get("job"), jo.get("id"), jo.get("createdAt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
