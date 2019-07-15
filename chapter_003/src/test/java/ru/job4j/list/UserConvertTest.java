package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenUserConvert2Map() {
        UserConvert userConvert = new UserConvert();
        HashMap<Integer, User> result = new HashMap<>();
        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User(1, "Vanya", "MSK"));
        userList.add(new User(2, "Petya", "SPB"));
        result = userConvert.process(userList);

        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(1, new User(1, "Vanya", "MSK"));
        expect.put(2, new User(2, "Petya", "SPB"));
        assertThat(result.size(), is(2));
    }
}