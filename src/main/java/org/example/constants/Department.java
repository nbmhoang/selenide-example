package org.example.constants;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Department {
    CAR_ELECTRONICS("Car Electronics"),
    COMPUTER_AND_OFFICE("Computer & Office"),
    WATCHES("Watches");

    private final String label;
}
