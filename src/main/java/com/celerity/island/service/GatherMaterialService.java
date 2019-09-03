package com.celerity.island.service;

import com.celerity.island.model.material.Material;
import com.celerity.island.model.material.MaterialType;

public class GatherMaterialService {

    private static final int GATHERING_TIME = 10;
    private static final int MATERIAL_PER_TIME = 100;

    public Material gatherMaterial(MaterialType materialType) {
        Material material = new Material();
        material.setQuantity(MATERIAL_PER_TIME);
        material.setMaterialType(materialType);
        return material;
    }
}
