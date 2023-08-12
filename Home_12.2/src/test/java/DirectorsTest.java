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
    void getByID() {
        Director dir = setUp.getDir();
        Director dirAct = impl.get(4);
        Assertions.assertEquals(dir, dirAct);
    }

    @Test
    void checkSave() {
        Director dir = setUp.getDir();
        Director dirAct = impl.get(dir.getId());
        Assertions.assertEquals(dir, dirAct);
    }


    @Test
    void checkDelete() {
        Director dir = setUp.getDir();
        int dirActId = dir.getId();
        setUp.getImpl().delete(dir);
        Assertions.assertThrows(NoSuchElementException.class, () -> impl.get(dirActId));
    }

    @Test
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
