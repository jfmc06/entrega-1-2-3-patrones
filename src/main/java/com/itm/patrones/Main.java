package com.itm.patrones;

import com.itm.patrones.factory.TableFactory;
import com.itm.patrones.factory.TableForGroupFactory;
import com.itm.patrones.factory.TableForTwoFactory;
import com.itm.patrones.restaurant.Restaurant;
import com.itm.patrones.table.Table;

public class Main {
    public static void main(String[] args) {
        final Restaurant restaurant1 = Restaurant.getInstance("Delicious Eats");

        // Crear factory para mesas para dos
        final TableFactory tableForTwoFactory = new TableForTwoFactory();
        // Crear una mesa para dos y agregarla al primer restaurante
        final Table tableForTwo = tableForTwoFactory.createTable("Table for Two", 2);
        restaurant1.addTable(tableForTwo);

        // Duplicar y agregar otra mesa para dos al primer restaurante
        restaurant1.addTable(tableForTwo.clone());

        // Crear factory para mesas para grupos y agregar mesa al primer restaurante
        final TableFactory tableForGroupFactory = new TableForGroupFactory();
        Table tableForGroup = tableForGroupFactory.createTable("Table for Group", 6);
        restaurant1.addTable(tableForGroup);

        // Ver disponibilidad de mesas en el primer restaurante
        System.out.println("\nAvailability in " + restaurant1.getName() + ":");
        restaurant1.checkTableAvailability();

        // -------------------------------------------

        // Obtener la instancia del segundo restaurante
        final Restaurant restaurant2 = Restaurant.getInstance("Gourmet Bistro");
        restaurant2.addTable(tableForTwo.clone());
        restaurant2.addTable(tableForTwo.clone());

        // Crear factory para mesas para grupos y agregar mesa al segundo restaurante
        final Table tableForGroup2 = tableForGroupFactory.createTable("Table for Group", 6);
        restaurant2.addTable(tableForGroup2);
        restaurant2.addTable(tableForGroup.clone());

        // Ver disponibilidad de mesas en el segundo restaurante
        System.out.println("\nAvailability in " + restaurant2.getName() + ":");
        restaurant2.checkTableAvailability();

        System.out.println("\n");

        // Reservar la mesa para dos en el primer restaurante
        restaurant1.reserveTable(tableForTwo);

        // Ver disponibilidad de mesas después de la reserva en el primer restaurante
        System.out.println("\nAvailability in " + restaurant1.getName() + " after reserving a table:");
        restaurant1.checkTableAvailability();

        System.out.println("\n");
        // Reservar la mesa para grupo en el segundo restaurante
        restaurant2.reserveTable(tableForGroup2);

        // Ver disponibilidad de mesas después de la reserva en el segundo restaurante
        System.out.println("\nAvailability in " + restaurant2.getName() + " after reserving a table:");
        restaurant2.checkTableAvailability();
    }
}
