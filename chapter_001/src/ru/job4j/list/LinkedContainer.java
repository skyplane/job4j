package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Контейнер с итератором на связанном списке
 *
 * @author Vladimir Kovalenko (mailto:skyplane.ru@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class LinkedContainer<E> implements SimpleContainer<E> {

    private int modCount = 0;
    private int size = 0;

    private Node<E> first;


    public boolean contains(E model){
        Iterator<E> it = iterator();
        boolean has = false;
        while (it.hasNext()){
            E item = it.next();
            if (model.equals(item)) {
                has = true;
            }
        }
        return has;
    }



    @Override
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        first = newLink;
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;

    }


    public E remove(int position) {
        E result = null;

        if (first != null)
            if (position == 0) {
                result = first.data;
                first = first.next;
            } else {
                Node n = first;
                for (int i = 0; i < position - 1; i++) {
                    n = n.next;
                }
                result = (E) n.next.data;
                n.next = n.next.next;
            }

        return result;
    }



    @Override
    public Iterator<E> iterator() {
        return new LinkedContainerIterator();
    }


    public class LinkedContainerIterator implements Iterator {

        private Node<E> cursor = first;

        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            return cursor != null;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            expectedModCount++;
            modCount++;
            E res = cursor.data;
            cursor = cursor.next;
            return res;
        }

    }


    private static class Node<E> {

        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }

    }

    public int size() {
        return size;
    }

}
