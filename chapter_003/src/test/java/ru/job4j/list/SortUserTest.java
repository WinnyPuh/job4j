package ru.job4j.list;

import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    User user1 = new User(1, "Vasja", "MSK", 21);
    User user2 = new User(2, "Petya", "SPB", 20);
    User user3 = new User(3, "Sany", "TUM", 22);
    User user4 = new User(4, "Sany", "MSK", 19);
    List<User> list = new ArrayList<>();
    Set<User> result = new TreeSet<>();
    SortUser sortUser = new SortUser();

    @Test
    public void whenListThenSortSet() {
        list.add(user1);
        list.add(user2);
        list.add(user3);
        sortUser.sort(list);
        result.addAll(list);
        assertThat(result.iterator().next().getAge(), is(20));
    }
    @Test
    public void whenNeedSortByAllFields() {
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        sortUser.sortByAllFields(list);
        result.addAll(list);
        assertThat(result.iterator().next().getAge(), is(19));
    }
}