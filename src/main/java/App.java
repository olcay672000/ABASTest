import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException
    {
        AbasOrderTest.run();

        AbasApiTest.runForGetResponse();
        AbasApiTest.runForPostRequest();

    }
}
