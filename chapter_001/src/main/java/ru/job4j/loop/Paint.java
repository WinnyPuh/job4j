package ru.job4j.loop;

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
        StringBuilder screen = new StringBuilder();
        int width = height;
        //return screen.toString();

        for (int row = 0; row != height; row++) {
            for (int column = width-1; column != 0; column--) {
                if (row >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            for (int column = 0; column != width; column++) {
                if (row >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }


        return screen.toString();
    }

    /**
     * Метод рисует правсторонний треугольник.
     * @param height - высота треугольника.
     * @return - правосторонний треугольник.
     */
    public String rightTrl(int height) {
        StringBuilder screen = new StringBuilder();
        int width = height;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != width; column++) {
                if (row >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

    /**
     * Метод рисует левосторонний треугольник.
     * @param height - высота треугольника.
     * @return - левосторонний треугольник.
     */
    public String leftTrl(int height) {
        StringBuilder screen = new StringBuilder();
        int width = height;
        for (int row = 0; row != height; row++) {
            for (int column = width-1; column >= 0; column--) {
                if (row >= column) {
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
