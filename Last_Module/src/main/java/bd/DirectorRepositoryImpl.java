package bd;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DirectorRepositoryImpl implements DirectorRepository {
    private static final Logger logger= LogManager.getLogger(DirectorRepositoryImpl.class);

    private static Connection connection;

    public static Connection getConnection() {
        return connection;
    }

    public DirectorRepositoryImpl() {
        try {
            connection = ConnectBD.getConnection();
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @Step("Получение записи по айди")
    public Director get(int id) {
        logger.info("Начало поиска директора по айди");
        String sqlSelect = "Select * from DIRECTORS where id = ?";
        Director gendir = new Director();
        {
            try (PreparedStatement statement = connection.prepareStatement(sqlSelect)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        gendir.setId(resultSet.getInt("id"));
                        gendir.setFirstName(resultSet.getString("first_name"));
                        gendir.setLastName(resultSet.getString("last_name"));
                        gendir.setBirthdate(resultSet.getDate("birth_date"));
                        gendir.setCountry(resultSet.getString("country"));
                    } else {
                        logger.error("Запись с указанным id не найдена");
                        throw new NoSuchElementException();
                    }

                }
            } catch (SQLException e) {
                logger.error(e.getMessage(),e);
                throw new RuntimeException(e);
            }

        }
        logger.info("Поиск директора завершен");
        return gendir;
    }

    @Override
    @Step("Сохранение записи")
    public void save(Director director) {
        logger.info("Начало добавления записи в таблицу");
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
            logger.error(e.getMessage(),e);
            throw new RuntimeException(e);
        }
        logger.info("Добавление записи в таблицу завершено");
    }

    @Override
    @Step("Удаление записи")
    public void delete(Director director) {
        logger.info("Начало удаления записи из таблицы");
        String sqlDelete = "delete from directors where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sqlDelete)) {
            statement.setInt(1, director.getId());
            statement.executeUpdate();
            int count = statement.getUpdateCount();
            if (count > 0) {
                System.out.println("Кол-во удаленных строк = " + count);
            } else {
                logger.error("Запись с указанным id не найдена");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
            throw new RuntimeException(e);
        }
        logger.info("Удаление записи из таблицы завершено");
    }

    @Override
    @Step("Поиск списка директоров")
    public List<Director> get(List<String> genres) {
        logger.info("Начало поиска списка директоров");
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
                    dir.setId(resultSet.getInt("id"));
                    dir.setFirstName(resultSet.getString("first_name"));
                    dir.setLastName(resultSet.getString("last_name"));
                    dir.setBirthdate(resultSet.getDate("birth_date"));
                    dir.setCountry(resultSet.getString("country"));
                    listDirectors.add(dir);
                }
            } catch (SQLException e) {
                logger.error(e.getMessage(),e);
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
            throw new RuntimeException(e);
        }
        if (listDirectors.size() > 0) {
            return listDirectors;
        } else {
            logger.error("Empty list");
            try {
                throw new RuntimeException();
            } catch (RuntimeException e) {
                logger.error(e.getMessage(),e);
            }

        }
        logger.info("Поиск списка директоров завершен");
        return listDirectors;
    }
}
