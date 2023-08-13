import org.json.JSONException;
import org.json.JSONObject;

public class SetUp {

    public Response getExpectedUser() {
        Response response = new Response();
        response.setStatusCode(200);
        String json1 = "{\"lastName\":\"Medhurst\",\"gender\":\"male\",\"university\":\"Capitol University\",\"maidenName\":\"Smitham\",\"ein\":\"20-9487066\",\"ssn\":\"661-64-2976\",\"bloodGroup\":\"A\u2212\",\"password\":\"9uQFF1Lh\",\"hair\":{\"color\":\"Black\",\"type\":\"Strands\"},\"bank\":{\"iban\":\"NO17 0695 2754 967\",\"cardExpire\":\"06\\/22\",\"cardType\":\"maestro\",\"currency\":\"Peso\",\"cardNumber\":\"50380955204220685\"},\"eyeColor\":\"Green\",\"company\":{\"address\":{\"address\":\"629 Debbie Drive\",\"city\":\"Nashville\",\"postalCode\":\"37076\",\"coordinates\":{\"lng\":-86.58621199999999,\"lat\":36.208114},\"state\":\"TN\"},\"name\":\"Blanda-O'Keefe\",\"department\":\"Marketing\",\"title\":\"Help Desk Operator\"},\"id\":1,\"email\":\"atuny0@sohu.com\",\"height\":189,\"image\":\"https:\\/\\/robohash.org\\/hicveldicta.png\",\"address\":{\"address\":\"1745 T Street Southeast\",\"city\":\"Washington\",\"postalCode\":\"20020\",\"coordinates\":{\"lng\":-76.979235,\"lat\":38.867033},\"state\":\"DC\"},\"ip\":\"117.29.86.254\",\"weight\":75.4,\"userAgent\":\"Mozilla\\/5.0 (Windows NT 6.1) AppleWebKit\\/534.24 (KHTML, like Gecko) Chrome\\/12.0.702.0 Safari\\/534.24\",\"birthDate\":\"2000-12-25\",\"firstName\":\"Terry\",\"macAddress\":\"13:69:BA:56:A3:74\",\"phone\":\"+63 791 675 8914\",\"domain\":\"slashdot.org\",\"age\":50,\"username\":\"atuny0\"}}";
        try {
            response.setJson(new JSONObject(json1));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return response;
    }
}
