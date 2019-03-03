package ru.job4j.calculate;

/**
 * Объект класса {@code Calculate} выводит на экран "Hello world!".
 *
 * @author Jora Abjora
 * @version $Id$
 * @since 0.1
 */
public class Calculate {
  /**
   * Method main.
   * @param args - args.
   */
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }

  /**
   * Method echo.
   * @param name Your name.
   * @return Echo plus your name.
   */

  public String echo(String name) {
    return "Echo, echo, echo : " + name;
  }
}
