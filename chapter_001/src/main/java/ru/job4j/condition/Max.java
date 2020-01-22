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
    /**
     * Вычисляет максимум из 3 чисел.
     * @param first первое число.
     * @param second второе число.
     * @param third третье число.
     * @return максимальное число.
     */
    public int max(int first, int second, int third) {
        int result = max(first, second);
        result = max(result, third);
        return result;
    }
    /**
     * Вычисляет максимум из 4 чисел.
     * @param first первое число.
     * @param second второе число.
     * @param third третье число.
     * @param fourth четвертое число.
     * @return максимальное число.
     */
    public int max(int first, int second, int third, int fourth) {
        int result = max(first, second, third);
        return max(result, fourth);
    }
}
