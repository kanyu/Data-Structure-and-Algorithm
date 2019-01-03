import java.util.Objects;

/**
 * An MySLList is a list of integers, which hides the terrible truth
 */
public class MySLList {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MySLList mySLList = (MySLList) o;
        return counter == mySLList.counter &&
                Objects.equals(sentinal, mySLList.sentinal) &&
                Objects.equals(last, mySLList.last);
    }

    @Override
    public String toString() {
        return "MySLList{" +
                "sentinal=" + sentinal +
                ", counter=" + counter +
                ", last=" + last +
                '}';
    }

    public static class IntNode {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IntNode intNode = (IntNode) o;
            return item == intNode.item &&
                    Objects.equals(next, intNode.next);
        }

        @Override
        public String toString() {
            return "IntNode{" +
                    "item=" + item +
                    ", next=" + next +
                    '}';
        }

        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    /**
     * The sentinal (dummy humpty node) always be there to help the MySLList more consistent
     * The first item (if it exists) is at sentinal.next
     */
    private IntNode sentinal;
    private int counter;
    private IntNode last;

    // MySLList Constructor
    public MySLList(int x) {
        counter = 1;
        sentinal = new IntNode(42, null);
        sentinal.next = new IntNode(x, null);
        last = sentinal.next;
    }

    // Empty MySLList Constructor
    public MySLList() {
        counter = 0;
        sentinal = new IntNode(42, null);
        last = sentinal.next;
    }

    // MySLList from array Constructor
    public MySLList(int[] s) {
        counter = 0;
        int i = s.length - 1;
        sentinal = new IntNode(42, null);
        last = sentinal.next;
        while (i >= 0) {
            this.addFirst(s[i]);
            i -= 1;
        }
    }

    // Return first item
    public int getFirst() {
        return sentinal.next.item;
    }

    // Add item to become the first
    public void addFirst(int n) {
        sentinal.next = new IntNode(n, sentinal.next);
        counter += 1;
    }

    // delete first element
    public void deleteFirst() {
        sentinal.next = sentinal.next.next;
        counter -= 1;
    }

    // Add item to the last of the list.
    // Iterative method
    public void addLast(int n) {
        counter += 1;
        last.next = new IntNode(n, null);
        last = last.next;
    }

    public int getLast() {
        return last.item;
    }

    public void removeLast() {
    }

    // Size of MySLList
    public int size() {
        return counter;
    }

    public int smallest() {
        IntNode p = sentinal.next;
        int smallest = p.item;
        while (p != null) {
            if (p.item < smallest) {
                smallest = p.item;
            }
            p = p.next;
        }
        return smallest;
    }

    public static void main(String[] args) {
        // Creates a list of one integer, namely 10
        int[] intArray = new int[]{6, 4, 3, 2, 3, 2, 2, 5, 999};
        MySLList L = new MySLList(intArray);
        System.out.println(L.smallest());
//    L.addFirst(5);
//    L.addFirst(8);
//    L.addLast(20);
//    L.addLast(26);
//    L.addLast(27);
//    System.out.println(L.toString());
//    System.out.println(L.size());
//    System.out.println(L.getFirst());
//    System.out.println(L.getLast());
//    L.deleteFirst();
//    System.out.println(L.getFirst());
        // L.deleteFirst();
        // System.out.println(L.getFirst());
        // System.out.println(L.fastSize());
    }
}
