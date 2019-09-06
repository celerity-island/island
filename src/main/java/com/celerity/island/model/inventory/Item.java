package com.celerity.island.model.inventory;

import com.celerity.island.model.number.PositiveInteger;
import com.celerity.island.model.number.exception.LessThanZeroValueException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Item {

    private String name;
    private PositiveInteger quantity;

    public void consume(int value) {
        try {
            quantity.decrease(value);
        } catch (LessThanZeroValueException e) {
            // TODO throw ZeroQuantityException/NotEnoughMaterialException, process it in appropriate service/manager
        }
    }

    public void add(int value) {
        quantity.increase(value);
    }

    public void setQuantity(int quantity) {
        this.quantity = new PositiveInteger(quantity);
    }
}
