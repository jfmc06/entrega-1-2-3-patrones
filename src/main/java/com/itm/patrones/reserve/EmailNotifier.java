package com.itm.patrones.reserve;

import com.itm.patrones.client.Client;

public class EmailNotifier implements ReserveObserver {
    @Override
    public void notify(final String message, final Client client) {
        System.out.println("Notifying client by email: " + message + " - " + client.getEmail());
    }
}
