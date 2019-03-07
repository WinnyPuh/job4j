package ru.job4j.condition;

/**
 * Максимум из двух чисел.
 * @author Jora Abjora.
 * @version $Id$.
 * @since 0.1
 */
public class Max {
    /**
     * Вычисляет максимум из 2 чисел.
     * @param first первое число.
     * @param second второе число.
     * @return максимальное число.
     */
    public int max(int first, int second) {
        int result = (first >= second) ? first : second;
        return result;
    }
}
