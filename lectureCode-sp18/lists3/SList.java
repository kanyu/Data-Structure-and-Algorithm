public class SList {
    public class IntNode{
        private int item;
        private IntNode next;

        public IntNode(int n, IntNode f){
            item = n;
            next = f;
        }
    }
    public int size;
    public IntNode sentinal;
    public IntNode last;

    public SList(int n){
        sentinal = new IntNode(42, null);
        sentinal.next = new IntNode(n, null);
        size = 1;
        last = sentinal.next;
    }

    public void addFirst(int n){
        sentinal.next = new IntNode(n, sentinal.next);
        size += 1;
        last = sentinal.next.next;
    }

    public int getHelper(int i, IntNode L) {
        if (i == 0) {
            return L.item;
        }
        return getHelper(i - 1, L.next);
    }

    public int get(int n){
        IntNode L = sentinal.next;
        return getHelper(n, L);
    }

    public static void main(String[] args){
        SList S = new SList(9);
        S.addFirst(8);
        S.addFirst(7);
        S.addFirst(6);
        System.out.printf("%s, %s, %s, %s", S.get(0), S.get(1), S.get(2), S.get(3));
    }
}
