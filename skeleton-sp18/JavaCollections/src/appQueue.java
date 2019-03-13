import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class appQueue {
  public static void main(String[] args) {
    Queue<Integer> q1 = new ArrayBlockingQueue<Integer>(3);

    q1.add(10);
    q1.add(3);
    q1.add(8);
    try {
      q1.add(9);
    } catch (IllegalStateException e) {
      System.out.println("Tried to add too many items to the queue.");
    }
    for (Integer val: q1) {
      System.out.println(val);
    }

    Integer val = q1.remove();
  }
}
