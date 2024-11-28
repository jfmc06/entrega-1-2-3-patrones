package com.itm.patrones.client;

public final class Client {
    private final String name;
    private final int age;
    private final String email;

    public Client(final String name, final int age, final String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}
