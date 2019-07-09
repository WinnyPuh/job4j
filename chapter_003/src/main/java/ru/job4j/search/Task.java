package ru.job4j.search;

/**
 * Класс описывает задание.
 * @author Jora Abjora.
 * @version $.
 * @since 0.1
 */
public class Task {
    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }


}
