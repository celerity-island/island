package com.celerity.island.model.number;

import com.celerity.island.model.number.exception.LessThanZeroValueException;
import lombok.Getter;

/**
 * PositiveInteger represents integer value, that can only be greater than zero.
 * If it`s value is about to change to less than zero - it won`t allow it.
 */
public class PositiveInteger {

    private static final int MIN_VALUE = 0;
    @Getter
    protected int value;

    /**
     * Creates new PositiveInteger object. If value is assigned to less than 0 it will be assigned to 0.
     * @param value basic value
     */
    public PositiveInteger(int value) {
        value = value < MIN_VALUE ? MIN_VALUE : value;
        this.value = value;
    }

    /**
     * Decreases value by some amount. Can not make it less than 0.
     * @param amount amount to decrease
     * @throws LessThanZeroValueException thrown if resulting value is 0
     */
    public void decrease(int amount) throws LessThanZeroValueException {
        value -= amount;
        if (value <= MIN_VALUE) {
            int resultingValue = value;
            value = MIN_VALUE;
            throw new LessThanZeroValueException(resultingValue);
        }
    }

    /**
     * Increases value by some amount.
     * @param amount amount to increase
     */
    public void increase(int amount) {
        value += amount;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
