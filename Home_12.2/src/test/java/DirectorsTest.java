import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.NoSuchElementException;

public class DirectorsTest {
    SetUp setUp = new SetUp();
    DirectorRepositoryImpl impl = setUp.getImpl();


    @BeforeAll
    public static void createBD() {
        ConnectBD.createTableDirectors();
        ConnectBD.createTableMovies();
    }

    @BeforeEach
    void saveData() {
        setUp.safeDataDirector();
        System.out.println("Сохранение");
    }


    @Test
    @Epic(value = "Director")
    @Feature(value = "Получение")
    @Story(value = "Однаштуковая")
    @DisplayName("ПОЛУЧИТЬ ID")
    void getByID() {
        Director dir = setUp.getDir();
        Director dirAct = impl.get(4);
        Assertions.assertEquals(dir, dirAct);
    }

    @Test
    @Epic(value = "Director")
    @Feature(value = "Действие")
    @Story(value = "Сохранение")
    @DisplayName("Провеверить сохранялку")
    void checkSave() {
        Director dir = setUp.getDir();
        Director dirAct = impl.get(dir.getId());
        Assertions.assertEquals(dir, dirAct);
    }


    @Test
    @Epic(value = "Director")
    @Feature(value = "Действие")
    @Story(value = "Удаление")
    @DisplayName("Провеверить удалялку")
    void checkDelete() {
        Director dir = setUp.getDir();
        int dirActId = dir.getId();
        setUp.getImpl().delete(dir);
        Assertions.assertThrows(NoSuchElementException.class, () -> impl.get(dirActId));
    }

    @Test
    @Epic(value = "Director")
    @DisplayName("Провеверить список")
    @Story(value = "Получение")
    @Feature(value = "Много за раз")
    void checkList() {
        List<String> genraa = List.of("Horror", "Fantasy", "Fart");
        List<Director> expList = List.of(impl.get(2));
        Assertions.assertTrue(expList.containsAll(impl.get(genraa)));
    }

    @AfterEach
    void clearData() {
        setUp.deleteDataDirector();
        System.out.println("Очистка");
    }
}
