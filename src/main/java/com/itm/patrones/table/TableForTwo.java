package com.itm.patrones.table;

public class TableForTwo extends Table {
    public TableForTwo(final String type, final int capacity) {
        super(type, capacity);
    }

    private TableForTwo(final Table table) {
        super(table);
    }

    @Override
    public Table clone() {
        return new TableForTwo(this);
    }
}
