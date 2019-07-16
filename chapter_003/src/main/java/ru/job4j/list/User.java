package ru.job4j.list;

/**
 * Класс описывающий пользователя.
 * @author Jora Abjora.
 * @version $.
 * @since 0.1
 */
public class User implements Comparable<User>{
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
    /**
     * Возрост пользователя.
     */
    private int age;

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public User(int id, String name, String city, int age) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(User o) {
        return Integer.compare(this.age, o.age);
    }
}
