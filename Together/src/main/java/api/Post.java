package api;

import java.util.Objects;

public class Post {
    private int id;
    private String title;
    private Object userId;

    public Post(int id, String title, Object userId) {
        this.id = id;
        this.title = title;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "api.Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id && Objects.equals(title, post.title) && Objects.equals(userId, post.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, userId);
    }
}
