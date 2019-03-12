package ru.job4j.array;

/**
 * 6.2. Перевернуть массив.[#116919].
 * @author Jora Abjora.
 * @version $Id$.
 * @since 0.1
 */
public class Turn {

    /**
     * Метод переварачивает массив.
     * @param array - массив.
     * @return - перевернутый массив.
     */
    public int[] back(int[] array) {
        int len = array.length;
        for (int i = 0; i < len / 2; i++) {
            int temp = array[i];
            array[i] = array[len - i - 1];
            array[len - i - 1] = temp;
        }
        return array;
    }
}
