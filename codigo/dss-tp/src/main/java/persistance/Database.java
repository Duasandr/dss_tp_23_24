package persistance;

import java.sql.*;

public class Database {
    private static Database instance = null;
    private final Config config;
    private final Schema schema;
    private Connection connection;


    private Database(Config config, Schema schema) {
        this.config = config;
        this.schema = schema;
        try {
            openConnection();

            executeUpdate(schema.getCreateStatement());
            executeUpdate("USE " + config.NAME + ";");

            for (Table table : schema.getTables()) {
                executeUpdate(table.getCreateStatement());
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static Database getInstance() {
        if(instance == null) {
            instance = new Database(new TestConfig(), new TestSchema());
        }
        return instance;
    }

    public void openConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(
                    config.DRIVER,
                    config.USER,
                    config.PASSWORD
            );
        }
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public void beginTransaction() throws SQLException {
        if (connection != null) {
                connection.setAutoCommit(false);
        }
    }

    public void commitTransaction() throws SQLException {
        if (connection != null) {
            connection.commit();
        }
    }

    public void rollbackTransaction() throws SQLException {
        if (connection != null) {
            connection.rollback();
        }
    }

    public Table getTable(String tableName) {
        return schema.getTable(tableName);
    }

    public ResultSet executeQuery(String query, Object... parameters) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // Set parameters
            for (int i = 0; i < parameters.length; i++) {
                preparedStatement.setObject(i + 1, parameters[i]);
            }

            // Execute query
            return preparedStatement.executeQuery();
        }
    }

    public void executeUpdate(String insertQuery, Object... parameters) throws SQLException {
        beginTransaction();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            // Set parameters
            for (int i = 0; i < parameters.length; i++) {
                preparedStatement.setObject(i + 1, parameters[i]);
            }

            // Execute query
            preparedStatement.executeUpdate();
            commitTransaction();
        } catch (SQLException sqlException){
            rollbackTransaction();
            throw sqlException;
        }
    }

    public static void release() {
        try {
            instance.closeConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        instance = null;
    }
}