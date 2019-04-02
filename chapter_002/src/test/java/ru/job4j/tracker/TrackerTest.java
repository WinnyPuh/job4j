package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1","testDescription",created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L);

        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2","testDescription2",1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteItemThenTrackerDoesNotHaveSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertTrue(tracker.delete(item.getId()));
    }

    @Test
    public void whenAddTwoItemsThanGetAllIsTwo() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1","testDescription",123L);
        Item second = new Item("test2","testDescription2",1234L);
        tracker.add(first);
        tracker.add(second);
        assertThat(tracker.findAll().length, is(2));
    }

    @Test
    public void whenAddItemThenItWillBeFind() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1","testDescription",123L);
        Item second = new Item("test2","testDescription2",1234L);
        tracker.add(first);
        tracker.add(second);
        Item[] items = tracker.findAll();
        String id = items[0].getId();
        assertThat(tracker.findById(id), is(first));
    }

    @Test
    public void whenFindByNameThenTrackerHasItems() {
        Tracker tracker = new Tracker();
        Item[] items = {new Item("test1", "testDescription1", 123L),
                new Item("test2", "testDescription2", 124L),
                new Item("test1", "testDescription3", 125L)};
        for (Item el : items) {
            tracker.add(el);
        }
        int count = tracker.findByName("test1").length;
        assertThat(count, is(2));
    }
}