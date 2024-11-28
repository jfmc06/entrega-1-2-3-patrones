package com.itm.patrones.payment;

import com.itm.patrones.client.Client;

public class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(final double amount, final Client client) {
        System.out.println(client.getName() + " is paying " + amount + " with cash");
    }
}
