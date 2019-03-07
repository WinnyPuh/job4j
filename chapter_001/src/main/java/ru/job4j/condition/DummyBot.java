package ru.job4j.condition;

/**
 * Глупый бот.
 * @author Jora Abjora.
 * @version $Id$.
 * @since 0.1
 */

public class DummyBot {

    /**
     * Отвечает на вопрос.
     * @param question вопрос от клиента.
     * @return Ответ.
     */

    public String answer(String question) {
        String result = "Это ставит меня в тупик. Задайте другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            // заменить ... на правильный ответ rsl = "ответ по заданию".
            result = "Привет, умник.";
        } else if ("Пока.".equals(question)) { // заменить ... на проверку, известен ли боту этот вопрос и он знает как на него ответить.
            // заменить ... на правильный ответ rsl = "ответ по заданию".
            result = "До скорой встречи.";
        }
        return result;
    }
}
