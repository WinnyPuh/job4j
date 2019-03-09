package ru.job4j.loop;

/**
 * Подсчет суммы чётных чисел в диапазоне[#116904].
 * @author Jora Abjora.
 * @version $Id$.
 * @since 0.1
 */

public class Counter {

    /**
     * Метод вычисляет сумму чётных чисел в диапазоне.
     * @param start - начало диапазона.
     * @param finish - конец диапазона.
     * @return сумма.
     */
    public int add(int start, int finish) {
        int result = 0;
        for (int i = start; i < finish+1; i++) {
            if (i % 2 == 0) {
                result += i;
            }
        }
        return result;
    }
}
