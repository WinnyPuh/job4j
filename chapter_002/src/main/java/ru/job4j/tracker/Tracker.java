package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 * @author Jora Abjora.
 * @version $Id$.
 * @since 0.1
 */
public class Tracker {

    /**
     * Массив для хранение заявок.
     */
    private List<Item> items = new ArrayList<>();

    /**
     * Указатель ячейки для новой заявки.
     */

    private static final Random RN = new Random();
    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Метод перезаписывает заявку с идентификатором id на заявку item.
     * @param id - идентификатор заявки.
     * @param item - заявка для замены.
     * @return результат замены.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < this.items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                this.items.set(i, item);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод удалят заявка с идентификатором id.
     * @param id - идентификатор для удаления.
     * @return
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getId().equals(id)) {
                this.items.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод находит все не пустые заявки.
     * @return массив заявок.
     */
    public List<Item> findAll() {
        return this.items;
    }

    /**
     * Метод ищет завяки по ключу.
     * @param key - ключ.
     * @return лист найденых заявок.
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item value : this.items) {
            if (value.getName().equals(key)) {
                result.add(value);
            }
        }
        return result;
    }
    /**
     * Метод реализаущий поиск заявки по id.
     * @param id индекс для поиска.
     * @return заявка с таким id.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item.getId().equals(id)) {
                result = item;
            }
        }
        return result;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }
}
