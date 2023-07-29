import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MovieRepositoryImpl implements MovieRepository {
    private Connection connection;

    public MovieRepositoryImpl() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "Polgen366");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Movie get(int id) {
        Movie movie = new Movie();
        {
            try {
                PreparedStatement statement = connection.prepareStatement("Select * from movies where id ='" + id + "';");
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    movie.setId(resultSet.getInt(1));
                    movie.setTitle(resultSet.getString(2));
                    movie.setGenre(resultSet.getString(3));
                    movie.setRelease(resultSet.getDate(4));
                    movie.setDirector(resultSet.getInt(5));
                } else {
                    throw new NoSuchElementException("Запись с указанным id не найдена");
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return movie;
    }

    @Override
    public void save(Movie movie) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT into movies values (?,?,?,?,?)");
            statement.setInt(1, movie.getId());
            statement.setString(2, movie.getTitle());
            statement.setString(3, movie.getGenre());
            statement.setDate(4, movie.getRelease());
            statement.setInt(5, movie.getDirector());
            statement.executeUpdate();
            int count = statement.getUpdateCount();
            System.out.println("Кол-во измененных строк = " + count);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Movie movie) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from movies where id ='" + movie.getId() + "';");
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
    public List<Movie> get(Director d) {
        List<Movie> genspisok = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("Select * from movies where director ='" + d.getId() + "';");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Movie mov = new Movie();
                mov.setId(resultSet.getInt(1));
                mov.setTitle(resultSet.getString(2));
                mov.setGenre(resultSet.getString(3));
                mov.setRelease(resultSet.getDate(4));
                mov.setDirector(resultSet.getInt(5));
                genspisok.add(mov);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return genspisok;
    }

}
