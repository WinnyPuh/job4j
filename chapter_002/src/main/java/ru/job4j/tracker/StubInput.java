package ru.job4j.tracker;

import java.util.List;

/**
 * 3. Используя класс StubInput написать тесты проверяющие поведение пользователя[#116973].
 * @author Jora Abjora.
 * @version $Id$.
 * @since 0.1
 */

public class StubInput implements Input {
    /**
     * Это поле содержит последовательность ответов пользователя.
     * Например. Если пользователь
     * хочет выбрать добавление новой заявки ему нужно ввести:
     * 0 - выбор пункта меня "добавить новую заявку".
     * name - имя заявки
     * desc - описание заявки
     * y - выйти из трекера.
     */
    private String[] answers;
    /**
     * Поле считает количество вызовом метода ask.
     * При каждом вызове надо передвинуть указатель на новое число.
     */
    private  int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }
    /**
     * Давайте рассмотрим, как работает этот метод.
     * у нас есть объект в котором содержатся заранее продуманные ответы.
     * При последовательном вызове метода ask нам надо возвращать соответствующие данные.
     * Как если бы мы симулировали поведение пользователя.
     * Для этого при каждом вызове метода ask мы увеличиваем счетчик и
     * при следующем вызове он вернет нам новое значение.
     */
    @Override
    public String ask(String question) {
        return this.answers[this.position++];
    }

    @Override
    public int ask(String question, List<Integer> range) {
        int result = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == result) {
                exist = true;
                break;
            }
        }

        if (!exist) {
            throw new MenuOutException("Out of menu range.");
        }
        return result;
    }
}
