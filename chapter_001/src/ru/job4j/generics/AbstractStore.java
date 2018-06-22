package ru.job4j.generics;

/** Хранилище (абстрактный), в нем вся логика
 * @author Vladimir Kovalenko (mailto:skyplane.ru@gmail.com)
 * @version $Id$
 * @since 0.1
 */



public abstract class AbstractStore<T extends Base> implements Store<T> {

    int getIndexById(SimpleArray<T> store, String id) {
        for (int i = 0; i < store.size(); i++) {
            if ((store.get(i)).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }


    boolean replace(SimpleArray<T> store, String id, T model) {
        int index = getIndexById(store, id);
        if (index == -1) {
            return false;
        } else {
            store.set(index, model);
            return true;
        }
    }

    boolean delete(SimpleArray<T> store, String id) {
        int index = getIndexById(store, id);
        if (index == -1) {
            return false;
        } else {
            store.delete(index);
            return true;
        }
    }


    Base findById(SimpleArray<T> store, String id) {
        int index = getIndexById(store, id);
        if (index == -1) {
            return null;
        } else {
            return store.get(index);
        }
    }


}
