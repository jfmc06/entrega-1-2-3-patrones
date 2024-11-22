package com.itm.patrones.table.decorator;

import com.itm.patrones.table.Table;

public class TableNearWindow extends TableDecorator {
    public TableNearWindow(final Table table) {
        super(table);
    }

    @Override
    public void displayInfo() {
        this.decoratedTable.displayInfo();
        System.out.println("This table is located near the window!");
    }

    @Override
    public Table clone() {
        return new TableNearWindow(this.decoratedTable);
    }
}
