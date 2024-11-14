package com.itm.patrones.factory;

import com.itm.patrones.table.Table;

public interface TableFactory {
   Table createTable(String type, int capacity);
}
