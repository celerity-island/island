package com.celerity.island.model.number.exception;

import lombok.Getter;

public class LessThanZeroValueException extends Exception {

    @Getter
    private int value;

    public LessThanZeroValueException(int value) {
        this.value = value;
    }
}
