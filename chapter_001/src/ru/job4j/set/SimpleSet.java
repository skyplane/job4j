package ru.job4j.set;

import ru.job4j.generics.SimpleArray;
import ru.job4j.list.SimpleArrayList;

/**
 * Реализация множества
 *
 * @author Vladimir Kovalenko (mailto:skyplane.ru@gmail.com)
 * @version $
 * @since 0.1
 */

public class SimpleSet<T> extends SimpleArray<T> {


    public SimpleSet(int size) {
        super(size);
    }


    @Override
    public void add(T model){
        boolean has = false;
        for (int i=0; i<size(); i++){
            if ((model==null&& get(i)==null) || (model.equals(get(i)))) {
                has = true;
            }
        }
        if (!has){
            super.add(model);
        }
    }


}
