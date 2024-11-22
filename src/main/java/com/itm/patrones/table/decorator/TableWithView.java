package com.itm.patrones.table.decorator;

import com.itm.patrones.table.Table;

public class TableWithView extends TableDecorator {
    public TableWithView(final Table table) {
        super(table);
    }

    @Override
    public void displayInfo() {
        this.decoratedTable.displayInfo();
        System.out.println("This table has a beautiful view!");
    }

    @Override
    public Table clone() {
        return new TableWithView(this.decoratedTable);
    }
}
