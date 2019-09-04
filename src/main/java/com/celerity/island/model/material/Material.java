package com.celerity.island.model.material;

import com.celerity.island.model.inventory.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Material extends Item {

    @Getter
    private MaterialType materialType;

    public Material(MaterialType materialType, int quantity) {
        super(materialType.name(), quantity);
        this.materialType = materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
        setName(materialType.name());
    }


}
