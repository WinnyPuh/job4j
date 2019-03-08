package ru.job4j.loop;

/**
 * 5.3. Построить шахматную доску в псевдографике.[#116908].
 * @author Jora Abjora.
 * @version $Id$.
 * @since 0.1
 */
public class Board {

    /**
     * Метод рисует шахматную доску.
     * @param width - ширина доски.
     * @param height - высота доски.
     * @return - изображение доски.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
