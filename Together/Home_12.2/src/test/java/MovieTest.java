import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MovieTest {
    private static final Logger logger= LogManager.getLogger(DirectorsTest.class);
    SetUpBD setUpBD = new SetUpBD();
    DirectorRepositoryImpl impl = setUpBD.getImpl();
    MovieRepositoryImpl movieImpl= setUpBD.getMovieRepository();


    @BeforeAll
    public static void createBD() {
        logger.info("BD Movie TEST BEGUN");
        ConnectBD.createTableDirectors();
        ConnectBD.createTableMovies();
    }
    @BeforeEach
    void saveData() {
        setUpBD.safeDataMovie();
        logger.debug("Сохранено");
    }

    @Test
    @Epic(value = "Movie")
    @Feature(value = "Получение")
    @Story(value = "Однаштуковая")
    @DisplayName("ПОЛУЧИТЬ ID")
    void getByID() {
        logger.debug("----Step start here----");
        Movie movie = setUpBD.getMovie();
        Movie movieAct=movieImpl.get(2);
        logger.debug("Test {} {}",movieAct,movie);
        Assertions.assertEquals(movie, movieAct);
    }

    @Test
    @Epic(value = "Movie")
    @Feature(value = "Действие")
    @Story(value = "Сохранение")
    @DisplayName("Провеверить сохранялку")
    void checkSave() {
        logger.debug("----Step start here----");
        Movie movie = setUpBD.getMovie();
        Movie movieAct=movieImpl.get(movie.getId());
        logger.debug("Test {} {}",movieAct,movie);
        Assertions.assertEquals(movie, movieAct);
    }

    @Test
    @Epic(value = "Movie")
    @Feature(value = "Действие")
    @Story(value = "Удаление")
    @DisplayName("Провеверить удалялку")
    void checkDelete() {
        logger.debug("----Step start here----");
        Movie movie = setUpBD.getMovie();
        int idMovieAct= movie.getId();
        logger.debug("Test {}",movie);
        movieImpl.delete(movie);
        Assertions.assertThrows(NoSuchElementException.class, () ->movieImpl.get(idMovieAct));
    }

    @Test
    @Epic(value = "Movie")
    @DisplayName("Провеверить список")
    @Story(value = "Получение")
    @Feature(value = "Много за раз")
    void checkList() {
        logger.debug("----Step start here----");
        List<Movie> movList = new ArrayList<>();
        movList.add(movieImpl.get(1));
        movList.add(movieImpl.get(13));
        List<Movie> movListAct = movieImpl.get(impl.get(2));
        logger.debug("Test {} {}",movListAct,movList);
        Assertions.assertTrue(movList.containsAll(movListAct));
    }
    @AfterEach
    void clearData() {
        setUpBD.deleteDataMovie();
        System.out.println("Очистка");
    }
}
