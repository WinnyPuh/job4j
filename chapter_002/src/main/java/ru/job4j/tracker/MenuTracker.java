package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author Jora Abjora.
 * @version $Id$.
 * @since 0.1
 */
public class MenuTracker {
    /**
     * @param keeps object reference.
     */
    private Input input;
    /**
     * @param keeps object reference.
     */
    private Tracker tracker;
    /**
     * @param keeps array type UserAction reference.
     */
    private final Consumer<String> output;

    private List<UserAction> actions = new ArrayList<>();
    private int position = 0;

    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Construction.
     * @param input object type Input.
     * @param tracker object type Tracker.
     * @param output object type Consumer<String>.
     */
    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }
    /**
     * Method to get menu array.
     * @return array length
     */
    public int getActionsLength() {
        return this.actions.size();
    }
    /**
     * Method fills array.
     */
    public void fillActions() {
        this.actions.add(new AddItem(position++, "Add new Item"));
        this.actions.add(new ShowItem(position++, "Show all items"));
        this.actions.add(new UpdateItem(position++, "Edit item"));
        this.actions.add(new DeleteItem(position++, "Delete item"));
        this.actions.add(new FindItemById(position++, "Find item by Id"));
        this.actions.add(new FindItemsByName(position++, "Find items by name"));
        this.actions.add(new ExitProgram(position++, "Exit program"));
    }

    public void addAction(UserAction action) {
        this.actions.add(action);
    }
    /**
     *
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
            }
        }
    }

    private class AddItem extends BaseAction {

        public AddItem(int num, String str) {
            super(num, str);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Adding new item --------------");
            String name = input.ask("Please, provide item name: ");
            String desc = input.ask("Please, provide item desc: ");
            Item item = new Item(name, desc);
            tracker.add(item);
            output.accept("------------ New Item with Id: " + item.getId());
            output.accept("------------ New Item with Name: " + item.getName());
            output.accept("------------ New Item with Description: " + item.getDesc());
        }
    }

    private class ShowItem extends BaseAction {

        public ShowItem(int num, String str) {
            super(num, str);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("---------------- All items ----------------");
            for (Item item : tracker.findAll()) {
                output.accept(String.format("%12s | %12s | %12s%n", item.getName(), item.getDesc(), item.getId()));
            }
            output.accept("--------------------------------------------");
        }
    }

    private class UpdateItem extends BaseAction {

        public UpdateItem(int num, String str) {
            super(num, str);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("--------------- Edit item -----------------");
            String id = input.ask("Please, provide ID item for edit: ");
            String name = input.ask("Please, provide item new name: ");
            String desc = input.ask("Please, provide item new desc: ");
            Item result = new Item(name, desc);

            if (tracker.replace(id, result)) {
                output.accept("--------------- Item changed --------------");
            } else {
                output.accept("----------- Item doesn't changed ----------");
            }
        }
    }

    private class DeleteItem extends BaseAction {

        public DeleteItem(int num, String str) {
            super(num, str);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("-------------- Delete item ----------------");
            String id = input.ask("Please, provide ID item for delete: ");
            if (id != null && tracker.delete(id)) {
                output.accept("--------------- Item delete ---------------");
            } else {
                output.accept("------------ Item didn't delete -----------");
            }
        }
    }

    private class FindItemById extends BaseAction {

        public FindItemById(int num, String str) {
            super(num, str);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Search item by Id ------------");
            String id = input.ask("Please, provide ID item for search: ");
            Item result = tracker.findById(id);
            if (id != null && result != null) {
                output.accept(String.format("%12s | %12s | %12s%n", result.getName(), result.getDesc(), result.getId()));
                output.accept("-------------------------------------------");
            } else {
                output.accept("------------- Item didn't find ------------");
            }
        }
    }

    private class FindItemsByName extends BaseAction {

        public FindItemsByName(int num, String str) {
            super(num, str);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("----------- Search item by name -----------");
            String name = input.ask("Please, provide name item for search: ");
            List<Item> result = tracker.findByName(name);
            for (Item el : result) {
                output.accept(String.format("%12s | %12s | %12s%n", el.getName(), el.getDesc(), el.getId()));
                output.accept("-------------------------------------------");
            }
        }
    }

    private class ExitProgram extends BaseAction {

        public ExitProgram(int num, String str) {
            super(num, str);
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }
    }
}
