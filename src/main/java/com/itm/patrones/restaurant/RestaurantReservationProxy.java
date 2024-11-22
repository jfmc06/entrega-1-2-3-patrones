package com.itm.patrones.restaurant;

import com.itm.patrones.table.Table;

public class RestaurantReservationProxy implements RestaurantReservation {
    private final RestaurantReservation restaurantReservation;
    private final int minAgeAllowed;

    public RestaurantReservationProxy(final RestaurantReservation restaurantReservation, final int minAgeAllowed) {
        this.restaurantReservation = restaurantReservation;
        this.minAgeAllowed = minAgeAllowed;
    }

    @Override
    public void reserveTable(final Table table, final int age) {
        if (age >= this.minAgeAllowed) {
            restaurantReservation.reserveTable(table, age);
        } else {
            System.out.println("You must be at least 18 years old to reserve a table.");
        }
    }
}
