package ru.job4j.list;

import ru.job4j.generics.SimpleArray;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleContainerImpl<E> implements SimpleContainer<E> {


    private static final int START_ARRAY_SIZE = 5;

    private Object[] container;

    private int modCount = 0;

    private int size = 0;
    private int containerSize = START_ARRAY_SIZE;

    public SimpleContainerImpl() {
        container = new Object[START_ARRAY_SIZE];
    }


    @Override
    public Iterator<E> iterator() {
        return new SimpleContainerIterator();
    }

    public class SimpleContainerIterator implements Iterator {

        private int cursor = 0;

        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            return cursor < size;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            expectedModCount++;
            modCount++;
            return container[cursor++];
        }

    }


    @Override
    public void add(E e) {
        if (size >= containerSize) {
            if (containerSize > Integer.MAX_VALUE / 2) {
                throw new OutOfMemoryError();
            }
            containerSize = containerSize * 2;
            container = Arrays.copyOf(container, containerSize);
        }
        container[size++] = e;
        modCount++;
    }

    @Override
    public E get(int index) {
        return (E) container[index];
    }


}
