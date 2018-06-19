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


public class PrimeIterator  implements Iterator {

    private final int[] values;

    private int iindex = 0;

    public PrimeIterator(final int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        for (int i = iindex ; i < values.length; i++) {
            if (isPrime(values[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object next() {
        for (int i = iindex; i < values.length; i++) {
            if (isPrime(values[i])) {
                iindex = i;
                return values[iindex++];
            }
        }

        throw new NoSuchElementException();
    }

    private static boolean isPrime(int n) {
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
