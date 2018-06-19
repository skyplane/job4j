package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Итератор, учитывающий лишь четные числа
 *
 * @author Vladimir Kovalenko (mailto:skyplane.ru@gmail.com)
 * @version $Id$
 * @since 0.1
 */



public class EvenNumbersIterator implements Iterator {

    private final int[] values;

    private int iindex = 0;

    public EvenNumbersIterator(final int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        for (int i = iindex ; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object next() {
            for (int i = iindex; i < values.length; i++) {
                if (values[i] % 2 == 0) {
                    iindex = i;
                    return values[iindex++];
                }
            }

        throw new NoSuchElementException();
    }

}
