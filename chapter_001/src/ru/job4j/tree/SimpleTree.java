package ru.job4j.tree;

import java.util.Optional;

public interface SimpleTree<E> extends Iterable<E> {
    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     * @param parent parent.
     * @param child child.
     * @return
     */
    boolean add(E parent, E child);

    Optional<Node> findBy(E value);

}