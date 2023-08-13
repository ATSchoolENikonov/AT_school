import org.json.JSONException;

public class User {
    public long getId() {
        return id;
    }

    private long id;
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public User getDataUser(Response resp) {
        User customUser = new User();
        try {
            customUser.id =resp.json.getLong("id");
            customUser.login = resp.json.getString("username");
            customUser.password = resp.json.getString("password");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return customUser;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
