package ru.job4j.list;

public class SimpleQueue<T> extends LinkedContainer<T> {

    public T poll() {
        return this.remove(this.size() - 1);
    }

    public void push(T value) {
        this.add(value);
    }

}