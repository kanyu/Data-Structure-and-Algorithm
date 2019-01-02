/** An SLList is a list of integers, which hides the terrible truth */
public class SLList{

  public static class IntNode{
    public int item;
    public IntNode next;

    public IntNode(int i, IntNode n){
      item = i;
      next = n;
    }
  }

/** The sentinal (dummy humpty node) always be there to help the SLList more consistent
  * The first item (if it exists) is at sentinel.next */
  private IntNode sentinal;
  private int counter;

// SLList Constructor
  public SLList(int x){
    counter = 1;
    sentinal = new IntNode(42, null);
    sentinal.next = new IntNode(x, null);
  }
// Empty SLList Constructor
  public SLList(){
    counter = 0;
    sentinal = new IntNode(42, null);
  }

// SLList from array Constructor
  public SLList(int[] s){
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
    IntNode Tmp =  sentinal;
    while(Tmp.next != null){
      Tmp = Tmp.next;
    }
    Tmp.next = new IntNode(n, null);
  }

  // Recursive methor
  private void addLastHelper(IntNode f, int n){
    if(f.next == null){
      f.next = new IntNode(n, null);
    }else{
      addLastHelper(f.next, n);
    }
  }

  public void addLastRecursive(int n){
    counter += 1;
    addLastHelper(sentinal.next, n);
  }
// Size of SLList
  private static int sizeHelper(IntNode f){
    if(f.next == null){
      return 1;
    }else{
      return 1 + sizeHelper(f.next);
    }
  }
  public int size(){
    return sizeHelper(sentinal.next);
  }

  public int fastSize(){
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
    SLList L = new SLList(intArray);
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
