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

public class LinkedContainer<E> implements SimpleContainer<E>{

    private int modCount = 0;
    private int size = 0;

    private Node<E> first;

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
            return cursor!=null;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            expectedModCount++;
            modCount++;
            E res = cursor.data;
            cursor=cursor.next;
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

    public int size(){
        return size;
    }

}
