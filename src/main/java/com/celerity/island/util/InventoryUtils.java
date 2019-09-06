package com.celerity.island.util;

import com.celerity.island.model.inventory.Inventory;
import com.celerity.island.model.inventory.Item;
import com.celerity.island.model.material.Material;
import com.celerity.island.model.material.MaterialType;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class InventoryUtils {

    public static Map<MaterialType, Integer> getMaterialsView(@NotNull Inventory inventory) {
        return getMaterialsView(inventory.getItems());
    }

    public static List<Material> getMaterials(@NotNull Inventory inventory) {
        return getMaterials(inventory.getItems());
    }

    public static List<Material> getMaterials(@NotNull List<? extends Item> items) {
        return items.stream()
                .filter(item -> item instanceof Material)
                .map(item -> (Material) item)
                .collect(Collectors.toList());
    }

    public static Map<MaterialType, Integer> getMaterialsView(@NotNull List<? extends Item> items) {
        return getMaterials(items).stream()
                .collect(toMap(Material::getMaterialType, item -> item.getQuantity().getValue()));
    }
}
