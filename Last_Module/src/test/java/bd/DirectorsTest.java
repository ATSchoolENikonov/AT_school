package bd;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.NoSuchElementException;

public class DirectorsTest {
    private static final Logger logger= LogManager.getLogger(DirectorsTest.class);
    SetUpBD setUpBD=new SetUpBD();
    DirectorRepositoryImpl impl = setUpBD.getImpl();


    @BeforeAll
    public static void createBD() {
        logger.info("BD bd.Director TEST BEGUN");
        ConnectBD.createTableDirectors();
        ConnectBD.createTableMovies();
    }

    @BeforeEach
    void saveData() {
        setUpBD.safeDataDirector();
        logger.debug("Сохранено");
    }


    @Test
    @Epic(value = "bd.Director")
    @Feature(value = "Получение")
    @Story(value = "Однаштуковая")
    @DisplayName("ПОЛУЧИТЬ ID")
    void getByID() {
        logger.info("Начало теста по полчению записи по айди");
        Director dir = setUpBD.getDir();
        Director dirAct = impl.get(4);
        logger.debug("Test {} {}",dirAct,dir);
        Assertions.assertEquals(dir, dirAct);
    }

    @Test
    @Epic(value = "bd.Director")
    @Feature(value = "Действие")
    @Story(value = "Сохранение")
    @DisplayName("Провеверить сохранялку")
    void checkSave() {
        logger.info("Начало теста по сохранению");
        Director dir = setUpBD.getDir();
        Director dirAct = impl.get(dir.getId());
        logger.debug("Test {} {}",dirAct,dir);
        Assertions.assertEquals(dir, dirAct);
    }


    @Test
    @Epic(value = "bd.Director")
    @Feature(value = "Действие")
    @Story(value = "Удаление")
    @DisplayName("Провеверить удалялку")
    void checkDelete() {
        logger.info("Начало теста по удалению");
        Director dir = setUpBD.getDir();
        int dirActId = dir.getId();
        logger.debug(" Test {} ",dir);
        setUpBD.getImpl().delete(dir);
        Assertions.assertThrows(NoSuchElementException.class, () -> impl.get(dirActId));
    }

    @Test
    @Epic(value = "bd.Director")
    @DisplayName("Провеверить список")
    @Story(value = "Получение")
    @Feature(value = "Много за раз")
    void checkList() {
        logger.info("Начало теста по проверке листа");
        List<String> genraa = List.of("Horror", "Fantasy", "Fart");
        List<Director> expList = List.of(impl.get(2));
        logger.debug("Test {} {}",genraa,expList);
        Assertions.assertTrue(expList.containsAll(impl.get(genraa)));
    }

    @AfterEach
    void clearData() {
        setUpBD.deleteDataDirector();
        logger.info("Очитска данных после тестов");
    }
}
