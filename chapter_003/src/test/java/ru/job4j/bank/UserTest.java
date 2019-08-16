package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTest {
    @Test
    public void whenTwoUsersEqualsThenTrue() {
        User first = new User("Vasja", "123456", 18);
        User second = new User("Vasja", "123456", 18);
        assertThat(first.equals(second), is(true));
    }

    @Test
    public void whenTwoUsersNotEqualsThenFalse() {
        User first = new User("Vasja", "123456", 18);
        User second = new User("Vasja", "654321", 18);
        assertThat(first.equals(second), is(false));
    }
}