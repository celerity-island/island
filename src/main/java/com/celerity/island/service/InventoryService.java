package com.celerity.island.service;

import com.celerity.island.model.material.Material;
import com.celerity.island.model.material.MaterialType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

public class InventoryService {

    public void consumeMaterials(List<Material> materials, Map<MaterialType, Integer> materialsToConsume) {
        materials.stream()
                .collect(Collectors.toMap(Material::getMaterialType, material -> material))
                .forEach((key, value) -> value.consume(ofNullable(materialsToConsume.get(key)).orElse(0)));
    }
}
