import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

public class DirectorsTest {
    DirectorRepositoryImpl impl = new DirectorRepositoryImpl();

    @BeforeAll
    public static void createBD() {
        ConnectBD.createTableDirectors();
        ConnectBD.createTableMovies();
    }


    public Director getExpected(int id, String first, String last, String date, String country) {
        Director director = new Director();
        director.setId(id);
        director.setFirstName(first);
        director.setLastName(last);
        director.setBirthdate(Date.valueOf(LocalDate.parse(date)));
        director.setCountry(country);
        return director;
    }

    @Test
    void getByID() {
        Director dir = getExpected(2, "Vasya", "Pupkin", "2022-07-29", "Polska");
        Assertions.assertEquals(dir, impl.get(2));
    }

    @Test
    void checkSave() {
        Director dir = getExpected(82, "CheckSave", "Lit", "2022-07-29", "SD");
        impl.save(dir);
        Assertions.assertEquals(dir, impl.get(dir.getId()));
        impl.delete(dir);

    }

    @Test
    void checkDelete() {
        Director dir = getExpected(82, "CheckSave", "Lit", "2022-07-29", "SD");
        impl.save(dir);
        impl.delete(dir);
        Assertions.assertThrows(NoSuchElementException.class, () -> impl.get(dir.getId()));
    }

    @Test
    void checkList() {
        List<String> genraa = List.of("Horror", "Fantasy", "Fart");
        List<Director> expList = List.of(impl.get(2));
        Assertions.assertTrue(expList.containsAll(impl.get(genraa)));
    }
}
