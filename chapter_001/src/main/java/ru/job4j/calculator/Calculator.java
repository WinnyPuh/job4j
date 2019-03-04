package ru.job4j.calculator;
/**
 * Объект класса {@code Calculator} Суммирует два числа.
 *
 * @author Jora Abjora
 * @version $Id$
 * @since 0.1
 */
public class Calculator {
    /**
     * Метод add получает два значения и складывает их.
     * @param first - первое число.
     * @param second - второе число.
     * @return сумму двух чисел.
     */
     public double add(double first, double second) {
        return first + second;
     }

    /**
     * Метод subtract получает два значения и вычитает их.
     * @param first - первое число.
     * @param second - второе число.
     * @return результат вычитания двух чисел.
     */
    public double subtract(double first, double second) {
        return first - second;
    }

    /**
     * Метод div получает два значения и делит их.
     * @param first - первое число.
     * @param second - второе число.
     * @return результат деления двух чисел.
     */
    public double div(double first, double second) {
        return first / second;
    }

    /**
     * Метод multiple получает два значения и умножает их.
     * @param first - первое число.
     * @param second - второе число.
     * @return результат умножения двух чисел.
     */
    public double multiple(double first, double second) {
        return first * second;
    }
}
