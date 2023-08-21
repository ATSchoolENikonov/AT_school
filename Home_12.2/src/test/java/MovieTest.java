import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MovieTest {
    SetUp setUp = new SetUp();
    DirectorRepositoryImpl impl = setUp.getImpl();
    MovieRepositoryImpl movieImpl=setUp.getMovieRepository();

    @BeforeAll
    public static void createBD() {
        ConnectBD.createTableDirectors();
        ConnectBD.createTableMovies();
    }
    @BeforeEach
    void saveData() {
        setUp.safeDataMovie();
        System.out.println("Сохранение");
    }

    @Test
    void getByID() {
        Movie movie = setUp.getMovie();
        Movie movieAct=movieImpl.get(2);
        Assertions.assertEquals(movie, movieAct);
    }

    @Test
    void checkSave() {
        Movie movie = setUp.getMovie();
        Movie movieAct=movieImpl.get(movie.getId());
        Assertions.assertEquals(movie, movieAct);
    }

    @Test
    void checkDelete() {
        Movie movie = setUp.getMovie();
        int idMovieAct= movie.getId();
        movieImpl.delete(movie);
        Assertions.assertThrows(NoSuchElementException.class, () ->movieImpl.get(idMovieAct));
    }

    @Test
    void checkList() {
        List<Movie> movList = new ArrayList<>();
        movList.add(movieImpl.get(1));
        movList.add(movieImpl.get(13));
        List<Movie> movListAct = movieImpl.get(impl.get(2));
        Assertions.assertTrue(movList.containsAll(movListAct));
    }
    @AfterEach
    void clearData() {
        setUp.deleteDataMovie();
        System.out.println("Очистка");
    }
}
