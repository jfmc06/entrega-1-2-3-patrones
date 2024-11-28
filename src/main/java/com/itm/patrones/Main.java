package com.itm.patrones;

import com.itm.patrones.client.Client;
import com.itm.patrones.factory.TableFactory;
import com.itm.patrones.factory.TableForGroupFactory;
import com.itm.patrones.factory.TableForTwoFactory;
import com.itm.patrones.menu.MenuItem;
import com.itm.patrones.menu.MenuSection;
import com.itm.patrones.payment.CashPaymentStrategy;
import com.itm.patrones.payment.CreditCardPaymentStrategy;
import com.itm.patrones.payment.PaymentContext;
import com.itm.patrones.reserve.EmailNotifier;
import com.itm.patrones.reserve.ReserveObserver;
import com.itm.patrones.reserve.RestaurantSystemNotifier;
import com.itm.patrones.restaurant.RestaurantReservationProxy;
import com.itm.patrones.restaurant.Restaurant;
import com.itm.patrones.table.Table;
import com.itm.patrones.table.decorator.SimpleTable;
import com.itm.patrones.table.decorator.TableNearWindow;
import com.itm.patrones.table.decorator.TableWithView;

public class Main {
    public static void main(String[] args) {
        // Crear y obtener la instancia del primer restaurante
        final Restaurant restaurant1 = Restaurant.getInstance("Delicious Eats");
        final ReserveObserver restaurantSystemNotifier = new RestaurantSystemNotifier();
        final ReserveObserver emailNotifier = new EmailNotifier();
        restaurant1.addObserver(restaurantSystemNotifier);
        restaurant1.addObserver(emailNotifier);

        // Crear factory para mesas para dos
        final TableFactory tableForTwoFactory = new TableForTwoFactory();
        final Table tableForTwo = tableForTwoFactory.createTable("Table for Two", 2);
        final Table tableForTwoWithView = new TableWithView(tableForTwo);
        final Table simpleTableForTwo = new SimpleTable(tableForTwo);
        restaurant1.addTable(tableForTwoWithView);

        // Duplicar y agregar otra mesa para dos al primer restaurante
        restaurant1.addTable(simpleTableForTwo);

        // Crear factory para mesas para grupos y agregar mesa al primer restaurante
        final TableFactory tableForGroupFactory = new TableForGroupFactory();
        final Table tableForGroup = tableForGroupFactory.createTable("Table for Group", 6);
        restaurant1.addTable(new TableNearWindow(tableForGroup));

        // Crear un menú para el restaurante
        final MenuSection drinksMenu = new MenuSection("Drink Menu");
        drinksMenu.add(new MenuItem("Coke", 1.50));
        drinksMenu.add(new MenuItem("Lemonade", 2.00));

        final MenuSection foodMenu = new MenuSection("Food Menu");
        foodMenu.add(new MenuItem("Burger", 5.00));
        foodMenu.add(new MenuItem("Pasta", 7.00));

        // Integrar las secciones del menú
        final MenuSection completeMenu = new MenuSection("Complete Menu");
        completeMenu.add(drinksMenu);
        completeMenu.add(foodMenu);

        // Establecer el menú para el restaurante
        restaurant1.setMenu(completeMenu);

        // Mostrar el menú del restaurante
        restaurant1.displayMenu();

        // Ver disponibilidad de mesas en el primer restaurante
        System.out.println("\nAvailability in " + restaurant1.getName() + ":");
        restaurant1.checkTableAvailability();

        // -------------------------------------------

        // Obtener la instancia del segundo restaurante
        final Restaurant restaurant2 = Restaurant.getInstance("Gourmet Bistro - Bar");
        restaurant2.addObserver(emailNotifier);
        restaurant2.addTable(simpleTableForTwo.clone());
        restaurant2.addTable(simpleTableForTwo.clone());

        // Crear factory para mesas para grupos y agregar mesa al segundo restaurante
        final Table simpleTableForGroup = new SimpleTable(tableForGroup.clone());
        restaurant2.addTable(simpleTableForGroup);
        restaurant2.addTable(simpleTableForGroup.clone());

        // Ver disponibilidad de mesas en el segundo restaurante
        System.out.println("\nAvailability in " + restaurant2.getName() + ":");
        restaurant2.checkTableAvailability();

        final PaymentContext paymentContext = new PaymentContext();
        paymentContext.setPaymentStrategy(new CashPaymentStrategy());

        final RestaurantReservationProxy reservationForRestaurant1 = new RestaurantReservationProxy(restaurant1, 5);
        final RestaurantReservationProxy reservationForRestaurant2 = new RestaurantReservationProxy(restaurant2, 18);

        // Reservar la mesa para dos en el primer restaurante
        final Client client1 = new Client("John Doe", 14, "john@mail.com");
        reservationForRestaurant1.reserveTable(simpleTableForTwo, client1);
        paymentContext.pay(10, client1);

        // Ver disponibilidad de mesas después de la reserva en el primer restaurante
        System.out.println("\nAvailability in " + restaurant1.getName() + " after reserving a table:");
        restaurant1.checkTableAvailability();

        // Reservar la mesa para grupo en el segundo restaurante, pero una edad no válida
        final Client client2 = new Client("Jane Smith", 16, "jane@mail.com");
        reservationForRestaurant2.reserveTable(simpleTableForGroup, client2);

        // Reservar la mesa para grupo en el segundo restaurante con una edad válida
        final Client client3 = new Client("Miguel Perez", 32, "miguel@mail.com");
        reservationForRestaurant2.reserveTable(simpleTableForGroup, client3);
        paymentContext.setPaymentStrategy(new CreditCardPaymentStrategy());
        paymentContext.pay(50, client3);

        // Ver disponibilidad de mesas después de la reserva en el segundo restaurante
        System.out.println("\nAvailability in " + restaurant2.getName() + " after reserving a table:");
        restaurant2.checkTableAvailability();
    }
}
