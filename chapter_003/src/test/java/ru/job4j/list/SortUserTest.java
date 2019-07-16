package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenListThenSortSet() {
        User user1 = new User(1, "Vasja", "MSK", 21);
        User user2 = new User(2, "Petya", "SPB", 20);
        User user3 = new User(3, "Sanya", "TUM", 22);
        List<User> list = new ArrayList<>();
        Set<User> result = new TreeSet<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        SortUser sortUser = new SortUser();
        sortUser.sort(list);
        result.addAll(list);
        assertThat(result.iterator().next().getAge(), is(20));
    }
}