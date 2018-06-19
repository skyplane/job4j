package ru.job4j.iterator;

import java.util.Iterator;

/**
 * Итератор для работы с матрицей, учитывает элементы {}
 *
 * @author Vladimir Kovalenko (mailto:skyplane.ru@gmail.com)
 * @version $Id$
 * @since 0.1
 */


public class MatrixIterator implements Iterator {


    private final int[][] values;

    private int iindex = 0, jindex = 0;


    public MatrixIterator(final int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        if (values.length > iindex) {
            if (values[iindex].length > jindex) {
                return true;
            } else {
                for (int i = iindex + 1; i < values.length; i++) {
                    if (values[i].length > 0) {
                        return true;
                    }
                }
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        if (values[iindex].length > jindex) {
            if (values[iindex].length == jindex + 1) {
                int res = values[iindex][jindex];
                iindex++;
                jindex = 0;
                return res;
            } else {
                return values[iindex][jindex++];
            }
        } else {
            for (int i = iindex + 1; i < values.length; i++) {
                if (values[i].length > 0) {
                    iindex = i;
                    jindex = 0;
                    return values[iindex][jindex++];
                }
            }
        }
        return null;
    }


}