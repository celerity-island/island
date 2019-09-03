package com.celerity.island.model.material;

import com.celerity.island.model.inventory.Item;

public class Material extends Item {

    private MaterialType materialType;

    public Material() {
    }

    public Material(MaterialType materialType, int quantity) {
        super(materialType.name(), quantity);
        this.materialType = materialType;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
        setName(materialType.name());
    }


}
