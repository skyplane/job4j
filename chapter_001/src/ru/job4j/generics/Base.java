package ru.job4j.generics;

/**
 * @author Petr Arsentev (mailto:parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public abstract class Base {
    private final String id;

    String className = "Base";

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getClassName(){
        return className;
    }

}