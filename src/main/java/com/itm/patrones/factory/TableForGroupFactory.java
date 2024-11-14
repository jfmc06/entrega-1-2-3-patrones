package com.itm.patrones.factory;

import com.itm.patrones.table.Table;
import com.itm.patrones.table.TableForGroup;

public class TableForGroupFactory implements TableFactory {
    @Override
    public Table createTable(final String type, final int capacity) {
        return new TableForGroup(type, capacity);
    }
}
