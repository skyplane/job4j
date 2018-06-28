package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор для работы с матрицей, учитывает элементы {}
 *
 * @author Vladimir Kovalenko (mailto:skyplane.ru@gmail.com)
 * @version $Id$
 * @since 0.1
 */


public class MatrixIterator implements Iterator {


    private final int[][] values;

    private int row = 0, cell = 0;


    public MatrixIterator(final int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return values.length > row && values[row].length > cell;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        int result;
        if (values[row].length - 1 > cell) {
            result = values[row][cell++];
        } else {
            result = values[row++][cell];
            cell = 0;
        }

        return result;
    }


}