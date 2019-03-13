/** Array based list.
 *  @author Josh Hug
 */

public class AList {
    /** Creates an empty list. */
    private int[] items;
    private int size;
    private int rFactor = 2;

    public AList() {
        size = 0;
        items = new int[100];

    }

    /** Inserts X into the back of the list. */
    private void resize(int capaciy){
        int[] tempA = new int[capaciy];
        System.arraycopy(items, 0, tempA, 0, size);
        items = tempA;
    }

    public void addLast(int x) {
        if(size == items.length) {
            resize(size * rFactor);
        }
        size += 1;
        items[size-1] = x;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return items[size-1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public int removeLast() {
        int x = getLast();
        size -= 1;
        return x;
    }
} 