package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор, учитывающий лишь простые числа
 *
 * @author Vladimir Kovalenko (mailto:skyplane.ru@gmail.com)
 * @version $Id$
 * @since 0.1
 */


public class PrimeIterator implements Iterator {

    private final int[] values;

    private int point = 0;

    public PrimeIterator(final int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        for (int i = point; i < values.length; i++) {
            if (isPrime(values[i])) {
                point = i;
                return true;
            }
        }
        return false;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return values[point++];
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(n) + 1; i = i + 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


}
