package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс конвертирует матрицу в лист.
 * @author Jora Abjora.
 * @version $.
 * @since 0.1
 */
public class ConvertMatrix2List {
    /**
     * Метод принимает матрицу и возвращает лист.
     * @param array - двумерный массив.
     * @return
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();

        for (int[] arr : array) {
            for (int value : arr) {
                list.add(value);
            }
        }
        return list;
    }
}
