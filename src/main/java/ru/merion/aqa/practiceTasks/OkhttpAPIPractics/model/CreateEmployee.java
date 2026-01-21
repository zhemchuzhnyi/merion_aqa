package ru.merion.aqa.practiceTasks.OkhttpAPIPractics.model;

public record CreateEmployee(String firstName,
                             String lastName,
                             int companyId,
                             String email,
                             String phone) {
}