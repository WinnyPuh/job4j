package ru.job4j.tour;

/**
 * Класс содержит профиль клиента.
 * @author Jora Abjora.
 * @version $.
 * @since 0.1
 */
public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
