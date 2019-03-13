import java.util.Comparator;

public class Dog implements Comparable<Dog> {
  private int size;
  String name;
  public int getSize() {
    return size;
  }
  public Dog() {

  }
  public Dog(String s, int n) {
    name = s;
    size = n;
  }
  public static Dog maxDog(Dog[] dogs) {
    if (dogs == null || dogs.length == 0) {
      return null;
    }
    Dog maxDog = dogs[0];
    for (Dog d: dogs) {
      if (d.size > maxDog.size) {
        maxDog = d;
      }
    }
    return maxDog;
  }
  private static class NameComparator implements Comparator<Dog> {
    public int compare(Dog a, Dog b) {
      return a.name.compareTo(b.name);
    }
  }
  public static Comparator<Dog> getNameComparator() {
    return new NameComparator();
  }
  /** Return negative if this < o.
   * Return 0 if equal.
   * Return positive if this > o.
   */
  @Override
  public int compareTo(Dog otherDog) {
    return this.size - otherDog.size;
  }
  public void setSize(int s) {
    size = s;
  }
  void bark() {
    if (size > 60) {
      System.out.println("Wooof! Wooof!");
    } else if (size > 14) {
      System.out.println("Ruff ! Ruff!");
    } else {
      System.out.println("Yip! Yip!");
    }
  }
  void bark(int numOfBarks) {
    while (numOfBarks > 0) {
      System.out.println("ruff");
      numOfBarks = numOfBarks - 1;
    }
  }
}
