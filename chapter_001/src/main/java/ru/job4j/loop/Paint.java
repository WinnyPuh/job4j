package ru.job4j.loop;

import java.util.function.BiPredicate;
/**
 * 5.4. Построить пирамиду в псевдографике.[#116907].
 * @author Jora Abjora.
 * @version $Id$.
 * @since 0.1
 */
public class Paint {
    /**
     * Метод рисует пирамиду из символа ^ и пробелов.
     * @param height - высота.
     * @return - пирамида.
     */
    public String piramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }

    /**
     * Метод рисует правсторонний треугольник.
     * @param height - высота треугольника.
     * @return - правосторонний треугольник.
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }

    /**
     * Метод рисует левосторонний треугольник.
     * @param height - высота треугольника.
     * @return - левосторонний треугольник.
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }

    private String loopBy(int height, int width, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != width; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
