package ru.job4j.tracker;

import java.util.Objects;

/**
 *
 * @author Jora Abjora.
 * @version $Id$.
 * @since 0.1
 */
public class Item {
    private String id;
    private String name;
    private String desc;
    private long time;

    public Item(String name, String desc, long time) {
        this.name = name;
        this.desc = desc;
        this.time = time;
    }

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public long getTime() {
        return time;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return time == item.time
                && Objects.equals(id, item.id)
                && Objects.equals(name, item.name)
                && Objects.equals(desc, item.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, desc, time);
    }
}
