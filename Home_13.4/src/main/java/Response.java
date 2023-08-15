import org.json.JSONObject;

public class Response<T> {
    private int statusCode;
    public JSONObject json;

    public JSONObject getJson() {
        return json;
    }

    public void setJson(JSONObject json) {
        this.json = json;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }


    @Override
    public String toString() {
        return "Response{" +
                "statusCode=" + statusCode +
                ", json=" + json +
                '}';
    }

}
