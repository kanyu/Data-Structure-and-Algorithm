public class IsADemo {
  public static void main(String[] args) {
    Deque<String> someList = new LinkedListDeque<String>();
    someList.addFirst("elk");
    someList.addLast("dwell");
    someList.addLast("on");
    someList.addLast("existential");
    someList.addLast("crises");
    someList.print();
  }
}