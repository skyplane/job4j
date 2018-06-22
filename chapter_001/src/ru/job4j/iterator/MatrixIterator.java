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
        if (values.length > row)
            if (values[row].length > cell) {
                return true;
            } else {
                for (int i = row + 1; i < values.length; i++) {
                    if (values[i].length > 0) {
                        return true;
                    }
                }
            }

        return false;
    }

    @Override
    public Object next() {
        if (values[row].length > cell) {
            if (values[row].length == cell + 1) {
                int res = values[row][cell];
                row++;
                cell = 0;
                return res;
            } else {
                return values[row][cell++];
            }
        } else {
            for (int i = row + 1; i < values.length; i++) {
                if (values[i].length > 0) {
                    row = i;
                    cell = 0;
                    return values[row][cell++];
                }
            }
        }
        throw new NoSuchElementException();
    }


}