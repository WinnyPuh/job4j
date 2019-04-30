package ru.job4j.tracker;
/**
 * 3. Используя класс StubInput написать тесты проверяющие поведение пользователя[#116973].
 * @author Jora Abjora.
 * @version $Id$.
 * @since 0.1
 */
public class MenuOutException extends RuntimeException {
    public MenuOutException(String ex) {
        super(ex);
    }
}
