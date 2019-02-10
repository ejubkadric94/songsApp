package com.media.server.enums;

public enum Genre {
    POP(10),
    EURO_DANCE(20),
    ROCK(30),
    JAZZ(40);

    private final int value;

    Genre(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}
