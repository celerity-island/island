package com.celerity.island.model.number;

/**
 * Percent class represents percentage value. It has capability to manage its own value.
 * With class creation value is assigned to 100. It can not be greater than 100 and less than 0.
 */
public class Percent extends PositiveInteger {

    private static final int MAX_PERCENT = 100;

    /**
     * Creates Percent class with default value 100 (MAX_PERCENT)
     */
    public Percent() {
        super(MAX_PERCENT);
    }

    /**
     * Increases percent by some amount. Can not make percent greater than 100.
     * @param amount amount of percent to increase
     */
    @Override
    public void increase(int amount) {
        value += amount;
        if (value > MAX_PERCENT) {
            value = MAX_PERCENT;
        }
    }

}
