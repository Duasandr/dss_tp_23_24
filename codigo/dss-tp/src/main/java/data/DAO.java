package data;

import persistance.Database;
import persistance.Table;

import java.sql.ResultSet;

public class DAO {
    private final Database database;
    private final Table table;

    public DAO(Database database, Table table) {
        this.database = database;
        this.table = table;
    }

    public ResultSet getById(String id) throws Exception {
        return database.executeQuery(table.getSelectStatement(), id);
    }

    public void add(Object... values) throws Exception {
        database.executeUpdate(table.getInsertStatement(), values);
    }

    public void delete(String id) throws Exception {
        database.executeUpdate(table.getDeleteStatement(), id);
    }

    public void deleteByColumn(String column, String value) throws Exception {
        database.executeUpdate(table.getDeleteByColumnStatement(column), value);
    }

    protected ResultSet getByColumn(String column, String value) throws Exception {
        return database.executeQuery(table.getSelectByColumnStatement(column), value);
    }

    protected ResultSet executeQuery(String sql) throws Exception {
        return database.executeQuery(sql);
    }

    protected ResultSet countByColumn(String column, String value) throws Exception {
        return database.executeQuery(table.getCountByColumnStatement(column), value);
    }
}
