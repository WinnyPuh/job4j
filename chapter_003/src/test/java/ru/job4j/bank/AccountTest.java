package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class AccountTest {
    @Test
    public void whenTwoAccountsEqualsThenTrue() {
        Account first = new Account(213, "ABC1234");
        Account second = new Account(213, "ABC1234");
        assertThat(first.equals(second), is(true));
    }
    @Test
    public void whenTwoAccountsNotEqualsThenFalse() {
        Account first = new Account(213, "ABC1234");
        Account second = new Account(213, "ABC4321");
        assertThat(first.equals(second), is(false));
    }
}