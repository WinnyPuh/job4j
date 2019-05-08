package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Jora Abjora.
 * @version $Id$.
 * @since 0.1
 */
public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    //private int[] ranges = new int[] {};

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        int value;
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        UserAction newAction = new UserAction() {
            @Override
            public int key() {
                return menu.getPosition();
            }

            @Override
            public void execute(Input input, Tracker tracker) {

            }

            @Override
            public String info() {
                return menu.getPosition() + ". New action";
            }
        };
        menu.addAction(newAction);
        for (int i = 0; i < menu.getActionsLength(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            System.out.println();
            value = input.ask("Select: ", range);
            menu.select(value);
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    /**
     * 1. Создать действия UserAction[#116997].
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker()
        ).init();
    }
}
