package ru.job4j.list;

public class SimpleStack<T> extends LinkedContainer<T>{

    public T poll(){
        return this.get(0);
    }

    public void push(T value){
        this.add(value);
    }

}