package com.celerity.island.model.inventory;

import com.celerity.island.model.material.MaterialType;

import java.util.HashMap;
import java.util.Map;

public enum House {

    SIMPLE_TENT("Simple tent"), TENT("tent"), FORTIFIED_TENT("Fortified tent");

    static {
        Map<MaterialType, Integer> requiredMaterialsForSimpleTent = new HashMap<>();
        requiredMaterialsForSimpleTent.put(MaterialType.BRANCH, 350);
        requiredMaterialsForSimpleTent.put(MaterialType.LEAF, 150);
        SIMPLE_TENT.setRequiredMaterials(requiredMaterialsForSimpleTent);

        Map<MaterialType, Integer> requiredMaterialsForTent = new HashMap<>();
        requiredMaterialsForTent.put(MaterialType.BRANCH, 750);
        requiredMaterialsForTent.put(MaterialType.LEAF, 450);
        TENT.setRequiredMaterials(requiredMaterialsForTent);

        Map<MaterialType, Integer> requiredMaterialsForFortifiedTent = new HashMap<>();
        requiredMaterialsForFortifiedTent.put(MaterialType.BRANCH, 1250);
        requiredMaterialsForFortifiedTent.put(MaterialType.LEAF, 850);
        FORTIFIED_TENT.setRequiredMaterials(requiredMaterialsForFortifiedTent);
    }

    House(String name) {
        this.name = name;
    }

    private String name;
    private Map<MaterialType, Integer> requiredMaterials;

    public String getName() {
        return name;
    }

    public Map<MaterialType, Integer> getRequiredMaterials() {
        return requiredMaterials;
    }

    private void setRequiredMaterials(Map<MaterialType, Integer> requiredMaterials) {
        this.requiredMaterials = requiredMaterials;
    }
}
