package com.itm.patrones.restaurant;

import com.itm.patrones.table.Table;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurant {
    private static final Map<String, Restaurant> instances = new HashMap<>();
    private final String name;
    private final List<Table> tables;

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

    public String getName() {
        return name;
    }

    public void checkTableAvailability() {
        System.out.println("Checking table availability in restaurant: " + name);
        for (final Table table : tables) {
            table.displayInfo();
        }
    }

    public void reserveTable(final Table table) {
        if (tables.contains(table)) {
            tables.remove(table);
            System.out.println("Table reserved in " + name + ": " + table.getType());
            return;
        }
        System.out.println("Table not available in " + name + ": " + table.getType());
    }
}
