package com.media.server.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

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

    private String value;


    Genre(String newValue) {
        value = newValue;
    }

    public void setValue(Genre genre) {
        value = genre.value;
    }

    @JsonValue
    public String getValue() { return value; }

}
