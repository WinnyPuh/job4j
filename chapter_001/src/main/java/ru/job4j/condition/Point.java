package ru.job4j.condition;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Расстояние между точками в системе координат[#116925]
 * @author Jora Abjora
 * @version $Id$
 * @since 0.1
 */

public class Point {
    /**
     * Это поле объекта. Оно доступно только конкретному объекту.
     */
    private int x;
    /**
     * И это поле объекта. Оно доступно только конкретному объекту.
     */
    private int y;

    /**
     * Конструктор, который принимает начальное состояние объекта "точка".
     * @param first координата x.
     * @param second координата y.
     */
    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }
    /**
     * Вычислить расстояние между двумя точками в системе координат.
     * @param that - точка.
     * @return - растояние между точками.
     */
    public double distance(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2));
    }

    public void info() {
        System.out.println(String.format("Point[%s, %s]", this.x, this.y));
    }
}
