package io.github.ricardosander.datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyVectorTest {

    @Test
    void newVector_shouldBeEmpty() {

        var vector = new MyVector();

        assertTrue(vector.isEmpty());
        assertEquals(0, vector.size());
    }

    @Test
    void vectorShouldNotBeEmpty_afterOneElementAdded() {

        var vector = new MyVector();
        vector.add("first");

        assertFalse(vector.isEmpty());
        assertEquals(1, vector.size());
    }

    @Test
    void shouldReturnFirstElement_afterOneElementAdded() {

        var vector = new MyVector();
        vector.add("first");

        assertEquals("first", vector.get(0));
    }

    @Test
    void shouldReturnFirstAndSecondElements_afterTwoElementsAdded() {

        var vector = new MyVector();
        vector.add("first");
        vector.add("second");

        assertEquals("first", vector.get(0));
        assertEquals("second", vector.get(1));
    }

    @Test
    void shouldThrowIllegalArgumentException_whenTryRetrieveInvalidPosition() {

        var vector = new MyVector();
        vector.add("first");

        assertThrows(
                IllegalArgumentException.class,
                () -> vector.get(1)
        );
    }

    @Test
    void shouldResizeMyVector_afterAddingBeyondInitialSize() {

        var vector = new MyVector(10);
        int index = 0;
        for (; index < 10; index++) {
            vector.add(String.valueOf(index));
        }
        vector.add("beyond");

        assertEquals("beyond", vector.get(index));
    }

    @Test
    void shouldBeAbleToInsertAElementInTheMiddle() {

        var vector = new MyVector();
        vector.add("first");
        vector.add("third");
        vector.add("second", 1);

        assertEquals("first", vector.get(0));
        assertEquals("second", vector.get(1));
        assertEquals("third", vector.get(2));
    }

    @Test
    void shouldBeAbleToInsertAElementInTheBeginning() {

        var vector = new MyVector();
        vector.add("second");
        vector.add("third");
        vector.add("first", 0);

        assertEquals("first", vector.get(0));
        assertEquals("second", vector.get(1));
        assertEquals("third", vector.get(2));
    }

    @Test
    void shouldBeAbleToInsertAElementInTheEnd() {

        var vector = new MyVector();
        vector.add("first");
        vector.add("second");
        vector.add("third", 2);

        assertEquals("first", vector.get(0));
        assertEquals("second", vector.get(1));
        assertEquals("third", vector.get(2));
    }

    @Test
    void shouldBeAbleToCheckIfAElementExists() {

        var vector = new MyVector();
        vector.add("first");

        assertTrue(vector.contains("first"));
        assertFalse(vector.contains("second"));
    }

    @Test
    void shouldBeAbleToRemoveLastElementByIndex() {

        var vector = new MyVector();
        vector.add("first");
        vector.add("second");
        vector.add("third");

        var element = vector.remove(2);
        assertEquals("third", element);
        assertFalse(vector.contains("third"));
        assertEquals(2, vector.size());
    }

    @Test
    void shouldBeAbleToRemoveFirstElementByIndex() {

        var vector = new MyVector();
        vector.add("first");
        vector.add("second");
        vector.add("third");

        var element = vector.remove(0);
        assertEquals("first", element);
        assertFalse(vector.contains("first"));
        assertEquals(2, vector.size());
    }

    @Test
    void shouldBeAbleToRemoveMiddleElementByIndex() {

        var vector = new MyVector();
        vector.add("first");
        vector.add("second");
        vector.add("third");

        var element = vector.remove(1);
        assertEquals("second", element);
        assertFalse(vector.contains("second"));
        assertEquals(2, vector.size());
    }
}
