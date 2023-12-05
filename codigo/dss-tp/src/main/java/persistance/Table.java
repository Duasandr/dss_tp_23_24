package persistance;

import java.util.*;

public class Table {
    private String name;
    private List<String> columns;

    public Table() {
        columns = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public void addColumn(String column) {
        columns.add(column);
    }


    public String getCreateStatement() {
        StringBuilder statement = new StringBuilder("CREATE TABLE IF NOT EXISTS " + name + " (");
        for (String column : columns) {
            statement.append(column).append(", ");
        }
        statement.delete(statement.length() - 2, statement.length());
        statement.append(");");
        return statement.toString();
    }

    public String getInsertStatement() {
        StringBuilder statement = new StringBuilder("INSERT INTO " + name + " (");
        for (String column : columns) {
            statement.append(column.split(" ")[0]).append(", ");
        }
        statement.delete(statement.length() - 2, statement.length());
        statement.append(") VALUES (");
        for (String column : columns) {
            statement.append("?, ");
        }
        statement.delete(statement.length() - 2, statement.length());
        statement.append(");");
        return statement.toString();
    }

    public String getSelectStatement() {
        return "SELECT * FROM " + name + " WHERE id = ?;";
    }

    public String getDeleteStatement() {
        return "DELETE FROM " + name + " WHERE id = ?;";
    }

    public String getUpdateStatement() {
        StringBuilder statement = new StringBuilder("UPDATE " + name + " SET ");
        for (String column : columns) {
            statement.append(column.split(" ")[0]).append(" = ?, ");
        }
        statement.delete(statement.length() - 2, statement.length());
        statement.append(" WHERE id = ?;");
        return statement.toString();
    }

    public String getSelectByColumnStatement(String column) {
        return "SELECT * FROM " + name + " WHERE " + column + " = ?;";
    }

    public String getDeleteByColumnStatement(String column) {
        return "DELETE FROM " + name + " WHERE " + column + " = ?;";
    }

    public String getCountByColumnStatement(String column) {
        return "SELECT COUNT(*) FROM " + name + " WHERE " + column + " = ?;";
    }
}
