import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DirectorRepositoryImpl implements DirectorRepository {
    private Connection connection;

    public DirectorRepositoryImpl() {
        try {
            this.connection = ConnectBD.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Director get(int id) {
        String sqlSelect = "Select * from DIRECTORS where id = ?";
        Director gendir = new Director();
        {
            try (PreparedStatement statement = connection.prepareStatement(sqlSelect)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        gendir.setId(resultSet.getInt(1));
                        gendir.setFirstName(resultSet.getString(2));
                        gendir.setLastName(resultSet.getString(3));
                        gendir.setBirthdate(resultSet.getDate(4));
                        gendir.setCountry(resultSet.getString(5));
                    } else {
                        throw new NoSuchElementException("Запись с указанным id не найдена");
                    }

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return gendir;
    }

    @Override
    public void save(Director director) {
        String sqlInsert = "INSERT into directors values (?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sqlInsert)) {
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
        String sqlDelete = "delete from directors where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sqlDelete)) {
            statement.setInt(1, director.getId());
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

    @Override
    public List<Director> get(List<String> genres) {
        int count = 1;
        List<Director> listDirectors = new ArrayList<>();
        String str = "?" +
                ",?".repeat(genres.size() - 1);
        String sqlList = "Select * from directors d join movies m on d.id=m.director where genre in (" + str + ");";
        try (PreparedStatement statement = connection.prepareStatement(sqlList)) {
            for (int i = 0; i < genres.size(); i++) {
                statement.setString(count, genres.get(i));
                count++;
            }
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Director dir = new Director();
                    dir.setId(resultSet.getInt(1));
                    dir.setFirstName(resultSet.getString(2));
                    dir.setLastName(resultSet.getString(3));
                    dir.setBirthdate(resultSet.getDate(4));
                    dir.setCountry(resultSet.getString(5));
                    listDirectors.add(dir);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (listDirectors.size() > 0) {
            return listDirectors;
        } else {
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                System.out.println("Empty list");
                throw new RuntimeException(e);
            }
        }


    }
}
