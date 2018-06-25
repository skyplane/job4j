package ru.job4j.generics;

/** Пользователь
 * @author Vladimir Kovalenko (mailto:skyplane.ru@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class User extends Base {

    public User(String id) {
        super(id);
    }

    RoleStore roleStore;

    public RoleStore getRoleStore() {
        return roleStore;
    }

    public void setRoleStore(RoleStore roleStore) {
        this.roleStore = roleStore;
    }
}
