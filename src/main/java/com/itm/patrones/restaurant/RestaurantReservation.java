package com.itm.patrones.restaurant;

import com.itm.patrones.table.Table;

public interface RestaurantReservation {
    void reserveTable(final Table table, final int age);
}
