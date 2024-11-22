package com.itm.patrones.menu;

public class MenuItem implements MenuComponent {
    private final String name;
    private final double price;

    public MenuItem(final String name, final double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void display() {
        System.out.println(getName() + ": $" + getPrice());
    }
}
