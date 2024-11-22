package com.itm.patrones.menu;

import java.util.ArrayList;
import java.util.List;

public class MenuSection extends MenuComponent {
    private final List<MenuComponent> menuComponents = new ArrayList<>();
    private final String sectionName;

    public MenuSection(final String sectionName) {
        this.sectionName = sectionName;
    }

    @Override
    public void add(final MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(final MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public void display() {
        System.out.println(sectionName + ":");
        for (MenuComponent menuComponent : menuComponents) {
            menuComponent.display();
        }
    }

    @Override
    public String getName() {
        return sectionName;
    }

    @Override
    public double getPrice() {
        // O podrías tener un precio agregado de todos los elementos en esta sección
        return 0;
    }
}
