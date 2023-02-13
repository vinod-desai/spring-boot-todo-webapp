package com.java.example.model.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.java.example.model.TodoStatus;

import java.io.IOException;

public class TodoStatusJsonSerializer extends JsonSerializer<TodoStatus> {
    @Override
    public void serialize(TodoStatus value, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeString(value.toString());
    }
}
