package me.skypro.Homework_2._4.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringArrayListTest {
    private StringArrayList list;

    @BeforeEach
    public void setUp() {
        list = new StringArrayList(10);
    }

    @Test
    public void addTest() {
        assertEquals("Hello", list.add("Hello"));
        assertEquals(1, list.size());
        assertEquals("Hello", list.get(0));
    }

    @Test
    public void testAddAtIndex() {
        list.add("First");
        list.add(0, "Zero");
        assertEquals(2, list.size());
        assertEquals("Zero", list.get(0));
        assertEquals("First", list.get(1));
    }

    @Test
    public void setTest() {
        list.add("First");
        list.set(0, "Updated");
        assertEquals("Updated", list.get(0));
    }

    @Test
    public void removeByItemTest() {
       String removedItem = list.remove("Item2");
        assertEquals("Item2", removedItem);
       assertEquals(2, list.size());
       assertFalse(list.contains("Item2"));
    }

    @Test
    public void testRemoveByIndex() {
        String removedItem = list.remove(1);
        assertEquals("Item2", removedItem);
        assertEquals(2, list.size());
        assertFalse(list.contains("Item2"));
    }

    @Test
    public void containsTest() {
        list.add("First");
        assertTrue(list.contains("First"));
        assertFalse(list.contains("Second"));
    }

    @Test
    public void indexOfTest() {
        list.add("First");
        list.add("Second");
        assertEquals(0, list.indexOf("First"));
        assertEquals(-1, list.indexOf("Third"));
    }

    @Test
    public void lastIndexOfTest() {
        list.add("First");
        list.add("Second");
        list.add("First");
        assertEquals(2, list.lastIndexOf("First"));
        assertEquals(-1, list.lastIndexOf("Third"));
    }

    @Test
    public void getTest() {
        list.add("First");
        assertEquals("First", list.get(0));
    }

    @Test
    public void testEquals() {
        StringArrayList anotherList = new StringArrayList(10);
        anotherList.add("First");
        anotherList.add("Second");
        list.add("First");
        list.add("Second");
        assertTrue(list.equals(anotherList));

        anotherList.add("Third");
        assertFalse(list.equals(anotherList));
    }

    @Test
    public void sizeTest() {
        assertEquals(0, list.size());
        list.add("First");
        assertEquals(1, list.size());
    }

    @Test
    public void isEmptyTest() {
        assertTrue(list.isEmpty());
        list.add("First");
        assertFalse(list.isEmpty());
    }

    @Test
    public void clearTest() {
        list.add("First");
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void toArrayTest() {
        list.add("First");
        String[] expectedArray = {"First"};
        assertArrayEquals(expectedArray, list.toArray());
    }
}