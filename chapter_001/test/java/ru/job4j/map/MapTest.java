package ru.job4j.map;

import org.junit.Ignore;
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * tests for map
 *
 * @author Vladimir Kovalenko (mailto:skyplane.ru@gmail.com)
 * @version $
 * @since 0.1
 */

public class MapTest {


    @Ignore
    @Test
    public void testForMap() {
        User user1 = new User("name", 1, new GregorianCalendar(1, 1, 1));
        User user2 = new User("name", 1, new GregorianCalendar(1, 1, 1));

        Map<User, Object> map = new HashMap<>();

        map.put(user1, "first");
        map.put(user2, "second");

        map.get(user1);
        map.get(user2);

        System.out.println(map.get(user1));
        System.out.println(map.get(user2));
        System.out.println(map);


    }


}
