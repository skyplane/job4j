package ru.job4j.generics;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StoreTest {

    UserStore userStore;

    @Before
    public void setUp() {
        userStore = new UserStore();
    }

    @Test
    public void testForBasicOperations() {
        User user1 = new User("1");
        User user2 = new User("2");
        userStore.add(user1);
        userStore.replace("1", user2);
        assertThat(userStore.findById("2"), is(user2));
        userStore.delete("2");
    }


}
