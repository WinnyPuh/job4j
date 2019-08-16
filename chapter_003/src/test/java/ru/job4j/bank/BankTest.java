package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankTest {
    @Test
    public void whenAddUserWhetGetAcc() {
        User user = new User("Vasja", "123456", 18);
        Account acc = new Account(123, "ABC1234");
        Bank bank = new Bank();
        bank.addUser(user);
        bank.addAccountToUser("123456", acc);
        assertThat(bank.getUserAccount("123456", "ABC1234"), is(acc));
    }
}