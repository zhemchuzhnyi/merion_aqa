package ru.merion.aqa.lesson_12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertionsTest {
    @Test
    public void eqAssert() {
        int actual = 2+2;
        int expected = 4;
        assertEquals(expected, actual);

    }
}
