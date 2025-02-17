package org.example;

import org.junit.Test;
import org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.example.NumberUtils.add;

public class NumberUtilsTest {
    /**
     *
     * Step 1: understand the requirement, input type and output type
     *        Requirement: Add two list of integer, index by index, and returns another list
     *
     * Step 2 (raw):  Perform partition and boundary analysis on input and output
     *        Each input: left | right
     *        Combination of input:
     *        Output:
     *  Step 3: Derive potential test cases
     *
     */
    @Test
    public void leftIsNull() {
        // Test case for null left input.
        // The method should return null List.
        List<Integer> lst = add(null, List.of(3));
        assertNull(lst);
    }

    @Test
    public void rightIsNull() {
        // Test case for null right input.
        // The method should return null List.
        List<Integer> lst = add(List.of(3), null);
        assertNull(lst);
    }

    @Test
    public void leftIsEmpty() {
        // Test case for empty left input.
        // The method should return a List with the right Integer.
        List<Integer> lst = add(List.of(), List.of(3));
        assertEquals(List.of(3), lst);
    }

    @Test
    public void rightIsEmpty() {
        // Test case for empty right input.
        // The method should return a List with the left Integer.
        List<Integer> lst = add(List.of(3), List.of());
        assertEquals(List.of(3), lst);
    }

    @Test
    public void singleInteger() {
        // Test case for single-digit inputs.
        // The method should return the sum of the left and right lists.
        List<Integer> lst = add(List.of(3), List.of(5));
        assertEquals(List.of(8), lst);
    }

    @Test
    public void multipleIntegers() {
        // Test case for multi-digit inputs.
        // The method should return the sum of the left and right lists.
        List<Integer> left = new ArrayList<>();
        left.add(1);
        left.add(2);
        List<Integer> right = new ArrayList<>();
        right.add(3);
        right.add(1);
        List<Integer> lst = add(left, right);
        assertEquals(List.of(4,3), lst);
    }

    @Test
    public void singleAndMultipleIntegers() {
        // Test case for single-digit left input and multi-digit right input.
        // The method should return the sum of the left and right lists.
        List<Integer> left = new ArrayList<>();
        left.add(3);
        List<Integer> right = new ArrayList<>();
        right.add(2);
        right.add(8);
        List<Integer> lst = add(left, right);
        assertEquals(List.of(3,1), lst);
    }

    @Test
    public void largeIntegers() {
        // Test case for large numbers.
        // The method should return the sum of the left and right lists.
        List<Integer> left = new ArrayList<>();
        left.add(9);
        left.add(9);
        left.add(9);
        List<Integer> right = new ArrayList<>();
        right.add(9);
        right.add(9);
        right.add(9);
        List<Integer> lst = add(left, right);
        assertEquals(List.of(1,9,9,8), lst);
    }

    @Test
    public void rightIsNotInRange() {
        // Test case for right element not being in range 0-9
        assertThrows(IllegalArgumentException.class, () -> add(List.of(3), List.of(-2)));
        assertThrows(IllegalArgumentException.class, () -> add(List.of(3), List.of(10)));
    }

    @Test
    public void leftIsNotInRange() {
        // Test case for right element not being in range 0-9
        assertThrows(IllegalArgumentException.class, () -> add(List.of(-2), List.of(3)));
        assertThrows(IllegalArgumentException.class, () -> add(List.of(10), List.of(3)));
    }

    @Test
    public void carry() {
        // Test case for carry of element
        List<Integer> lst = add(List.of(8), List.of(4));
        assertEquals(List.of(1,2), lst);
    }

    @Test
    public void leadingZeros() {
        // Test case for removal of leading zeros
        List<Integer> left = new ArrayList<>();
        left.add(0);
        left.add(3);
        List<Integer> right = new ArrayList<>();
        right.add(4);
        List<Integer> lst = add(left, right);
        assertEquals(List.of(7), lst);
    }
}