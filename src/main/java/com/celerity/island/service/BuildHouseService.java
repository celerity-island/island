package com.celerity.island.service;

import com.celerity.island.model.exception.NotEnoughMaterialException;
import com.celerity.island.model.home.House;
import com.celerity.island.model.material.Material;
import com.celerity.island.model.material.MaterialType;
import com.celerity.island.util.InventoryUtils;

import java.util.List;
import java.util.Map;

import static java.util.Optional.ofNullable;

public class BuildHouseService {

    private InventoryService inventoryService = new InventoryService(); // TODO Autowire

    public House upgradeHouse(House house, List<Material> materials) throws NotEnoughMaterialException {
        int houseLevel = 0;
        if (house != null) {
            houseLevel = house.ordinal() + 1;
        }
        return buildHouse(houseLevel, materials);
    }

    private House buildHouse(int houseLevel, List<Material> materials) throws NotEnoughMaterialException {
        House house = House.values()[houseLevel];
        if (isEnoughMaterials(house.getRequiredMaterials(), InventoryUtils.getMaterialsView(materials))) {
            inventoryService.consumeMaterials(materials, house.getRequiredMaterials());
            return house;
        } else {
            throw new NotEnoughMaterialException();
        }
    }

    private boolean isEnoughMaterials(Map<MaterialType, Integer> requiredMaterials, Map<MaterialType, Integer> materials) {
        return requiredMaterials.entrySet().stream()
                .allMatch(requiredMaterial -> compareMaterials(requiredMaterial, materials));
    }

    private boolean compareMaterials(Map.Entry<MaterialType, Integer> requiredMaterial, Map<MaterialType, Integer> materials) {
        return ofNullable(materials.get(requiredMaterial.getKey())).orElse(0) - requiredMaterial.getValue() >= 0;
    }

}
