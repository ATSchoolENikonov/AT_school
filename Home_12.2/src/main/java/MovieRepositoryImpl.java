import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MovieRepositoryImpl implements MovieRepository {
    private static final Logger logger= LogManager.getLogger(MovieRepositoryImpl.class);
    private Connection connection;

    public MovieRepositoryImpl() {
        connection = DirectorRepositoryImpl.getConnection();
    }

    @Override
    public Movie get(int id) {
        String sqlSelect = "Select * from MOVIES where id = ?";
        Movie movie = new Movie();
        {
            try (PreparedStatement statement = connection.prepareStatement(sqlSelect)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        movie.setId(resultSet.getInt("id"));
                        movie.setTitle(resultSet.getString("title"));
                        movie.setGenre(resultSet.getString("genre"));
                        movie.setRelease(resultSet.getDate("release"));
                        movie.setDirector(resultSet.getInt("director"));
                    } else {
                        throw new NoSuchElementException("Запись с указанным id не найдена");
                    }
                }
            } catch (SQLException e) {
                logger.error(e.getMessage(),e);
                throw new RuntimeException(e);
            }
        }
        return movie;
    }

    @Override
    public void save(Movie movie) {
        String sqlInsert = "INSERT into MOVIES values (?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sqlInsert)) {
            statement.setInt(1, movie.getId());
            statement.setString(2, movie.getTitle());
            statement.setString(3, movie.getGenre());
            statement.setDate(4, movie.getRelease());
            statement.setInt(5, movie.getDirector());
            statement.executeUpdate();
            int count = statement.getUpdateCount();
            System.out.println("Кол-во измененных строк = " + count);
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Movie movie) {
        String sqlDelete = "delete from MOVIES where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sqlDelete)) {
            statement.setInt(1, movie.getId());
            statement.executeUpdate();
            int count = statement.getUpdateCount();
            if (count > 0) {
                System.out.println("Кол-во удаленных строк = " + count);
            } else {
                System.out.println("Запись с указанным id не найдена");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Movie> get(Director d) {
        String getList = "Select * from movies where director = ?";
        List<Movie> genspisok = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(getList)) {
            statement.setInt(1, d.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Movie mov = new Movie();
                mov.setId(resultSet.getInt("id"));
                mov.setTitle(resultSet.getString("title"));
                mov.setGenre(resultSet.getString("genre"));
                mov.setRelease(resultSet.getDate("release"));
                mov.setDirector(resultSet.getInt("director"));
                genspisok.add(mov);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
            throw new RuntimeException(e);
        }
        return genspisok;
    }

}
