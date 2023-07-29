import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.sql.Date;
import java.time.LocalDate;
import java.util.NoSuchElementException;

public class DirectorsTest {
    DirectorRepositoryImpl impl = new DirectorRepositoryImpl();

    @Test
    void getByID() {
        Director dir = getExpected(7, "Vasya222", "Pupkin", "2023-07-26", "rus");
        Assertions.assertEquals(dir, impl.get(7));
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
    void checkSaveDelete() {
        Director dir = getExpected(82, "CheckSave", "Lit", "2022-07-29", "SD");
        impl.save(dir);
        Assertions.assertEquals(dir, impl.get(dir.getId()));
        impl.delete(dir);
        Assertions.assertThrows(NoSuchElementException.class, () -> impl.get(dir.getId()));
    }
}
