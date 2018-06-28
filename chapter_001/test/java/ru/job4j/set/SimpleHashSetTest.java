package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Тесты для простой хеш-таблицы
 *
 * @author Vladimir Kovalenko (mailto:skyplane.ru@gmail.com)
 * @version $
 * @since 0.1
 */

public class SimpleHashSetTest {


    private SimpleHashSet<Integer> set;

    @Before
    public void beforeTest() {
        set = new SimpleHashSet<>(3);

    }

    @Test
    public void shouldSetExistTwoElements() {
        assertThat(set.add(2), is(true));
        assertThat(set.add(1), is(true));
        assertThat(set.add(3), is(true));
        assertThat(set.add(2), is(false));
        assertThat(set.add(4), is(true));
        assertThat(set.add(5), is(true));
        assertThat(set.add(7), is(true));
        assertThat(set.remove(2), is(true));
        assertThat(set.add(6), is(true));
        assertThat(set.contains(3), is(true));
        assertThat(set.contains(2), is(false));
    }


}
