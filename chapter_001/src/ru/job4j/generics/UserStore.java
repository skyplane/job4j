package ru.job4j.generics;

/** Хранилище пользователей
 * @author Vladimir Kovalenko (mailto:skyplane.ru@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class UserStore<User> extends AbstractStore {

    private SimpleArray<User> store;

    public UserStore() {
        store = new SimpleArray<User>(10);
    }

    @Override
    public void add(Base model) {
        if (!"User".equals(model.getClassName())) {
            throw new RuntimeException("model is not User");
        }
        store.add((User)model);
    }

    @Override
    public boolean replace(String id, Base model) {
        if (!"User".equals(model.getClassName())) {
            throw new RuntimeException("model is not User");
        }
        return replace(store, id, model);
    }

    @Override
    public boolean delete(String id) {
        return delete(store, id);
    }

    @Override
    public Base findById(String id) {
        return findById(store, id);
    }


}
