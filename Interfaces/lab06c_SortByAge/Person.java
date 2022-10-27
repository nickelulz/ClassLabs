public class Person implements Comparable<Person> {
  private int year;
  private int month;
  private int day;
  private String name;

  public Person(int y, int m, int d, String n) {
    this.year = y;
    this.month = m;
    this.day = d;
    this.name = n;
  }

  public int compareTo(Person other) {
    if (this.year != other.year)
      return other.year - this.year;
    if (this.month != other.month)
      return other.month - this.month;
    if (this.day != other.day)
      return other.day - this.day;
    return this.name.compareTo(other.name);
  }

  public String toString() {
     return String.format("%6s\tDOB:%d-%2d-%2d\n", name, year, month, day);
  }
}