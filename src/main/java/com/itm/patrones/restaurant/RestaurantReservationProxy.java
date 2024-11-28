package com.itm.patrones.restaurant;

import com.itm.patrones.client.Client;
import com.itm.patrones.table.Table;

public class RestaurantReservationProxy implements RestaurantReservation {
    private final RestaurantReservation restaurantReservation;
    private final int minAgeAllowed;

    public RestaurantReservationProxy(final RestaurantReservation restaurantReservation, final int minAgeAllowed) {
        this.restaurantReservation = restaurantReservation;
        this.minAgeAllowed = minAgeAllowed;
    }

    @Override
    public void reserveTable(final Table table, final Client client) {
        if (client.getAge() >= this.minAgeAllowed) {
            restaurantReservation.reserveTable(table, client);
        } else {
            System.out.println("You must be at least 18 years old to reserve a table.");
        }
    }
}
