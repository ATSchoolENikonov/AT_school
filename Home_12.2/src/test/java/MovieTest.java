import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
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
    @Epic(value = "Movie")
    @Feature(value = "Получение")
    @Story(value = "Однаштуковая")
    @DisplayName("ПОЛУЧИТЬ ID")
    void getByID() {
        Movie movie = setUp.getMovie();
        Movie movieAct=movieImpl.get(2);
        Assertions.assertEquals(movie, movieAct);
    }

    @Test
    @Epic(value = "Movie")
    @Feature(value = "Действие")
    @Story(value = "Сохранение")
    @DisplayName("Провеверить сохранялку")
    void checkSave() {
        Movie movie = setUp.getMovie();
        Movie movieAct=movieImpl.get(movie.getId());
        Assertions.assertEquals(movie, movieAct);
    }

    @Test
    @Epic(value = "Movie")
    @Feature(value = "Действие")
    @Story(value = "Удаление")
    @DisplayName("Провеверить удалялку")
    void checkDelete() {
        Movie movie = setUp.getMovie();
        int idMovieAct= movie.getId();
        movieImpl.delete(movie);
        Assertions.assertThrows(NoSuchElementException.class, () ->movieImpl.get(idMovieAct));
    }

    @Test
    @Epic(value = "Movie")
    @DisplayName("Провеверить список")
    @Story(value = "Получение")
    @Feature(value = "Много за раз")
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
