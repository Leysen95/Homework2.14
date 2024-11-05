package me.skypro.Homework_2._4.model;

import me.skypro.Homework_2._4.exception.ElementNotFoundExcption;
import me.skypro.Homework_2._4.exception.InvalidIndexException;
import me.skypro.Homework_2._4.exception.NullItemException;
import me.skypro.Homework_2._4.exception.StorageIsFullException;

import java.util.Arrays;

public class StringArrayList implements StringList {
    private  String[] array;

    private int size;

    public StringArrayList() {
        this.array = new String[10];
    }

    public StringArrayList(int length) {
        this.array = new String[length];
    }


    @Override
    public String add(String item) {
        validateSize();
        validateItem(item);
        array[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateItem(item);
        validateSize();
        validateIndex(index);
        if (index == size) {
            array[size++] = item;
            return item;
        }

        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateItem(item);
        validateIndex(index);
        array[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);

        return remove(index);
    }

    @Override
    public String remove(int index) {
        validateIndex(index);

        String item = array[index];

        if (index != size) {
            System.arraycopy(array, index + 1, array, index - 1, size - index);
        }

        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(otherList.toArray(), this.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(array, size);
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new NullItemException();
        }
    }
    private void validateSize() {
        if (size >= array.length) {
            throw new StorageIsFullException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
    }


}
