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
        boolean result = false;
        boolean[] array1 = new boolean[data.length];
        boolean[] array2 = new boolean[data.length];
        for (int i = 0; i < data.length; i++) {
            //заполняет массив взачениями по диагонали с верху в низ.
            array1[i] = data[i][i];
            for (int j = 0; j < data.length; j++) {
                if(i + j == data.length - 1) {
                    //заполняет массив взачениями по диагонали с низу в верх.
                    array2[i] = data[i][j];
                }
            }
        }
        Check check = new Check();
        if (check.mono(array1) && check.mono(array2)) {
            result = true;
        }
        return result;
    }
}
