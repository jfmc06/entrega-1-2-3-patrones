package com.itm.patrones.payment;

import com.itm.patrones.client.Client;

public interface PaymentStrategy {
    void pay(final double amount, final Client client);
}
