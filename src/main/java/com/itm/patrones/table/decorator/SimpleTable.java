package com.itm.patrones.table.decorator;

import com.itm.patrones.table.Table;

public class SimpleTable extends TableDecorator {
    public SimpleTable(final Table table) {
        super(table);
    }

    @Override
    public void displayInfo() {
        this.decoratedTable.displayInfo();
        System.out.println("This is a simple table!");
    }

    @Override
    public Table clone() {
        return new SimpleTable(this.decoratedTable);
    }
}
