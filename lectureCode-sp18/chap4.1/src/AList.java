/**
 * Array based list.
 *
 * @author Josh Hug
 */

public class AList<T> {
  /**
   * Creates an empty list.
   */
  private T[] items;
  private int size;
  private int rFactor = 2;

  public AList() {
    size = 0;
    items = (T[]) new Object[100];

  }

  /**
   * Inserts X into the back of the list.
   */
  private void resize(int capaciy) {
    T[] tempA = (T[]) new Object[capaciy];
    System.arraycopy(items, 0, tempA, 0, size);
    items = tempA;
  }

  public void addLast(T x) {
    if (size == items.length) {
      resize(size * rFactor);
    }
    size += 1;
    items[size - 1] = x;
  }

  /**
   * Returns the item from the back of the list.
   */
  public T getLast() {
    return items[size - 1];
  }

  /**
   * Gets the ith item in the list (0 is the front).
   */
  public T get(int i) {
    return items[i];
  }

  /**
   * Returns the number of items in the list.
   */
  public int size() {
    return size;
  }

  /**
   * Deletes item from back of the list and
   * returns deleted item.
   */
  public T removeLast() {
    T x = getLast();
    size -= 1;
    return x;
  }
} 