package ru.job4j.tracker;

import java.util.List;
/**
 * 3. Используя класс StubInput написать тесты проверяющие поведение пользователя[#116973].
 * @author Jora Abjora.
 * @version $Id$.
 * @since 0.1
 */
public class ValidateInput extends ConsoleInput {

    @Override
    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);

        return value;
    }
}
