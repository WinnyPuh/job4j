package ru.job4j.condition;

/**
 * Расстояние между точками в системе координат[#116925]
 * @author Jora Abjora
 * @version $Id$
 * @since 0.1
 */

public class Point {
    /**
     * Вычислить расстояние между двумя точками в системе координат.
     * @param x1 - координата х первой точки.
     * @param y1 - координата y первой точки.
     * @param x2 - координата х второй точки.
     * @param y2 - координата y второй точки.
     * @return - растояние между точками.
     */
    public double distance(int x1, int y1, int x2, int y2) {
        double result;
        result = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return result;
    }
}
