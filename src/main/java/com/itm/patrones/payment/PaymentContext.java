package com.itm.patrones.payment;

import com.itm.patrones.client.Client;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(final double amount, final Client client) {
        if (paymentStrategy != null) {
            paymentStrategy.pay(amount, client);
            return;
        }
        System.out.println("Payment strategy not set!");
    }
}
