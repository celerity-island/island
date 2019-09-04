package com.celerity.island.model.player;

import com.celerity.island.model.home.House;
import com.celerity.island.model.inventory.Inventory;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class Player {
    private List<Stat> stats = Arrays.asList(Stat.values());
    private Inventory inventory;
    private House house;
}
