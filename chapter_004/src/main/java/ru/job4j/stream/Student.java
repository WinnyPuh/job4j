package ru.job4j.stream;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**Класс описывает
 * @author Jora Abjora.
 * @version $.
 * @since 0.1
 */
public class Student implements Comparable<Student> {
   private String name;
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

   @Override
   public int compareTo(Student student) {
      return this.getScore() - student.getScore();
   }
}
