package ru.job4j.stream;

import java.util.Objects;

/**Класс описывает
 * @author Jora Abjora.
 * @version $.
 * @since 0.1
 */
public class Student {
   private int score;

   public Student(int score) {
      this.score = score;
   }

   public int getScore() {
      return score;
   }

   @Override
   public String toString() {
      return "" + score;
   }

   @Override
   public int hashCode() {
      return Objects.hash(score);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
         return false;
      }
      Student student = (Student) obj;
      return score == student.score;
   }
}
