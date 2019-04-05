package ru.job4j.tracker;

public class StartUI {
    /**
     * Константа меню.
     */
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDBYID = "4";
    private static final String FINDBYNAME = "5";
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showAllItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDBYID.equals(answer)) {
                this.findByIdItem();
            } else if (FINDBYNAME.equals(answer)) {
                this.findByNameItem();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

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
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    private void showAllItems() {
        System.out.println("------------------- Все заявки --------------------");
        for (Item item : tracker.findAll()) {
            System.out.println(item.getName() + " | " + item.getDesc() + " | " + item.getId());
            System.out.printf("%15s%n | %15s%n | %15s%n", item.getName(), item.getDesc(), item.getId());
        }
        System.out.println("---------------------------------------------------");
    }

    private void editItem() {
        System.out.println("------------- Редактирование заявки ---------------");
        String id = this.input.ask("Введите ID заявки для редактирования:");
        String name = this.input.ask("Введите новое имя:");
        String desc = this.input.ask("Введите новое описание:");
        Item result = new Item(name, desc);

        if (tracker.replace(id, result)) {
            System.out.println("---------------- Заявка узменена ------------------");
        } else {
            System.out.println("--------------- Заявка не узменена ----------------");
        }
    }

    private void deleteItem() {
        System.out.println("---------------- Удаление заявки ------------------");
        String id = this.input.ask("Введите ID заявки :");
        if (id != null && tracker.delete(id)) {
            System.out.println("---------------- Заявка удалена -------------------");
        } else {
            System.out.println("--------------- Заявка не удалена -----------------");
        }
    }

    private void findByIdItem() {
        System.out.println("--------------- Поиск заявки по ID-----------------");
        String id = this.input.ask("Введите ID заявки :");
        if (id != null) {
            Item result = tracker.findById(id);
            System.out.printf("%15s%n | %15s%n | %15s%n", result.getName(), result.getDesc(), result.getId());
            System.out.println("---------------------------------------------------");
        } else {
            System.out.println("---------------- Заявка не найдена ----------------");
        }

    }

    private void findByNameItem() {
        System.out.println("------------- Поиск заявки по имени ---------------");
        String name = this.input.ask("Введите имя заявки :");
        Item result[] = tracker.findByName(name);
        for (Item el : result) {
            System.out.printf("%15s%n | %15s%n | %15s%n", el.getName(), el.getDesc(), el.getId());
            System.out.println("---------------------------------------------------");
        }
    }

    private void showMenu() {
        System.out.println("Меню.\n");
        System.out.println("0. Add new Item\n" +
                "1. Show all items\n" +
                "2. Edit item\n" +
                "3. Delete item\n" +
                "4. Find item by Id\n" +
                "5. Find items by name\n" +
                "6. Exit Program\n");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
