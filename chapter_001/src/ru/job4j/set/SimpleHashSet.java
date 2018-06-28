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


    private Pair<Integer, T>[] values;
    private int index = 0;
    private int containerSize;


    public SimpleHashSet(int size) {
        this.values = new Pair[size];
        containerSize = size;
    }


    private static final double PHI = (1 + Math.sqrt(5)) / 2;

    private int findNearestIndexWithExistCheck(int hash, boolean exist) {
        int result = 0;
        if (size() > 0) {
            int x1, x2;
            int a = 0;
            int b = size() - 1;
            if (hash > values[size() - 1].getKey()) {
                result = size();
            } else {
                while (true) {
                    x1 = (int) Math.round(values[b].getKey() - (values[b].getKey() - values[a].getKey()) / PHI);
                    x2 = (int) Math.round(values[a].getKey() + (values[b].getKey() - values[a].getKey()) / PHI);
                    if (Math.abs(x1 - hash) > Math.abs(x2 - hash)) {
                        a = (int) Math.round(b - (b - a) / PHI);
                    } else {
                        b = (int) Math.round(a + (b - a) / PHI);
                    }
                    if (Math.abs(b - a) < 2) {
                        if (values[a].getKey().equals(hash)) {
                            result = exist ? a : -1;
                            break;
                        }
                        if (values[b].getKey().equals(hash)) {
                            result = exist ? b : -1;
                            break;
                        }
                        result = exist ? -1 : Math.max(a, b);
                        break;
                    }
                }
            }
        }
        return result;
    }

    public boolean contains(T model) {
        return findNearestIndexWithExistCheck(model.hashCode(), true) >= 0;
    }

    public boolean add(T model) {
        int position = findNearestIndexWithExistCheck(model.hashCode(), false);
        if (position >= 0) {
            if (index >= containerSize) {
                if (containerSize > Integer.MAX_VALUE / 2) {
                    throw new OutOfMemoryError();
                }
                containerSize = containerSize * 2;
                values = Arrays.copyOf(values, containerSize);
            }

            if (position < index) {
                System.arraycopy(
                        values, position,
                        values, position + 1, this.index - position);
            }
            if (size() > 0) {
                values[position] = new Pair<>(model.hashCode(), model);
            } else {
                values[position] = new Pair<>(model.hashCode(), model);
            }
            index++;
        }
        return position >= 0;
    }

    public boolean remove(T model) {
        int position = findNearestIndexWithExistCheck(model.hashCode(), true);
        if (position >= 0) {
            System.arraycopy(
                    values, position + 1,
                    values, position, this.index - position - 1);
            index--;
        }
        return position >= 0;
    }


    public int size() {
        return this.index;
    }


}




