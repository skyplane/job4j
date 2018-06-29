package ru.job4j.map;

import java.util.Calendar;

/**
 * User
 *
 * @author Vladimir Kovalenko (mailto:skyplane.ru@gmail.com)
 * @version $
 * @since 0.1
 */

public class User {

    private String name;

    private int children;

    private Calendar birthday;


    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }


}
