package ru.merion.aqa.practiceTasks.OkhttpAPIPractics.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UpdateEmployee(
        @JsonProperty("lastName")
        String lastName,

        @JsonProperty("email")
        String email,

        @JsonProperty("url")  // ← Документация говорит "url", но API использует "avatar_url"
        String url,

        @JsonProperty("phone")
        String phone,

        @JsonProperty("isActive")
        boolean isActive
) {}