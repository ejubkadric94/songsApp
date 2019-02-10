package com.media.server.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.media.server.helpers.GenreSerializer;

import java.util.HashMap;
import java.util.Map;
//
//@JsonFormat(shape = JsonFormat.Shape.OBJECT)
//@JsonSerialize(using = GenreSerializer.class)
public enum Genre {
    @JsonProperty("POP")
    POP("POP"),
    @JsonProperty("EURO_DANCE")
    EURO_DANCE("EURO_DANCE"),
    @JsonProperty("ROCK")
    ROCK("ROCK"),
    @JsonProperty("JAZZ")
    JAZZ("JAZZ");

    private final String value;

//    private static final Map<String, Integer> enumMap = new HashMap<String, Integer>();
//    static {
//        enumMap.put("POP", 10);
//        enumMap.put("EURO_DANCE", 20);
//        enumMap.put("ROCK", 30);
//        enumMap.put("JAZZ", 40);
//    }
//
//    @JsonCreator
//    public static int forValue(String value) {
//        return enumMap.get(value);
//    }
//
//    @JsonValue
//    public String toValue() {
//        for (Map.Entry<String, Integer> entry : enumMap.entrySet()) {
//            if (entry.getValue() == this.getValue())
//                return entry.getKey();
//        }
//        return null; // or fail
//    }

    Genre(String newValue) {
        value = newValue;
    }

    @JsonValue
    public String getValue() { return value; }

//
//    @JsonProperty("10")
//    POP(10),
//    @JsonProperty("20")
//    EURO_DANCE(20),
//    @JsonProperty("30")
//    ROCK(30),
//    @JsonProperty("40")
//    JAZZ(40);
//
//
//    private final int value;
//
//    Genre(final int value) {
//        this.value = value;
//    }
//
//    @JsonValue()
//    public int getGenre() {
//        return ordinal();
//    }

//    POP(10),
//    EURO_DANCE(20),
//    ROCK(30),
//    JAZZ(40);
//
//    private int code;
//
//    Genre(int code) {
//        this.code = code;
//    }
//
//    public int getCode() {
//        return code;
//    }
//
//    @JsonValue
//    public int toValue() {
//        return getCode();
//    }
//
//    public static Genre forCode(int code) {
//        for (Genre element : values()) {
//            if (element.code == code) {
//                return element;
//            }
//        }
//        return null; //or throw exception if you like...
//    }
//
//    @JsonCreator
//    public static Genre forValue(String v) {
//        return Genre.forCode(Integer.parseInt(v));
//    }
}
