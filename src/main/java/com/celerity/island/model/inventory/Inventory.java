package com.celerity.island.model.inventory;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Inventory {
    private List<Item> items = new ArrayList<>();
}
