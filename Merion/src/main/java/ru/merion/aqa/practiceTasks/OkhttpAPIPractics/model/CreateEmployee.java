package ru.merion.aqa.practiceTasks.OkhttpAPIPractics.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateEmployee(
        @JsonProperty("firstName")
        String firstName,

        @JsonProperty("lastName")
        String lastName,

        @JsonProperty("companyId")
        int companyId,

        @JsonProperty("phone")
        String phone
) {
    // Статический фабричный метод (игнорирует email параметр)
    public static CreateEmployee of(String firstName, String lastName,
                                    int companyId, String phone) {
        return new CreateEmployee(firstName, lastName, companyId, phone);
    }

    // Устаревший конструктор с email (для обратной совместимости)
    @Deprecated
    public CreateEmployee(String firstName, String lastName,
                          int companyId, String email, String phone) {
        this(firstName, lastName, companyId, phone); // игнорируем email
    }
}