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

  private IntNode first;
  private int counter;

  public SLList(int x){
    counter = 1;
    first = new IntNode(x, null);
  }
  public SLList(){
    counter = 0;
    first = null;
  }
// Return first item
  public int getFirst(){
    return first.item;
  }

// Add item to become the first
  public void addFirst(int n){
    first = new IntNode(n, first);
    counter += 1;
  }

// Add item to the last of the list.
  // Iterative method
  public void addLast(int n){
    counter += 1;
    if(first == null){
      first = new IntNode(n, first);
    }else{
      IntNode Tmp = first;
      while(Tmp.next != null){
        Tmp = Tmp.next;
      }
      Tmp.next = new IntNode(n, null);
    }
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
    addLastHelper(first, n);
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
    return sizeHelper(first);
  }

  public int fastSize(){
    return counter;
  }
  public static void main(String[] args){
    // Creates a list of one integer, namely 10
    SLList L = new SLList(15);
    L.addFirst(10);
    L.addFirst(5);
    L.addLast(20);
    L.addLastRecursive(25);
    System.out.println(L.size());
    System.out.println(L.fastSize());
  }
}
