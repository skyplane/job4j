package ru.job4j.generics;

/** Хранилище пользователей
 * @author Vladimir Kovalenko (mailto:skyplane.ru@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class UserStore extends AbstractStore<User> {

    public UserStore() {
        store = new SimpleArray<>(10);
    }


}
