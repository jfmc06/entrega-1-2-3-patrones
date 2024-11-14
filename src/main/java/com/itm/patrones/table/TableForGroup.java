package com.itm.patrones.table;

public class TableForGroup extends Table {
    public TableForGroup(final String type, final int capacity) {
        super(type, capacity);
    }

    private TableForGroup(final Table table) {
        super(table);
    }

    @Override
    public Table clone() {
        return new TableForGroup(this);
    }
}
