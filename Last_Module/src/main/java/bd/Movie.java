package bd;

import java.sql.Date;
import java.util.Objects;

public class Movie {
    private int id;
    private String title;
    private String genre;
    private Date release;
    private int director;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public int getDirector() {
        return director;
    }

    public void setDirector(int director) {
        this.director = director;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && director == movie.director && Objects.equals(title, movie.title) && Objects.equals(genre, movie.genre) && Objects.equals(release, movie.release);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, genre, release, director);
    }

    @Override
    public String toString() {
        return "bd.Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", release=" + release +
                ", director=" + director +
                '}';
    }
}
