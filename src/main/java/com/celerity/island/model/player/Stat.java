package com.celerity.island.model.player;

import lombok.Getter;

public enum Stat {
    HEALTH, HUNGER, THIRST, ENERGY, HAPPINESS, SANITY;

    @Getter
    private int level;

    public void setLevel(int level) {
        if (level > 100) {
            this.level = 100;
        } else if (level < 0) {
            this.level = 0;
        }
    }

    public void changeLevel(int change) {
        setLevel(level + change);
    }
}
