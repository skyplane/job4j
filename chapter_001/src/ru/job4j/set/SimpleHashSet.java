package ru.job4j.set;

import javafx.util.Pair;

import java.util.Arrays;

/**
 * Простая реализация хеш-таблицы
 *
 * @author Vladimir Kovalenko (mailto:skyplane.ru@gmail.com)
 * @version $
 * @since 0.1
 */

public class SimpleHashSet<T> {


    private Object[] values;
    private int index = 0;
    private int containerSize;

    public SimpleHashSet(int size) {
        this.values = new Object[size];
        containerSize = size;
    }

    public boolean add(T model) {
        if (index >= containerSize - 1) {
            containerSize = containerSize * 2;
            Object[] newContainer = new Object[containerSize];
            for (int i = 0; i <= index; i++) {
                if (values[i] != null) {
                    int position = values[i].hashCode() & (containerSize - 1);
                    newContainer[position] = values[i];
                }
            }
            values = newContainer;
        }
        int position = model.hashCode() & (containerSize - 1);
        boolean res = false;

        if (!model.equals(values[position])) {
            res = true;
            values[position] = model;
            index++;
        }

        return res;
    }

    public boolean contains(T model) {
        int position = model.hashCode() & (containerSize - 1);
        return values[position] != null;
    }

    public boolean remove(T model) {
        int position = model.hashCode() & (containerSize - 1);
        boolean res = values[position] != null;
        values[position] = null;
        index--;
        return res;
    }


    public int size() {
        return this.index;
    }


}




