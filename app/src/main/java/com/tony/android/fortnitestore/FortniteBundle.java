package com.tony.android.fortnitestore;

public class FortniteBundle {
    String image;
    String name;
    String description;
    int cost;
    String rarity;

    public FortniteBundle(String image, String name, String description, int cost, String rarity) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.rarity = rarity;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }

    public String getRarity() {
        return rarity;
    }
}
