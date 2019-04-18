package ru.job4j.pseudo;
/**
 * 4. Используя шаблон проектирования - стратегию[#116974].
 * @author Jora Abjora.
 * @version $Id$.
 * @since 0.1
 */
public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++");
        pic.append(System.lineSeparator());
        pic.append("+  +");
        pic.append(System.lineSeparator());
        pic.append("+  +");
        pic.append(System.lineSeparator());
        pic.append("++++");
        pic.append(System.lineSeparator());
        return pic.toString();
    }
}
