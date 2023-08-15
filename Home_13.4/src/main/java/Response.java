import org.json.JSONObject;

public class Response<T> {
    private int statusCode;
    public T json;

    public T getJson() {
        return json;
    }


    public void setJson(T json) {
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
