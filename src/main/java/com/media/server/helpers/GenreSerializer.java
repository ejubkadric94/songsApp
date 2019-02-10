package com.media.server.helpers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.media.server.enums.Genre;

import java.io.IOException;


public class GenreSerializer extends StdSerializer<Genre> {

    public GenreSerializer() {
        super(Genre.class);
    }

    public GenreSerializer(Class t) {
        super(t);
    }

    public void serialize(Genre genre, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeStartObject();
        generator.writeNumber(genre.getValue());
        generator.writeEndObject();
    }
}
