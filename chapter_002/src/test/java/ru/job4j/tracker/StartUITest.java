package ru.job4j.tracker;
/**
 * @author Jora Abjora.
 * @version $Id$.
 * @since 0.1
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final Tracker tracker = new Tracker(); // создаём Tracker
    private final StringBuilder menu = new StringBuilder()
            .append("Меню.").append(System.lineSeparator()).append(System.lineSeparator())
            .append("0. Add new Item").append(System.lineSeparator())
            .append("1. Show all items").append(System.lineSeparator())
            .append("2. Edit item").append(System.lineSeparator())
            .append("3. Delete item").append(System.lineSeparator())
            .append("4. Find item by Id").append(System.lineSeparator())
            .append("5. Find items by name").append(System.lineSeparator())
            .append("6. Exit Program").append(System.lineSeparator()).append(System.lineSeparator());

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }
    @Test
    public void whenDeleteThenTrackerHasNotValue() {
        Item itemFirst = tracker.add(new Item("test first name", "desc"));
        Item itemSecond = tracker.add(new Item("test second name", "desc"));
        Input input = new StubInput(new String[]{"3", itemFirst.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is(itemSecond.getName()));
    }

    @Test
    public void whenFindByIDThenTrackerHasValue() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getId(), is(item.getId()));
    }

    @Test
    public void whenFindByNameThenTrackerHasValue() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(item.getName())[0].getName(), is(item.getName()));
    }

    private final PrintStream stdout = System.out; // получаем ссылку на стандартный вывод в консоль.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream(); // Создаем буфур для хранения вывода.

    @Before
    public void loadOutput() {
        //Заменяем стандартный вывод на вывод в пямять для тестирования.
        System.setOut(new PrintStream(this.out));

    }

    @After
    public void backOutput() {
        // возвращаем обратно стандартный вывод в консоль.
        System.setOut(stdout);
    }

    @Test
    public void whenShowMenu() {
        Input input = new StubInput(new String[]{"6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(menu.toString())
        );
    }

    @Test
    public void whenAddItemThenShowAdd() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(
                new StringBuilder()
                        .append(menu)
                        .append("------------ Добавление новой заявки --------------").append(System.lineSeparator())
                        .append("------------ Новая заявка с getId : ")
                        .append(tracker.findAll()[0].getId())
                        .append("-----------").append(System.lineSeparator())
                        .append(menu)
                .toString())
        );
    }

    @Test
    public void whenClickFiveThenShowItem() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(
                new StringBuilder()
                        .append(menu)
                        .append("------------- Поиск заявки по имени ---------------").append(System.lineSeparator())
                        .append("      ").append(item.getName())
                        .append(" |            ").append(item.getDesc())
                        .append(" |   ").append(item.getId()).append(System.lineSeparator())
                        .append("---------------------------------------------------").append(System.lineSeparator())
                        .append(menu)
                        .toString())
        );
    }

    @Test
    public void whenClickFourThenShowItem() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(
                new StringBuilder()
                        .append(menu)
                        .append("--------------- Поиск заявки по ID-----------------").append(System.lineSeparator())
                        .append("      ").append(item.getName())
                        .append(" |            ").append(item.getDesc())
                        .append(" |   ").append(item.getId()).append(System.lineSeparator())
                        .append("---------------------------------------------------").append(System.lineSeparator())
                        .append(menu)
                        .toString())
        );
    }

    @Test
    public void whenClickOneThenShowAllItem() {
        Item item1 = tracker.add(new Item("first", "desc"));
        Item item2 = tracker.add(new Item("second", "desc"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(
                new StringBuilder()
                        .append(menu)
                        .append("------------------- Все заявки --------------------").append(System.lineSeparator())
                        .append("          ").append(item1.getName())
                        .append(" |            ").append(item1.getDesc())
                        .append(" |   ").append(item1.getId()).append(System.lineSeparator())
                        .append("         ").append(item2.getName())
                        .append(" |            ").append(item2.getDesc())
                        .append(" |   ").append(item2.getId()).append(System.lineSeparator())
                        .append("---------------------------------------------------").append(System.lineSeparator())
                        .append(menu)
                        .toString())
        );
    }
}
