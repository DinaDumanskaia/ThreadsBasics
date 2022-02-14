package com.company;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class IncrementImplTests {
    @Test
    void testIncrementOnce() {
        Incrementer impl = new IncrementerImpl();
        int valueBeforeIncrement = impl.getNumber();
        impl.incrementNumber();
        int valueAfterIncrement = impl.getNumber();

        assertEquals(valueBeforeIncrement + 1, valueAfterIncrement);
        assertTrue(valueBeforeIncrement < valueAfterIncrement);
    }

    @Test
    void testMaximumValueNegativeNumber() {
        Incrementer impl = new IncrementerImpl();
        assertThrows(IllegalArgumentException.class, () -> impl.setMaximumValue(-1));
    }

    @Test
    void testMaximumValueLessThenNumber() {
        Incrementer impl = new IncrementerImpl();
        int currentValue = impl.getNumber();
        assertEquals(0, currentValue);

        impl.incrementNumber();
        currentValue = impl.getNumber();
        assertEquals(1, currentValue);

        impl.setMaximumValue(0);
        currentValue = impl.getNumber();
        assertEquals(0, currentValue);
    }

    @Test
    void testMaximumValueIsGreaterThanCurrentValue() {
        int maximumValue = 30;
        int incrementationNumber = 100;
        Set<Integer> integerSet = new HashSet<>();
        Incrementer impl = new IncrementerImpl();

        impl.setMaximumValue(maximumValue);
        for (int i = 0; i < incrementationNumber; i++) {
            int currentValue = impl.getNumber();
            integerSet.add(currentValue);
            impl.incrementNumber();
        }

        assertEquals(maximumValue, integerSet.size()); // from 0 to 29 (maximum - 1)
        assertTrue(integerSet.contains(0));
        assertTrue(integerSet.contains(maximumValue - 1));
        assertFalse(integerSet.contains(maximumValue));
    }
}
