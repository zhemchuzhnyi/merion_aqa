package ru.merion.aqa.lesson_12;

import org.junit.jupiter.api.extension.*;

public class BeforeAndAfterEachCallbacks implements BeforeEachCallback,
        AfterEachCallback, AfterAllCallback, BeforeAllCallback {
    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        System.out.println("Закончили выполнять");
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        System.out.println("Начинаем выполнять");
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
    }

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
    }


}
