package ru.job4j.map;

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.hamcrest.Matchers.is;

/**
 * SimpleHashMap tests
 *
 * @author Vladimir Kovalenko (mailto:skyplane.ru@gmail.com)
 * @version $
 * @since 0.1
 */

public class SimpleHashMapTest {

    @Ignore
    @Test
    public void testForMap() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<String, Integer>(3);

        Assert.assertTrue(map.insert("first", 1));

        Assert.assertFalse(map.insert("second", 2));
        Assert.assertTrue(map.insert("third", 3));
        Assert.assertTrue(map.insert("four", 4));
        Assert.assertFalse(map.insert("fifth", 5));

        Assert.assertThat(map.get("first"), is(1));
        Assert.assertNull(map.get("second"));

        Assert.assertTrue(map.delete("first"));

        Assert.assertNull(map.get("first"));

        Iterator it = map.iterator();

        Assert.assertTrue(it.hasNext());
        Assert.assertThat(it.next(), is(new Pair("four", 4)));
        Assert.assertThat(it.next(), is(new Pair("third", 3)));
        Assert.assertFalse(it.hasNext());

    }


}
