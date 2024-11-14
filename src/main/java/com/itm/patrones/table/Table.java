package com.itm.patrones.table;

public abstract class Table implements TablePrototype {
    protected String type;
    protected int capacity;

    protected Table(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    protected Table(final Table table) {
        this.type = table.type;
        this.capacity = table.capacity;
    }

    public void displayInfo() {
        System.out.println("Table Type: " + type + ", Capacity: " + capacity);
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public abstract Table clone();
}
