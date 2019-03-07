package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test.
 * @author Jora Abjora
 * @version $Id$
 * @since 0.1
 */
public class DummyBotTest {

    @Test
    public void whenGreetBot() {
        DummyBot dummyBot = new DummyBot();
        String result = dummyBot.answer("Привет, Бот.");
        assertThat(result, is("Привет, умник."));
    }

    @Test
    public void whenByeBot() {
        DummyBot bot = new DummyBot();
        assertThat(
                bot.answer("Пока."),
                is("До скорой встречи.")
        );
    }

    @Test
    public void whenUnknownBot() {
        DummyBot bot = new DummyBot();
        assertThat(
                bot.answer("Сколько будет 2 + 2?"),
                is("Это ставит меня в тупик. Задайте другой вопрос.")
        );
    }
}