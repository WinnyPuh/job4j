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
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[array.length - i - 1];
        }
        return result;
    }
}
