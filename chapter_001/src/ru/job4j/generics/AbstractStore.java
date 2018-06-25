package ru.job4j.generics;

/**
 * Хранилище (абстрактный), в нем вся логика
 *
 * @author Vladimir Kovalenko (mailto:skyplane.ru@gmail.com)
 * @version $Id$
 * @since 0.1
 */


public abstract class AbstractStore<T extends Base> implements Store<T> {

    SimpleArray<T> store;

    private int getIndexById(SimpleArray<T> store, String id) {
        for (int i = 0; i < store.size(); i++) {
            if ((store.get(i)).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void add(T model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = getIndexById(store, id);
        if (index >= 0) {
            store.set(index, model);
        }
        return index >= 0;
    }

    @Override
    public boolean delete(String id) {
        int index = getIndexById(store, id);
        if (index >= 0) {
            store.delete(index);
        }
        return index >=0;
    }

    @Override
    public T findById(String id) {
        int index = getIndexById(store, id);
        return index >= 0 ? store.get(index) : null;
    }


}
