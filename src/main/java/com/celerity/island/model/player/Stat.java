package com.celerity.island.model.player;

import com.celerity.island.model.number.Percent;
import lombok.Getter;

public enum Stat {
    HEALTH, HUNGER, THIRST, ENERGY, HAPPINESS, SANITY;

    @Getter
    private Percent level;
}
