package com.celerity.island.model.inventory;

public class Item {

    private String name;
    private int quantity;

    public Item() {
    }

    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void consume(int value) {
        quantity -= value;
    }

    public void add(int value) {
        quantity += value;
    }
}
