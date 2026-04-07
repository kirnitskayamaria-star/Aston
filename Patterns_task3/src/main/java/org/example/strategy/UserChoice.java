package org.example.strategy;

import java.util.Arrays;

public enum UserChoice {
    DELETE("1"),
    INFO("2"),
    HEADMAN("3"),
    EXIT("4"),
    REGISTER("5");

    private final String value;

    UserChoice(String value) {
        this.value = value;
    }

    public static UserChoice fromValue(String value) {
        return Arrays.stream(UserChoice.values())
                .filter(choice -> choice.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown choice: " + value));
    }
}
