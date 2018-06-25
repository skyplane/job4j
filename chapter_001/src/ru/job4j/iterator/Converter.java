package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Слияние элементов нескольких итераторов в один
 *
 * @author Vladimir Kovalenko (mailto:skyplane.ru@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Converter {

    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {

        return new Iterator<Integer>() {

            Iterator<Integer> subiterator;

            {
                if (it.hasNext()) {
                    subiterator = it.next();
                }
            }

            @Override
            public boolean hasNext() {
                while (!subiterator.hasNext() && it.hasNext()) {
                    subiterator = it.next();
                }
                return subiterator.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return subiterator.next();
            }
        };
    }

}
