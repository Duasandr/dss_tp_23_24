package persistance;

import java.util.*;

public class Schema {
    private String name;
    private Map<String, Table> tables;

    public Schema() {
        tables = new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    public List<Table> getTables() {
        return new ArrayList<>(tables.values());
    }

    public Table getTable(String name) {
        return tables.get(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTables(Map<String, Table> tables) {
        this.tables = tables;
    }

    public void addTable(Table table) {
        tables.put(table.getName(), table);
    }

    public String getCreateStatement() {
        return "CREATE SCHEMA IF NOT EXISTS " + name + ";";
    }

    public String getDropStatement() {
        return "DROP SCHEMA IF EXISTS " + name + ";";
    }
}
