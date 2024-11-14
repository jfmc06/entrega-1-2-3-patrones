package com.itm.patrones.factory;

import com.itm.patrones.table.Table;
import com.itm.patrones.table.TableForTwo;

public class TableForTwoFactory implements TableFactory {
    @Override
    public Table createTable(final String type, final int capacity) {
        return new TableForTwo(type, capacity);
    }
}
