package ru.job4j.list;

import java.util.*;

/**
 * Организовать сортировку User
 * @author Jora Abjora.
 * @version $.
 * @since 0.1
 */
public class SortUser {
    /**
     * Метод сортирует пользователей по возрасту.
     * @param users лист пользователей.
     * @return сортированный сэт пользователей.
     */
    public Set<User> sort (List<User> users) {
        Set<User> result = new TreeSet<>();
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                return user.compareTo(t1);
            }
        });
        result.addAll(users);
        return result;
    }

    public List<User> sortNameLength (List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                return Integer.compare(user.getName().length(), t1.getName().length());
            }
        });
        return list;
    }

    public List<User> sortByAllFields (List<User> list) {
        sort(list);
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                return user.getName().compareTo(t1.getName());
            }
        });
        return list;
    }
}
