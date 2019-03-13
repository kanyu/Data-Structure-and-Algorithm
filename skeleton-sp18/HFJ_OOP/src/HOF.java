import java.util.Comparator;
public class HOF {
  public static Comparable max(Comparable[] items) {
    int maxDex = 0;
    for (int i = 0; i < items.length; i += 1) {
      int cmp = items[i].compareTo(items[maxDex]);
      if (cmp > 0) {
        maxDex = i;
      }
    }
    return items[maxDex];
  }

  public static void main(String[] args) {
    Dog[] dogs = {new Dog("Elyse", 3), new Dog("Sture", 9), new Dog("Benjamin", 15)};
    Dog maxDog = (Dog) max(dogs);
    maxDog.bark();

    Comparator<Dog> nc = Dog.getNameComparator();
    if (nc.compare(dogs[1], dogs[2]) > 0) {
      dogs[1].bark();
    } else {
      dogs[2].bark();
    }
  }
}
