package ru.job4j.generics;

import java.util.*;
import java.util.function.Consumer;

public class SimpleArray<T> implements Iterable<T>{

    private Object[] values;
    private int index = 0;

    public SimpleArray(int size) {
        this.values = new Object[size];
    }

    public void add(T model){
        this.values[index++] = model;
    }

    public void set(int position, T model){
        this.values[position] = model;
    }

    public void delete(int index){
        System.arraycopy(
                values, index + 1,
                values, index, this.index - 1 - index);
        this.index--;
    }

    public T get(int index){
        return (T) values[index];
    }


    public int size(){
        return this.index;
    }


    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator();
    }

    public class SimpleArrayIterator implements Iterator {

        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor <= index;
        }

        @Override
        public Object next() {
            if (cursor<=index){
                return values[cursor++];
            } else {
                throw new NoSuchElementException();
            }
        }

    }


    @Override
    public void forEach(Consumer<? super T> action) {
            Objects.requireNonNull(action);
            for (int i=0; i < this.index; i++) {
                action.accept((T)values[i]);
            }
    }


    @Override
    public Spliterator<T> spliterator() {
        return null;
    }


}
