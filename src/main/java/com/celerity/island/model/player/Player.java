package com.celerity.island.model.player;

import com.celerity.island.model.inventory.Inventory;

import java.util.Arrays;
import java.util.List;

public class Player {

    private List<Stat> stats = Arrays.asList(Stat.values());
    private Inventory inventory;

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
