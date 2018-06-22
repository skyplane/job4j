package ru.job4j.generics;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.iterator.EvenNumbersIterator;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {

    SimpleArray<Integer> array;

    @Before
    public void setUp(){

        array = new SimpleArray<>(10);

    }

    @Test
    public void test () {

        array.add(1);
        array.add(1);
        array.add(3);
        array.add(4);

        array.set(1,2);
        array.delete(2);
        assertThat(array.size(), is(3));
        assertThat(array.get(1), is(2));
        assertThat(array.get(2), is(4));

    }


}
