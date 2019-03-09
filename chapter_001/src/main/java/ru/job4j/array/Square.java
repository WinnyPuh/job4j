package ru.job4j.array;

/**
 * 6.0. Заполнить массив степенями чисел.[#116910].
 * @author Jora Abjora.
 * @version $Id$.
 * @since 0.1
 */
public class Square {
    /**
     * Метод заполняет массив числами, возведенными в квадрат.
     * @param bound - размер массива.
     * @return - массив.
     */
    public int[] calculate(int bound) {
        int[] result = new int[bound];
        for (int i = 0; i < bound; i++) {
            result[i] = (i + 1) * (i + 1);
        }
        return result;
    }
}
