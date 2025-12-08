package ru.merion.aqa.lesson_12.ext;

import org.junit.jupiter.api.extension.*;

public class BeforeAndAfterEachCallbacks implements BeforeEachCallback, AfterEachCallback {
    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        System.out.println("Закончили выполнять");
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        System.out.println("Начинаем выполнять");
    }
}
