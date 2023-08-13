import org.json.JSONException;

public class Token {

    public String getToken(Response resp){
        String tokenCredit;
        try {
            tokenCredit =resp.json.getString("token");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return tokenCredit;
    }
}
