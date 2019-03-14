package ru.job4j.array;

import java.util.Arrays;

/**
 * 6.8. Удаление дубликатов в массиве.[#116917].
 * @author Jora Abjora.
 * @version $Id$.
 * @since 0.1
 */
public class ArrayDuplicate {

    /**
     * Метод удаляет дубли из массива.
     * @param array - массив.
     * @return - массив без дублей.
     */
    public String[] remove(String[] array) {
        for (int i = 0; i < array.length; i++) {
            String value = array[i];
            for (int j = i + 1; j < array.length;) {
                if (value.equals(array[j])) {
                    array[j] = array[array.length - 1];
                    array = Arrays.copyOf(array, array.length - 1);
                } else {
                    j++;
                }
            }
        }
        return array;
    }
}
