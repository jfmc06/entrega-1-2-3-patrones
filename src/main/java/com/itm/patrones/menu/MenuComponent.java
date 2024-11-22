package com.itm.patrones.menu;

public abstract class MenuComponent {
    public void add(final MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public abstract String getName();
    public abstract double getPrice();
    public abstract void display();
}
