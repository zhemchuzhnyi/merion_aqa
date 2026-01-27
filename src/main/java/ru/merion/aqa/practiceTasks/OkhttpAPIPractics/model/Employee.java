package ru.merion.aqa.practiceTasks.OkhttpAPIPractics.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Employee(
        @JsonProperty("id")
        int id,

        @JsonProperty("firstName")
        String firstName,

        @JsonProperty("lastName")
        String lastName,

        @JsonProperty("middleName")
        String middleName,

        @JsonProperty("companyId")
        int companyId,

        @JsonProperty("email")
        String email,

        @JsonProperty("avatar_url")
        String avatarUrl,

        @JsonProperty("phone")
        String phone,

        @JsonProperty("birthdate")
        String birthdate,

        @JsonProperty("isActive")
        boolean isActive

) {}