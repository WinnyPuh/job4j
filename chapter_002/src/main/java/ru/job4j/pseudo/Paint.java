package ru.job4j.pseudo;
/**
 * 4. Используя шаблон проектирования - стратегию[#116974].
 * @author Jora Abjora.
 * @version $Id$.
 * @since 0.1
 */
public class Paint {
    private Shape shape;

    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Triangle());
        paint.draw(new Square());
    }
}
