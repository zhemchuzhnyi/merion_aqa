package ru.merion.aqa.lesson15.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Company(
        int id,
        String name,
        String description,
        @JsonProperty("isActive") boolean isActive
) {
}
