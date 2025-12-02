package ru.merion.aqa.lesson_12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertionsTest {

    @Test
    public void eqAssert() {
        int actual = 2+2;
        int expected = 5;
        assertEquals(expected, actual, "Математика сломалась");
    }
    @Test
    public void arraysEqualityDemo() {
        int[] arrA = {1,2,3,4,5};
        int[] arrB = {1,2,3,4,5};
        assertEquals(arrA, arrB);
    }

}
