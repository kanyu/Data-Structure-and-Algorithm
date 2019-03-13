public class SList<T> {
  public class IntNode {
    private T item;
    private IntNode next;

    public IntNode(T n, IntNode f) {
      item = n;
      next = f;
    }
  }

  public int size;
  public IntNode sentinal;
  public IntNode last;

  public SList(T n) {
    sentinal = new IntNode(null, null);
    sentinal.next = new IntNode(n, null);
    size = 1;
    last = sentinal.next;
  }

  public void addFirst(T n) {
    sentinal.next = new IntNode(n, sentinal.next);
    size += 1;
    last = sentinal.next.next;
  }

  public T getHelper(int i, IntNode L) {
    if (i == 0) {
      return L.item;
    }
    return getHelper(i - 1, L.next);
  }

  public T get(int n) {
    IntNode L = sentinal.next;
    return getHelper(n, L);
  }

  public int size() {
    return size;
  }

  public static void main(String[] args) {
    SList<Integer> S = new SList<>(9);
    S.addFirst(8);
    S.addFirst(7);
    S.addFirst(6);
    System.out.printf("%s, %s, %s, %s", S.get(0), S.get(1), S.get(2), S.get(3));
  }
}
