package ru.job4j.set;

import ru.job4j.list.LinkedContainer;

import java.util.Iterator;

/**
 * Множество на списке
 *
 * @author Vladimir Kovalenko (mailto:skyplane.ru@gmail.com)
 * @version $
 * @since 0.1
 */

public class SimpleLinkedSet<E> extends LinkedContainer<E> {


    @Override
    public void add(E model) {
        if (!contains(model)) {
            super.add(model);
        }
    }


}
