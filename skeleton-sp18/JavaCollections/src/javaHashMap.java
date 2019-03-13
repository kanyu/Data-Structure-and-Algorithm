import java.util.HashMap;
import java.util.Map;

public class javaHashMap { // not order
  public static void main(String[] args) {
    HashMap<Integer, String> hMap = new HashMap<Integer, String>();
    hMap.put(5, "Five");
    hMap.put(8, "Eight");
    hMap.put(6, "Six");
    hMap.put(4, "Four");
    hMap.put(2, "Two");

    String text = hMap.get(4);
    System.out.println(text);

    for (Map.Entry<Integer, String> entry: hMap.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }
}
