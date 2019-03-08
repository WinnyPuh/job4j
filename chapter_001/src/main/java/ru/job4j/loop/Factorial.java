package ru.job4j.loop;

/**
 * Создать программу, вычисляющую факториал.[#116905].
 * @author Jora Abjora.
 * @version $Id$.
 * @since 0.1
 */
public class Factorial {

    /**
     * Метод расчитывает факториал от входного параметра.
     * @param n - положительное целое число.
     * @return - факториал от n.
     */
    public int calc(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= i+1;
        }
        return result;
    }
}
