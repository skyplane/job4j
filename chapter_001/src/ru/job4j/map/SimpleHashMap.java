package ru.job4j.map;

import javafx.util.Pair;
import ru.job4j.list.LinkedContainer;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Реализация простой HashMap
 *
 * @author Vladimir Kovalenko (mailto:skyplane.ru@gmail.com)
 * @version $
 * @since 0.1
 */

public class SimpleHashMap<E, T> implements Iterable {


    private int modCount = 0;

    private Pair<E, T>[] values;
    private int index = 0;
    private int containerSize;

    public SimpleHashMap(int size) {
        this.values = new Pair[size];
        containerSize = size;
    }

    public boolean insert(E key, T value) {
        if (index >= containerSize - 1) {
            containerSize = containerSize * 2;
            Pair<E, T>[] newContainer = new Pair[containerSize];
            for (int i = 0; i <= index; i++) {
                if (values[i] != null) {
                    int position = values[i].getKey().hashCode() & (containerSize - 1);
                    newContainer[position] = values[i];
                }
            }
            values = newContainer;
        }
        int position = key.hashCode() & (containerSize - 1);
        boolean res = false;

        if (values[position] == null) {
            res = true;
            values[position] = new Pair(key, value);
            index++;
            modCount++;
        }

        return res;
    }

    public boolean delete(E key) {
        int position = key.hashCode() & (containerSize - 1);
        boolean res = values[position] != null && values[position].getKey().equals(key);
        if (res) {
            values[position] = null;
            index--;
            modCount--;
        }
        return res;
    }

    public T get(E key) {
        int position = key.hashCode() & (containerSize - 1);
        T res = null;
        if (values[position] != null && values[position].getKey().equals(key)) {
            res = values[position].getValue();
        }
        return res;
    }


    public int size() {
        return this.index;
    }


    @Override
    public Iterator<E> iterator() {
        return new SimpleHashMapIterator();
    }


    public class SimpleHashMapIterator implements Iterator {

        private int indexOfIterator;

        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            while (indexOfIterator < containerSize - 1 && values[indexOfIterator] == null) {
                indexOfIterator++;
            }
            return indexOfIterator <= containerSize - 1
                    ? values[indexOfIterator] != null : false;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            expectedModCount++;
            modCount++;
            return values[indexOfIterator++];
        }

    }


}
