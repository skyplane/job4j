package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.list.SimpleQueue;
import ru.job4j.list.SimpleStack;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Тест для простого множества на массиве
 *
 * @author Vladimir Kovalenko (mailto:skyplane.ru@gmail.com)
 * @version $
 * @since 0.1
 */

public class SimpleSetTest {


    private SimpleSet<Integer> set;

    @Before
    public void beforeTest() {
        set = new SimpleSet<>(20);
        set.add(1);
        set.add(2);
        set.add(1);
    }

    @Test
    public void shouldSetExistTwoElements() {
        assertThat(set.size(), is(2));
        Iterator<Integer> it = set.iterator();
        it.next();
        it.next();
        assertThat(it.hasNext(), is(false));
    }

}
