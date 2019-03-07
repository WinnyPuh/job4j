package ru.job4j.condition;

/**
 * Максимум из трех чисел[#116898]
 *
 * @author Jora Abjora.
 * @version $Id$.
 * @since 0.1
 */
public class MultiMax {

    /**
     * Максимум из трех чисел
     * @param first - первое число.
     * @param second - второе число.
     * @param third - третье число.
     * @return - максимальное из трех чисел.
     */
    public int max(int first, int second, int third) {
        Max maxTwo = new Max();
        int result = maxTwo.max(first, second);
        return maxTwo.max(result, third);
    }
}
