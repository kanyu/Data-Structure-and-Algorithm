/** An MySLList is a list of integers, which hides the terrible truth */
public class MySLList{

  public static class IntNode{
    public int item;
    public IntNode next;

    public IntNode(int i, IntNode n){
      item = i;
      next = n;
    }
  }

/** The sentinal (dummy humpty node) always be there to help the MySLList more consistent
  * The first item (if it exists) is at sentinal.next */
  private IntNode sentinal;
  private int counter;
  private IntNode last;

// MySLList Constructor
  public MySLList(int x){
    counter = 1;
    sentinal = new IntNode(42, null);
    sentinal.next = new IntNode(x, null);
    tail = sentinal.next.next;
  }
// Empty MySLList Constructor
  public MySLList(){
    counter = 0;
    sentinal = new IntNode(42, null);
    // tail = sentinal.next.next;
  }

// MySLList from array Constructor
  public MySLList(int[] s){
    counter = 0;
    int i = s.length - 1;
    sentinal = new IntNode(42, null);
    while(i >= 0){
      this.addFirst(s[i]);
      i -= 1;
    }
  }
// Return first item
  public int getFirst(){
    return sentinal.next.item;
  }

// Add item to become the first
  public void addFirst(int n){
     sentinal.next = new IntNode(n, sentinal.next);
    counter += 1;
  }

// Add item to the last of the list.
  // Iterative method
  public void addLast(int n){
  counter += 1;
  last = new IntNode(n, null);
  last = last.next;
  }

// Size of MySLList

  public int size(){
    return counter;
  }

// delete first element
  public void deleteFirst(){
    sentinal.next = sentinal.next.next;
    counter -= 1;
  }

  public static void main(String[] args){
    // Creates a list of one integer, namely 10
    int[] intArray = new int[]{1, 2, 3, 4, 5};
    MySLList L = new MySLList(intArray);
    // L.addFirst(10);
    // L.addFirst(5);
    // L.addLast(20);
    // L.addLastRecursive(25);
    System.out.println(L.size());
    System.out.println(L.fastSize());
    System.out.println(L.getFirst());
    // L.deleteFirst();
    // System.out.println(L.getFirst());
    // System.out.println(L.fastSize());
  }
}
