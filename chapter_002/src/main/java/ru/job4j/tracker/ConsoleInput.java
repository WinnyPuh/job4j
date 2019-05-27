package ru.job4j.tracker;

import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Jora Abjora.
 * @version $Id$.
 * @since 0.1
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, List<Integer> range) {
        int result = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == result) {
                exist = true;
                break;
            }
        }

        if (!exist) {
            throw new MenuOutException("Out of menu range.");
        }
        return result;
    }
}
