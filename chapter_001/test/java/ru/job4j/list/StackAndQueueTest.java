package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Тест для стека и очереди
 *
 * @author Vladimir Kovalenko (mailto:skyplane.ru@gmail.com)
 * @version $
 * @since 0.1
 */

public class StackAndQueueTest {


    private SimpleStack<Integer> stack;
    private SimpleQueue<Integer> queue;

    @Before
    public void beforeTest() {
        stack = new SimpleStack<>();
        queue = new SimpleQueue<>();
        stack.add(1);
        stack.add(2);
        queue.add(1);
        queue.add(2);
    }

    @Test
    public void shouldStackGetLastElemAndQueueGetFirst () {
        assertThat(stack.poll(), is(2));
        assertThat(queue.poll(), is(1));
    }

}
