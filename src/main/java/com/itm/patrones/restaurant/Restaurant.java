package com.itm.patrones.restaurant;

import com.itm.patrones.menu.MenuComponent;
import com.itm.patrones.table.Table;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurant implements Reservation {
    private static final Map<String, Restaurant> instances = new HashMap<>();
    private final String name;
    private final List<Table> tables;
    private MenuComponent menu;

    private Restaurant(final String name) {
        this.name = name;
        this.tables = new ArrayList<>();
    }

    public static Restaurant getInstance(final String name) {
        if (!instances.containsKey(name)) {
            instances.put(name, new Restaurant(name));
        }
        return instances.get(name);
    }

    public void addTable(final Table table) {
        tables.add(table);
        System.out.println("Added a new table: " + table.getType() + " to restaurant: " + name);
    }

    public void setMenu(final MenuComponent menu) {
        this.menu = menu;
    }

    public void displayMenu() {
        if (menu != null) {
            System.out.println("Menu for " + name + ":");
            menu.display();
        } else {
            System.out.println("No menu available for " + name);
        }
    }

    public String getName() {
        return name;
    }

    public void checkTableAvailability() {
        System.out.println("\n=============== Checking table availability in restaurant: " + name + " ===============");
        for (final Table table : tables) {
            System.out.println("\n======== TABLE INFO ========");
            table.displayInfo();
            System.out.println("============================\n");
        }
        System.out.println("======================================================================================\n");
    }

    @Override
    public void reserveTable(final Table table, final int age) {
        if (tables.contains(table)) {
            tables.remove(table);
            System.out.println("\n============ RESERVATION ============");
            System.out.println(table.getType() + " reserved in " + name + " with this conditions: ");
            table.displayInfo();
            System.out.println("======================================\n");
            return;
        }
        System.out.println("Table not available in " + name + ": " + table.getType());
    }
}
