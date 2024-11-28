package com.itm.patrones.table.iterator;

import com.itm.patrones.table.Table;

public interface TableIterator {
    boolean hasNext();
    Table next();
}
