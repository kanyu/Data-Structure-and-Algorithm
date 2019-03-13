import java.util.Iterator;
import java.util.LinkedList;

public class appIter {
  public static void main(String[] args) {
    LinkedList<String> animals = new LinkedList<String>();
    animals.add("Fox");
    animals.add("Cat");
    animals.add("Dog");
    animals.add("Rabbit");
    Iterator<String> it = animals.iterator();
    while (it.hasNext()) {
      String animal = it.next();
      System.out.println(animal);
    }
    /// Modern iteration, Java 5 ++
    for (String ani: animals) {
      System.out.println(ani);
    }
  }
}
