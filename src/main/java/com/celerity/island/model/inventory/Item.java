package com.celerity.island.model.inventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    private String name;
    private int quantity;

    // TODO: add check for negative inventory quantity
    public void consume(int value) {
        quantity -= value;
    }

    public void add(int value) {
        quantity += value;
    }
}
