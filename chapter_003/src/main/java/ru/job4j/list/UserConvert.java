package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

/**
 * @author Jora Abjora.
 * @version $.
 * @since 0.1
 */
public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<>();
        for (User user : list) {
            map.put(user.getId(), user);
        }
        return map;
    }
}
