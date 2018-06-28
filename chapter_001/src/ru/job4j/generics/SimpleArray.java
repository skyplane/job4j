package ru.job4j.generics;

import java.util.*;
import java.util.function.Consumer;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] values;
    private int index = 0;

    public SimpleArray(int size) {
        this.values = new Object[size];
    }

    public boolean contains(T model) {
        boolean has = false;
        for (int i = 0; i < size(); i++) {
            if (model.equals(get(i))) {
                has = true;
            }
        }
        return has;
    }


    public void add(T model) {
        if (index >= values.length) {
            throw new RuntimeException("Index is greater than when the array is initialized");
        }
        values[index++] = model;
    }

    public void set(int position, T model) {
        if (position >= this.index) {
            throw new RuntimeException("Position is greater than array size");
        }
        values[position] = model;
    }

    public void delete(int position) {
        System.arraycopy(
                values, position + 1,
                values, position, this.index - 1 - position);
        this.index--;
    }

    public T get(int position) {
        if (position >= this.index) {
            throw new RuntimeException("Position is greater than array size");
        }
        return (T) values[position];
    }


    public int size() {
        return this.index;
    }


    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator();
    }

    public class SimpleArrayIterator implements Iterator {

        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < index;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return values[cursor++];
        }

    }


}
