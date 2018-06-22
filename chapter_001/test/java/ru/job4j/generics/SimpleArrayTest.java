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

    @Test
    public void forEachTest () {
        AtomicInteger sum = new AtomicInteger(0);
        array.forEach(item->{
            sum.addAndGet(item);
        });
        assertThat(sum.get(), is(10));
    }

    @Test
    public void testForIterator() {
        Iterator<Integer> it = array.iterator();

        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(false));
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
