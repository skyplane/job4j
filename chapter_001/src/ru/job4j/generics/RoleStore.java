package ru.job4j.generics;

/** Хранилище ролей
 * @author Vladimir Kovalenko (mailto:skyplane.ru@gmail.com)
 * @version $Id$
 * @since 0.1
 */


public class RoleStore extends AbstractStore {


    private SimpleArray<Role> store;

    public RoleStore() {
        store = new SimpleArray<Role>(10);
    }

    @Override
    public void add(Base model) {
        if (!"Role".equals(model.getClassName())) {
            throw new RuntimeException("model is not Role");
        }
        store.add((Role)model);
    }

    @Override
    public boolean replace(String id, Base model) {
        if (!"Role".equals(model.getClassName())) {
            throw new RuntimeException("model is not Role");
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
