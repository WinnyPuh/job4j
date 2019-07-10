package ru.job4j.list;

import java.util.List;

/**
 * Конвертация ArrayList в двухмерный массив.
 * @author Jora Abjora.
 * @version $.
 * @since 0.1
 */
public class ConvertList2Array {
    /**
     * Метод принимает лист и возвращает матрицу.
     * @param list - ArrayList для конвертации.
     * @param rows - количесво строк.
     * @return
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size()/rows + (list.size()%rows > 0 ? 1 : 0);
        int[][] array = new int[rows][cells];
        int row = 0;
        int cell = 0;
        for (Integer value : list) {
            array[cell][row] = value;
            row++;
            if (row > rows - 1) {
                row = 0;
                cell++;
            }
        }
        return array;
    }
}
