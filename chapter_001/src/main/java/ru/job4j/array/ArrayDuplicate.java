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
        int unique = array.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out + 1; in < unique; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[unique - 1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}
