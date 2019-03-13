package ru.job4j.array;

/**
 * 6.6. Двухмерный массив. Таблица умножения.[#116912].
 * @author Jora Abjora.
 * @version $Id$.
 * @since 0.1
 */
public class Matrix {

    /**
     * Метод создает двумерный массив.
     * @param size - размер массива.
     * @return -  двумерный массив.
     */
    public int[][] multiple(int size) {
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = (i + 1) * (j + 1);
            }
        }
        return result;
    }
}
