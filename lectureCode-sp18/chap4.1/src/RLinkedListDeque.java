public class RLinkedListDeque<T> extends LinkedListDeque<T>{
  public void rotateRight() {
    this.addFirst(this.removeLast());
  }

  public static void main(String[] args) {
    RLinkedListDeque<Integer> rsl = new RLinkedListDeque<>();
    rsl.addLast(10);
    rsl.addLast(11);
    rsl.addLast(12);
    rsl.addLast(13);
    rsl.rotateRight();
    rsl.print();
  }
}
