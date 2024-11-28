package com.itm.patrones.table.iterator;

import com.itm.patrones.table.Table;
import java.util.List;

public class RestaurantTableIterator implements TableIterator {
    private final List<Table> restaurantTables;
    private int index;

    public RestaurantTableIterator(final List<Table> restaurantTables) {
        this.restaurantTables = restaurantTables;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < restaurantTables.size();
    }

    @Override
    public Table next() {
        if (hasNext()) {
            return restaurantTables.get(index++);
        }
        return null;
    }
}
