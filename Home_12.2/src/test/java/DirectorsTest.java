import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.sql.Date;
import java.time.LocalDate;

public class DirectorsTest {
    @Test
    void getByID() {
        DirectorRepositoryImpl impl = new DirectorRepositoryImpl();
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

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
