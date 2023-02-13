package com.java.example.model.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.java.example.model.TodoStatus;

import java.io.IOException;
import java.util.Optional;

public class TodoStatusJsonDeserializer extends JsonDeserializer<TodoStatus> {
    @Override
    public TodoStatus deserialize(JsonParser parser, DeserializationContext ctx) throws IOException {
        String value = parser.getValueAsString();
        Optional<TodoStatus> deserialized = TodoStatus.fromLabel(value);
        return deserialized.orElse(null);
    }
}
