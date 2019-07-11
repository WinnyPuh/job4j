package ru.job4j.list;

/**
 * Класс описывающий пользователя.
 * @author Jora Abjora.
 * @version $.
 * @since 0.1
 */
public class User {
    /**
     * Идентификатор пользователя.
     */
    private int id = 0;
    /**
     * Имя пользователя.
     */
    private String name;
    /**
     * Город пользователя.
     */
    private String city;

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }
}
