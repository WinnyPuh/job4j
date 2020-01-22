package ru.job4j.tour;

import java.util.Objects;

/**
 * Класс содержит адрес клиента.
 * @author Jora Abjora.
 * @version $.
 * @since 0.1
 */
public class Address {
    private String city;
    private String street;
    private int home;
    private int apartment;

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Address address = (Address) o;

        return city.equals(address.city)
                && street.equals(address.street)
                && home == address.home
                && apartment == address.apartment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }
}
