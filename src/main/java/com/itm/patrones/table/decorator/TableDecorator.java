package com.itm.patrones.table.decorator;

import com.itm.patrones.table.Table;

public abstract class TableDecorator extends Table {
    protected Table decoratedTable;

    public TableDecorator(final Table table) {
        super(table);
        this.decoratedTable = table;
    }

    @Override
    public void displayInfo() {
        decoratedTable.displayInfo();
    }
}
