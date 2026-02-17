package org.algorithms.my.topsellers;

public class Selling {
    private final String name;
    private final String country;
    private final String item;
    private final int amount;

    public Selling(String name, String country, String item, int amount) {
        this.name = name;
        this.country = country;
        this.item = item;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }
}
