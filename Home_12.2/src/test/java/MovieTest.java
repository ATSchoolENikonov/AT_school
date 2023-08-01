import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MovieTest {
    DirectorRepositoryImpl impl = new DirectorRepositoryImpl();
    MovieRepositoryImpl movieRepository = new MovieRepositoryImpl();

    @BeforeAll
    public static void createBD() {
        ConnectBD.createTableDirectors();
        ConnectBD.createTableMovies();
    }

    public Movie getExpected(int id, String title, String genre, String release, int director) {
        Movie movie = new Movie();
        movie.setId(id);
        movie.setTitle(title);
        movie.setGenre(genre);
        movie.setRelease(Date.valueOf(LocalDate.parse(release)));
        movie.setDirector(director);
        return movie;
    }

    @Test
    void getByID() {
        Movie movie = getExpected(1, "Lore", "Fantasy", "2022-05-29", 2);
        Assertions.assertEquals(movie, movieRepository.get(1));
    }

    @Test
    void checkSave() {
        Movie movie = getExpected(17, "Tech", "Comedy", "2022-03-26", 6);
        movieRepository.save(movie);
        Assertions.assertEquals(movie, movieRepository.get(movie.getId()));
        movieRepository.delete(movie);

    }

    @Test
    void checkDelete() {
        Movie movie = getExpected(17, "Tech", "Comedy", "2022-03-26", 6);
        movieRepository.save(movie);
        movieRepository.delete(movie);
        Assertions.assertThrows(NoSuchElementException.class, () -> impl.get(movie.getId()));
    }

    @Test
    void checkList() {
        List<Movie> movList = new ArrayList<>();
        movList.add(movieRepository.get(1));
        movList.add(movieRepository.get(13));
        Assertions.assertTrue(movList.containsAll(movieRepository.get(impl.get(2))));
    }
}
