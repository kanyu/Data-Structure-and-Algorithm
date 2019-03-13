public class Vengeful_LinkedLD<T> extends LinkedListDeque<T>{
  private LinkedListDeque<T> deletedItems;

  public Vengeful_LinkedLD() {
    deletedItems = new LinkedListDeque<T>();
  }
  
  @Override
  public T removeLast() {
    T removedItem = super.removeLast();
    deletedItems.addLast(removedItem);
    return removedItem;
  }
  
  public void printLostItems() {
    deletedItems.print();
  }

  public static void main(String[] args) {
    Vengeful_LinkedLD<Integer> veg = new Vengeful_LinkedLD<>();
    LinkedListDeque<Integer> LLD = new Vengeful_LinkedLD<>();
    veg.addLast(10);
    veg.addLast(11);
    veg.addLast(12);
    veg.addLast(13);
    veg.removeLast();
    veg.removeLast();
    veg.removeLast();
    veg.print();
    veg.printLostItems();
  }
}
