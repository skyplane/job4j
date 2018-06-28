package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.Queue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Тест для функции определения цикличности списка
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



/*
    Метод, определяющий нахождение цикла в цепочке,
    Стартуют две ноды, медленная и быстрая, если они совпадут - значит имеем цикл
*/

    boolean hasCycle(Node first) {
        Node slow, fast;
        slow = fast = first;
        boolean result = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                result = true;
                break;
            }

        }
        return result;
    }


}
