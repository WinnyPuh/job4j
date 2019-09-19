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
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final PrintStream stdout = System.out; // получаем ссылку на стандартный вывод в консоль.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream(); // Создаем буфур для хранения вывода.
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);
        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };
    private final Tracker tracker = new Tracker(); // создаём Tracker
    private final StringBuilder menu = new StringBuilder()
            .append("0. Add new Item").append(System.lineSeparator())
            .append("1. Show all items").append(System.lineSeparator())
            .append("2. Edit item").append(System.lineSeparator())
            .append("3. Delete item").append(System.lineSeparator())
            .append("4. Find item by Id").append(System.lineSeparator())
            .append("5. Find items by name").append(System.lineSeparator())
            .append("6. Exit program").append(System.lineSeparator())
            .append("7. New action").append(System.lineSeparator()).append(System.lineSeparator());

    @Before
    public void loadOutput() {
        //Заменяем стандартный вывод на вывод в пямять для тестирования.
        System.setOut(new PrintStream(this.out));

    }

    @After
    public void backOutput() {
        // возвращаем обратно стандартный вывод в консоль.
        System.setOut(this.stdout);
    }
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "n", "6", "y"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker, output).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll().get(0).getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "n", "6", "y"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker, output).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findAll().get(0).getName(), is("test replace"));
    }
    @Test
    public void whenDeleteThenTrackerHasNotValue() {
        Item itemFirst = tracker.add(new Item("test first name", "desc"));
        Item itemSecond = tracker.add(new Item("test second name", "desc"));
        Input input = new StubInput(new String[]{"3", itemFirst.getId(), "n", "6", "y"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll().get(0).getName(), is(itemSecond.getName()));
    }

    @Test
    public void whenFindByIDThenTrackerHasValue() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "n", "6", "y"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findById(item.getId()).getId(), is(item.getId()));
    }

    @Test
    public void whenFindByNameThenTrackerHasValue() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"5", item.getName(), "n", "6", "y"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findByName(item.getName()).get(0).getName(), is(item.getName()));
    }

    @Test
    public void whenShowMenu() {
        Input input = new StubInput(new String[]{"6", "y"});
        new StartUI(input, tracker, output).init();
        assertThat(new String(this.out.toByteArray()), is(menu.toString())
        );
    }

    @Test
    public void whenAddItemThenShowAdd() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "n", "6", "y"});
        new StartUI(input, tracker, output).init();
        assertThat(new String(this.out.toByteArray()), is(
                new StringBuilder()
                        .append(menu)
                        .append("------------ Adding new item --------------").append(System.lineSeparator())
                        .append("------------ New Item with Id: ")
                        .append(tracker.findAll().get(0).getId()).append(System.lineSeparator())
                        .append("------------ New Item with Name: ")
                        .append(tracker.findAll().get(0).getName()).append(System.lineSeparator())
                        .append("------------ New Item with Description: ")
                        .append(tracker.findAll().get(0).getDesc()).append(System.lineSeparator())
                        .append(menu)
                .toString())
        );
    }

    @Test
    public void whenClickFiveThenShowItem() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"5", item.getName(), "n", "6", "y"});
        new StartUI(input, tracker, output).init();
        assertThat(new String(this.out.toByteArray()), is(
                new StringBuilder()
                        .append(menu)
                        .append("----------- Search item by name -----------").append(System.lineSeparator())
                        .append(String.format("%12s | %12s | %12s%n", item.getName(), item.getDesc(), item.getId()))
                        .append(System.lineSeparator())
                        .append("-------------------------------------------").append(System.lineSeparator())
                        .append(menu)
                        .toString())
        );
    }

    @Test
    public void whenClickFourThenShowItem() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "n", "6", "y"});
        new StartUI(input, tracker, output).init();
        assertThat(new String(this.out.toByteArray()), is(
                new StringBuilder()
                        .append(menu)
                        .append("------------ Search item by Id ------------").append(System.lineSeparator())
                        .append(String.format("%12s | %12s | %12s%n", item.getName(), item.getDesc(), item.getId()))
                        .append(System.lineSeparator())
                        .append("-------------------------------------------").append(System.lineSeparator())
                        .append(menu)
                        .toString())
        );
    }

    @Test
    public void whenClickOneThenShowAllItem() {
        Item item1 = tracker.add(new Item("first", "desc"));
        Item item2 = tracker.add(new Item("second", "desc"));
        Input input = new StubInput(new String[]{"1", "n", "6", "y"});
        new StartUI(input, tracker, output).init();
        assertThat(new String(this.out.toByteArray()), is(
                new StringBuilder()
                        .append(menu)
                        .append("---------------- All items ----------------").append(System.lineSeparator())
                        .append(String.format("%12s | %12s | %12s%n", item1.getName(), item1.getDesc(), item1.getId()))
                        .append(System.lineSeparator())
                        .append(String.format("%12s | %12s | %12s%n", item2.getName(), item2.getDesc(), item2.getId()))
                        .append(System.lineSeparator())
                        .append("--------------------------------------------").append(System.lineSeparator())
                        .append(menu)
                        .toString())
        );
    }
}
