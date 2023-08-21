import java.util.Objects;

public class Response<T> {
    private int statusCode;
    public T json;

    public void setJson(T json) {
        this.json = json;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response<?> response = (Response<?>) o;
        return statusCode == response.statusCode && Objects.equals(json, response.json);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusCode, json);
    }
}
