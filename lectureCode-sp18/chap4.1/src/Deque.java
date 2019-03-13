public interface Deque<T> {
  public boolean isEmpty();

  public T get(int userIndex);

  public int size();

  public void printDeque();

  public void addFirst(T x);

  public T removeFirst();

  public void addLast(T x);

  public T removeLast();

  default public void print() {
    System.out.println("Im boss");
    for (int i = 0; i < size(); i++) {
      System.out.print(get(i));
      System.out.print(" ");

    }
    System.out.println();
  }
}
