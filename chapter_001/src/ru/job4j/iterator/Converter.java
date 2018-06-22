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

            Iterator<Integer> currentForHasNext;

            {
                if (it.hasNext())
                    moveCaretToNextElem();
            }


            private void moveCaretToNextElem() {
                do {
                    currentForHasNext = it.next();
                } while (!currentForHasNext.hasNext() && it.hasNext());
            }


            @Override
            public boolean hasNext() {
                if (currentForHasNext.hasNext()) {
                    return true;
                } else if (it.hasNext()) {
                        moveCaretToNextElem();
                        return currentForHasNext.hasNext();

                }
                return false;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return currentForHasNext.next();
            }
        };
    }

}
