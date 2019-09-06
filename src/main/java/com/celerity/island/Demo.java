package com.celerity.island;

import com.celerity.island.model.exception.NotEnoughMaterialException;
import com.celerity.island.model.home.House;
import com.celerity.island.model.inventory.Inventory;
import com.celerity.island.model.inventory.Item;
import com.celerity.island.model.material.Material;
import com.celerity.island.model.material.MaterialType;
import com.celerity.island.model.player.Player;
import com.celerity.island.service.BuildHouseService;
import com.celerity.island.service.GatherMaterialService;

import java.util.List;
import java.util.Scanner;

import static com.celerity.island.util.InventoryUtils.getMaterials;

public class Demo {

    private static Scanner scanner = new Scanner(System.in);

    private static Player player = new Player();
    private static GatherMaterialService gatherMaterialService = new GatherMaterialService();
    private static BuildHouseService buildHouseService = new BuildHouseService();


    static {
        Inventory inventory = new Inventory();
        player.setInventory(inventory);
    }

    public static void main(String[] args) {
        showStartScreen();
        showNextScreen(scanner.nextInt());
    }

    private static void showNextScreen(int nextScreenNumber) {
        switch (nextScreenNumber) {
            case 0:
                showInventory();
                break;
            case 1:
                gatherMaterials();
                break;
            case 2:
                buildHouse();
                break;
            default:
                showStartScreen();
        }
    }

    private static void buildHouse() {
        Inventory inventory = player.getInventory();
        try {
            House house = buildHouseService.upgradeHouse(player.getHouse(), getMaterials(inventory));
            player.setHouse(house);
            System.out.println("House is successfully built");
        } catch (NotEnoughMaterialException e) {
            System.out.println("Not enough materials");
        }
        main(null);
    }

    private static void gatherMaterials() {
        System.out.println("Choose material type");
        for (MaterialType materialType : MaterialType.values()) {
            System.out.println(materialType.ordinal() + " - " + materialType.name());
        }
        int type = scanner.nextInt();
        gatherMaterial(type, player.getInventory());
        main(null);
    }

    private static void gatherMaterial(int type, Inventory inventory) {
        Material material = gatherMaterialService.gatherMaterial(MaterialType.values()[type]);
        for (Item item : inventory.getItems()) {
            if (((Material) item).getMaterialType().equals(material.getMaterialType())) {
                item.setQuantity(item.getQuantity().getValue() + material.getQuantity().getValue());
                return;
            }
        }
        inventory.getItems().add(material);
    }

    private static void showInventory() {
        Inventory inventory = player.getInventory();
        printHouse(player.getHouse());
        printItems(inventory.getItems());
        main(null);
    }

    private static void printItems(List<Item> items) {
        if (items.size() == 0) {
            System.out.println("No items in inventory");
        } else {
            System.out.println("Items:");
            for (Item item : items) {
                System.out.println(item.getQuantity() + " " + item.getName());
            }

        }
    }

    private static void printHouse(House house) {
        if (house == null) {
            System.out.println("House is not yet constructed");
        } else {
            System.out.println("Your house: " + house.getName());
        }
    }

    private static void showStartScreen() {
        System.out.println("0 - show inventory");
        System.out.println("1 - gather material");
        System.out.println("2 - build house");
    }
}
