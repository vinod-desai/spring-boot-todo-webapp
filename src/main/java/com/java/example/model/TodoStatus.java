package com.java.example.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.java.example.model.serialization.TodoStatusJsonDeserializer;
import com.java.example.model.serialization.TodoStatusJsonSerializer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
@JsonSerialize(using = TodoStatusJsonSerializer.class)
@JsonDeserialize(using = TodoStatusJsonDeserializer.class)
public enum TodoStatus {
    IN_PROGRESS("In Progress"),
    NEW("New"),
    DONE("Done");

    private final String label;

    public static Optional<TodoStatus> fromLabel(String label) {
        return Stream.of(values())
                .filter(x -> x.label.equals(label))
                .findFirst();
    }

    @Override
    public String toString() {
        return label;
    }
}
