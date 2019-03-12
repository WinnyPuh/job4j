package ru.job4j.array;

/**
 * 6.3. Массив заполнен true или false[#116914].
 * @author Jora Abjora.
 * @version $Id$.
 * @since 0.1
 */
public class Check {

    /**
     * Метод проверят массив на TRUE.
     * @param data - массив.
     * @return - возвращает TRUE если все елементы в массиве TRUE.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            if(!data[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
