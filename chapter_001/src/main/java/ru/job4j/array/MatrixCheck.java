package ru.job4j.array;

/**
 * 6.7. Квадратный массив заполнен true или false по диагоналям.[#116915].
 * @author Jora Abjora.
 * @version $Id$.
 * @since 0.1
 */
public class MatrixCheck {

    /**
     * Метод проверяет что все элементы по диагоналям равны true или false.
     * @param data - двумерный массив.
     * @return - результат проверки.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;

        for (int i = 1; i < data.length; i++) {
            if (data[0][0] != data[i][i]) {       //проверяем первую диагональ на разные значения
                result = false;
                break;
            }

            if (data[data.length - 1][0] != data[data.length - 1 - i][i]) {
            result = false;
            break;
            }
        }
        return result;
    }
}
