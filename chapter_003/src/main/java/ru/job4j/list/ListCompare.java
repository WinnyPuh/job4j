package ru.job4j.list;

import java.util.Comparator;

/**
 * 3. Компаратор для строк.[#116948]
 * @author Jora Abjora.
 * @version $.
 * @since 0.1
 */
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int len = Math.min(left.length(), right.length());
        int result = 0;
        for (int i = 0; i < len; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                break;
            }
        }
        if ((result == 0) && (left.length() != right.length())) {
            result = (left.length() < right.length() ? -1 : 1);
        }
        return result;
    }
}
