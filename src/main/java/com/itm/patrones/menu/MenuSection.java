package com.itm.patrones.menu;

import java.util.ArrayList;
import java.util.List;

public class MenuSection implements MenuComponent {
    private final List<MenuComponent> menuComponents = new ArrayList<>();
    private final String sectionName;

    public MenuSection(final String sectionName) {
        this.sectionName = sectionName;
    }

    public void add(final MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
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
}
