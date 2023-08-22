package bd;

import java.util.List;

public interface MovieRepository {
    Movie get(int id);

    void save(Movie movie);

    void delete(Movie movie);

    List get(Director d);
}
