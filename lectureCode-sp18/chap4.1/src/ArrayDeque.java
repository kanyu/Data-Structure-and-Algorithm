public class ArrayDeque<T> implements Deque<T> {
  private T[] items;
  private int size;
  private double uFactor = 0.25;
  private int rFactor = 2;
  private int nLast;
  private int nStart;

  public ArrayDeque() {
    size = 0;
    items = (T[]) new Object[8];
    nStart = 0;
    nLast = 1;
  }

  public ArrayDeque(T[] arr) {
    items = (T[]) new Object[arr.length + 2];
    System.arraycopy(arr, 0, items, 1, arr.length);
    size = arr.length;
    nStart = 0;
    nLast = size + 1;

  }

  @Override
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    }
    return false;
  }

  @Override
  public int size() {
    return size;
  }

  private void copyToNewArray(int length) {
    T[] newArray = (T[]) new Object[length];
    if (nStart < nLast) {
      System.arraycopy(items, nStart + 1, newArray, 1, size);
    } else if (nStart == items.length - 1) {
      System.arraycopy(items, 0, newArray, 1, size);
    } else if (nStart > nLast) {
      System.arraycopy(items, nStart + 1, newArray, 1, items.length - (nStart + 1));
      System.arraycopy(items, 0, newArray, items.length - nStart, nLast);
    }
    nStart = 0;
    nLast = size + 1;
    items = newArray;
  }

  private void resize() {
    double r = (double) size / (double) items.length;
    if (items.length > 8 && r <= 0.25) {
      copyToNewArray(items.length / 2);
    } else if (size == items.length - 2) {
      copyToNewArray(items.length * rFactor);
    }
  }

  public int getRealIndex(int userIndex) {
    if (userIndex > size - 1) {
      System.out.println("Out of index!!!");
      return 0;
    }
    int realIndex = userIndex + nStart + 1;
    if (realIndex > items.length - 1) {
      realIndex = realIndex % items.length;
    }
    return realIndex;
  }

  @Override
  public T get(int userIndex) {
    return items[getRealIndex(userIndex)];
  }

  //private method to set value to array at [ith]
  private void set(int userIndex, T n) {
    items[getRealIndex(userIndex)] = n;
  }

  @Override
  public void printDeque() {
    if (!isEmpty()) {
      int i = 0;
      while (i < size) {
        System.out.printf("%s ", get(i));
        i++;
      }
    }
    System.out.println();
  }

  @Override
  public void print() {
    System.out.println("Array: Boss is stupid");
    printDeque();
  }

  @Override
  public void addFirst(T x) {
    resize();
    int propose_nStart = nStart - 1;
    if (propose_nStart < 0) {
      propose_nStart = items.length - 1;
    }
    if (propose_nStart != nLast) {
      items[nStart] = x;
      nStart = propose_nStart;
      size += 1;
    }
  }

  @Override
  public T removeFirst() {
    T returner = null;
    resize();
    if (!isEmpty()) {
      int propose_nStart = nStart + 1;
      if (propose_nStart > items.length - 1) {
        propose_nStart = propose_nStart % items.length;
      }
      if (propose_nStart != nLast) {
        // set first value to zero
//            set(0, 0);
        // it's safe to just use
        returner = items[propose_nStart];
        items[propose_nStart] = null;
        nStart = propose_nStart; // change nStart position
        size -= 1;
      }
    }
    return returner;
  }

  @Override
  public void addLast(T x) {
    if (isEmpty()) {
      addFirst(x);
    } else {
      resize();
      int propose_nLast = nLast + 1;
      if (propose_nLast > items.length - 1) {
        propose_nLast = propose_nLast % items.length;
      }
      if (propose_nLast != nStart) {
        items[nLast] = x;
        nLast = propose_nLast;
        size += 1;
      }
    }

  }

  @Override
  public T removeLast() {
    T returner = null;
    if (!isEmpty()) {
      resize();
      int propose_nLast = nLast - 1;
      if (propose_nLast < 0) {
        propose_nLast = items.length - 1;
      }
      if (propose_nLast != nStart) {
        returner = items[propose_nLast];
        items[propose_nLast] = null;
        nLast = propose_nLast;
        size -= 1;
      }
    }
    return returner;
  }

  public static void grow_nStart_lessThan_nLast() {
    Integer[] test = {1, 2, 3, 4, 5, 6, 7, 8};
    ArrayDeque<Integer> D = new ArrayDeque<>(test);
    test = null;
//        ArrayDeque<Integer> D = new ArrayDeque<>();
    for (int i = 1; i < 10; i++) {
      D.addLast(i);
      D.addFirst(-i);
    }
    while (D.size() > 1) {
      D.printDeque();
      D.removeFirst();
      D.removeLast();
    }

  }

  public static void grow_nStart_biggerThan_nLast() {

  }

  public static void shrink_nStart_lessThan_nLast() {

  }

  public static void shrink_nStart_biggerThan_nLast() {

  }

  public static void main(String[] args) {
    grow_nStart_lessThan_nLast();
  }
}
