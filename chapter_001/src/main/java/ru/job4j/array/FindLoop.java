package ru.job4j.array;

/**
 * 6.1. Классический поиск перебором.[#116911].
 * @author Jora Abjora.
 * @version $Id$.
 * @since 0.1
 */
public class FindLoop {
    /**
     * Метод ищет el в массиве data и возвращает индекс.
     * @param data - массив.
     * @param el - искомое.
     * @return - индекс.
     */
    public int indexOf(int[] data, int el) {
        int result = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                result = index;
                break;
            }
        }
        return result;
    }
}
