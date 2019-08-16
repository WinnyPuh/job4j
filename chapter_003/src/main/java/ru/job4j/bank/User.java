package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывающий клиента банка
 * @author Jora Abjora.
 * @version $.
 * @since 0.1
 */
public class User implements Comparable {
    /**
     * Имя клиента.
     */
    private String name;
    /**
     * Паспорт.
     */
    private String passport;

    public String getPassport() {
        return passport;
    }

    /**
     * Возраст.
     */
    private int age;

    public User(String name, String passport, int age) {
        this.name = name;
        this.passport = passport;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age
                && Objects.equals(name, user.name)
                && Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport, age);
    }

    @Override
    public int compareTo(Object o) {
        User user = (User) o;
        int result = this.name.compareTo(user.name);
        return result;
    }

}
