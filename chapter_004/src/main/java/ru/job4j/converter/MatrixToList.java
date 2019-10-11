package ru.job4j.converter;

import java.util.List;
import java.util.stream.Collectors;

/**Класс для конвертирования двумерного массива в список.
 * @author Jora Abjora.
 * @version $.
 * @since 0.1
 */
public class MatrixToList {
    public List<Integer> converter(List<List<Integer>> array) {
        return array.stream().flatMap(List::stream).collect(Collectors.toList());
    }
}
