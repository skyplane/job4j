package ru.job4j.generics;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.iterator.EvenNumbersIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {

    SimpleArray<Integer> array;

    @Before
    public void setUp(){

        array = new SimpleArray<>(10);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
    }

    @Test
    public void testForBasicOperations () {
        array.set(1,5);
        array.delete(2);
        assertThat(array.size(), is(3));
        assertThat(array.get(1), is(5));
        assertThat(array.get(2), is(4));
    }

    @Test(expected = RuntimeException.class)
    public void whenDeleteBiggerIndexShouldReturnException() {
        array.delete(11);
    }

    @Test(expected = RuntimeException.class)
    public void whenSetBiggerIndexShouldReturnException () {
        array.set(11, 12);
    }

    @Test(expected = RuntimeException.class)
    public void whenAddTooManyElementsShouldReturnException () {
        array.add(1);
        array.add(1);
        array.add(1);
        array.add(1);
        array.add(1);
        array.add(1);
        array.add(1);
    }


}
