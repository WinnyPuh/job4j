package ru.job4j.tour;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class ProfilesTest {
    Address addressFirst = new Address("Moscow", "red", 1, 1);
    Address addressSecond = new Address("NY", "Main", 1, 1);
    Address addressThird = new Address("SPB", "Nevskiy", 2, 1);
    Address addressFourth = new Address("Kiev", "Main", 3, 5);
    List<Profile> profileList = new ArrayList<>(Arrays.asList(
            new Profile(addressFirst),
            new Profile(addressSecond),
            new Profile(addressThird),
            new Profile(addressFourth)));
    @Test
    public void getAddressesToList() {
        List<Address> expect = new ArrayList<>(Arrays.asList(
                new Address("Kiev", "Main", 3, 5),
                new Address("Moscow", "red", 1, 1),
                new Address("NY", "Main", 1, 1),
                new Address("SPB", "Nevskiy", 2, 1)
        ));
        Profiles profiles = new Profiles();
        List<Address> result = profiles.collect(profileList);
        Assert.assertThat(result, is(expect));
    }
    @Test
    public void getAddressesToListWithoutTake() {
        List<Address> expect = new ArrayList<>(Arrays.asList(
                new Address("Kiev", "Main", 3, 5),
                new Address("Moscow", "red", 1, 1),
                new Address("NY", "Main", 1, 1),
                new Address("SPB", "Nevskiy", 2, 1)
        ));
        Profiles profiles = new Profiles();
        profileList.add(new Profile(new Address("Moscow", "red", 1, 1)));
        List<Address> result = profiles.collect(profileList);
        Assert.assertThat(result, is(expect));
    }
}