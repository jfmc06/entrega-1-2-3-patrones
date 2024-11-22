package com.itm.patrones.restaurant;

import com.itm.patrones.table.Table;

public class ReservationProxy implements Reservation {
    private final Reservation reservation;
    private final int maxAgeAllowed;

    public ReservationProxy(final Reservation reservation, final int maxAgeAllowed) {
        this.reservation = reservation;
        this.maxAgeAllowed = maxAgeAllowed;
    }

    @Override
    public void reserveTable(final Table table, final int age) {
        if (age >= this.maxAgeAllowed) {
            reservation.reserveTable(table, age);
        } else {
            System.out.println("You must be at least 18 years old to reserve a table.");
        }
    }
}
