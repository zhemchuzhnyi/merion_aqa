package ru.merion.aqa.lesson_12;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    public void eqAssert() {
        int actual = 2+2;
        int expected = 4;
        assertEquals(expected, actual, "Математика сломалась");
    }
    @Test
    public void arraysEqualityDemo() {
        int[] arrA = {1,2,3,4,5};
        int[] arrB = {1,2,3,4,5,};
        assertArrayEquals(arrA, arrB);
    }

    @Test
    public void arraysNonEqualityDemo() {
        int[] arrA = {1,2,3,4,5};
        int[] arrB = {1,2,3,4,5,9};
        assertFalse(Arrays.equals(arrA, arrB));
    }

}
