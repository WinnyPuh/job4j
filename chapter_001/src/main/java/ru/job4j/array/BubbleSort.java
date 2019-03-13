package ru.job4j.array;

/**
 * 6.5. Создать программу для сортировки массива методом перестановки.[#116916].
 * @author Jora Abjora.
 * @version $Id$.
 * @since 0.1
 */
public class BubbleSort {

    /**
     * Метод сортирует массив алгоритмом пузырек.
     * @param array - массив.
     * @return -  сортированный массив.
     */
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
