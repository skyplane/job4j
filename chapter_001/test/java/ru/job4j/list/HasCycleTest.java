package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * TODO: add comment
 *
 * @author Vladimir Kovalenko (mailto:skyplane.ru@gmail.com)
 * @version $
 * @since 0.1
 */

public class HasCycleTest {

    Node first = new Node(1);
    Node two = new Node(2);
    Node third = new Node(3);
    Node four = new Node(4);


    @Before
    public void beforeTest() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
    }

    @Test
    public void hasCycleInNodeTest() {
        assertThat(hasCycle(first), is(true));
    }


    class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    boolean hasCycle(Node first) {
        if (first == null) // Список отсутствует
            return false;

        Node slow, fast; // создаем две ссылки, догоняющую и опережающую

        slow = fast = first; // обе стартуют с начала списка

        while (fast != null && fast.next != null) {
            slow = slow.next;           // 1 шаг
            fast = fast.next.next;      // 2 шага

            if (slow == fast) // Если догоняющий совпадает с опережающей, то у нас петля
                return true;
        }
        return false;
    }


}
