import java.sql.Date;
import java.util.Objects;

public class Director {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthdate;
    private String country;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return id == director.id && Objects.equals(firstName, director.firstName) && Objects.equals(lastName, director.lastName) && Objects.equals(birthdate, director.birthdate) && Objects.equals(country, director.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthdate, country);
    }
}
