package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable> implements SimpleTree<E> {

    Node root;

    private int modCount = 0;

    public Tree(E value) {
        this.root = new Node(value);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean res = true;
        if (findBy(child).isPresent()) {
            res = false;
        }
        if (res) {
            Optional<Node> parentOpt = findBy(parent);
            if (!parentOpt.isPresent()) {
                res = false;
            }
            if (res) {
                parentOpt.get().add(new Node(child));
                modCount++;
            }
        }
        return res;
    }

    @Override
    public Optional<Node> findBy(E value) {
        Optional<Node> rsl = Optional.empty();
        Queue<Node> data = new LinkedList();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node child : (List<Node>) el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    public boolean isBinary() {
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        boolean res = true;
        while (nodes.size() > 0) {
            Node current = nodes.remove();
            List<Node> leaves = current.leaves();
            if (leaves.size() > 2) {
                res = false;
                break;
            }
            nodes.addAll(leaves);
        }
        return res;
    }

    @Override
    public Iterator<E> iterator() {
        return new TreeIterator();
    }

    private class TreeIterator implements Iterator<E> {

        private int expectedModCount = modCount;

        private Queue<Node> nodes = new LinkedList<>();

        public TreeIterator() {
            nodes.add(root);
        }

        public boolean hasNext() {
            return nodes.size() > 0;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }

            Node current = nodes.remove();
            nodes.addAll(current.leaves());
            return (E) current.getValue();
        }

    }


}
