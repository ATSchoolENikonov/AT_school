import java.sql.*;
import java.util.NoSuchElementException;

public class DirectorRepositoryImpl implements DirectorRepository {
    private Connection connection;
    private Director gendir = new Director();

    public DirectorRepositoryImpl() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "Polgen366");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Director get(int id) {
        {
            try {
                PreparedStatement statement = connection.prepareStatement("Select * from directors where id ='" + id + "';");
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    gendir.setId(resultSet.getInt(1));
                    gendir.setFirstName(resultSet.getString(2));
                    gendir.setLastName(resultSet.getString(3));
                    gendir.setBirthdate(resultSet.getDate(4));
                    gendir.setCountry(resultSet.getString(5));
                } else {
                    throw new NoSuchElementException("Запись с указанным id не найдена");
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return gendir;
    }

    @Override
    public void save(Director director) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT into directors values (?,?,?,?,?)");
            statement.setInt(1, director.getId());
            statement.setString(2, director.getFirstName());
            statement.setString(3, director.getLastName());
            statement.setDate(4, director.getBirthdate());
            statement.setString(5, director.getCountry());
            statement.executeUpdate();
            int count = statement.getUpdateCount();
            System.out.println("Кол-во измененных строк = " + count);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Director director) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from directors where id ='" + director.getId() + "';");
            statement.executeUpdate();
            int count = statement.getUpdateCount();
            if (count > 0) {
                System.out.println("Кол-во удаленных строк = " + count);
            } else {
                System.out.println("Запись с указанным id не найдена");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
