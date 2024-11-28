package com.itm.patrones.restaurant;

import com.itm.patrones.client.Client;
import com.itm.patrones.table.Table;

public interface RestaurantReservation {
    void reserveTable(final Table table, final Client client);
}
