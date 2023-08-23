package bd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class ConnectBD {
    private static final Logger logger= LogManager.getLogger(ConnectBD.class);

    public static Connection getConnection() throws RuntimeException, SQLException {
        String jdbcURL = "jdbc:h2:mem:test";
        Connection connection = DriverManager.getConnection(jdbcURL);
        logger.debug("Connected to the DB " + connection);
        return connection;
    }

    public static void createTableDirectors() {
        logger.debug("Creating table with Directors...");
        String createTables = "CREATE TABLE DIRECTORS " +
                "(id INTEGER not NULL, " +
                " first_name VARCHAR(255), " +
                " last_name  VARCHAR(255), " +
                " birth_date   DATE, " +
                " country   VARCHAR(255), " +
                " PRIMARY KEY ( id ))";
        String insertRows1 = "INSERT into directors values ('2','Vasya','Pupkin','2022-07-29','Polska')";
        String insertRows2 = "INSERT into directors values ('3','Nikolay','Sobolev','2022-07-30','Russia')";
        try (Statement stm = getConnection().createStatement();
             ResultSet set = getConnection().getMetaData().getTables(null, null, "DIRECTORS", null)) {
            if (!set.next()) {
                stm.executeUpdate(createTables);
                logger.info("Created Table");
                stm.executeUpdate(insertRows1);
                logger.info("Inserted a row");
                stm.executeUpdate(insertRows2);
            }
            logger.info("Successfully created");
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
            throw new RuntimeException(e);
        }

    }

    public static void createTableMovies() {
        logger.debug("Creating table with Movies...");
        String createTables = "CREATE TABLE MOVIES " +
                "(id INTEGER not NULL, " +
                " title VARCHAR(255), " +
                " genre  VARCHAR(255), " +
                " release  DATE, " +
                " director Integer, " +
                " PRIMARY KEY ( id ))";
        String insertRows1 = "INSERT into MOVIES values ('1','Lore','Fantasy','2022-05-29','2')";
        String insertRows2 = "INSERT into MOVIES values ('13','DreamHouse','Horror','2022-11-30','2')";
        try (Statement stm = getConnection().createStatement();
             ResultSet set = getConnection().getMetaData().getTables(null, null, "MOVIES", null)) {
            if (!set.next()) {
                stm.executeUpdate(createTables);
                logger.info("Created Table");
                stm.executeUpdate(insertRows1);
                logger.info("Inserted a row");
                stm.executeUpdate(insertRows2);
            }
            logger.info("Successfully created");
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
            throw new RuntimeException(e);
        }

    }

}
