package com.itm.patrones.reserve;

import com.itm.patrones.client.Client;

public class RestaurantSystemNotifier implements ReserveObserver {
    @Override
    public void notify(final String message, final Client client) {
        System.out.println("Notifying restaurant system: " + message + " - " + client.getName());
    }
}
