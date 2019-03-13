public class NaiveDLList {
    public static class IntNode{
        public int item;
        public IntNode next;
        public IntNode prev;

        public IntNode(IntNode pr, int x, IntNode nx){
            item = x;
            prev = pr;
            next = nx;
        }
    }
    public IntNode sentinal;
    public int size;
    public IntNode last;
//    public IntNode prev;

    public NaiveDLList(int n){
        sentinal = new IntNode(null, 42, null);
        sentinal.next = new IntNode(sentinal, 9, null);
        last = sentinal.next;
        size = 1;
    }

    public NaiveDLList(){
        sentinal = new IntNode(null, 42, null);
        last = null;
        size = 0;
    }

    public void addFirst(int n){
        if(sentinal.next != null){
            sentinal.next = new IntNode(sentinal, n, sentinal.next);
            sentinal.next.next.prev = sentinal.next;
        }else{
            sentinal.next = new IntNode(sentinal, n, null);
//            sentinal.next.next.prev = sentinal.next;
            last = sentinal.next;
        }
        size += 1;
    }

    public void removeFirst(){
        sentinal.next = sentinal.next.next;
        sentinal.next.prev = sentinal;
        size -= 1;
    }

    public void addLast(int n){
        if(sentinal.next != null) {
            last.next = new IntNode(last, n, null);
            last = last.next;
            size += 1;
        }else{
            addFirst(n);
        }
    }

    public void removeLast(){
        last = last.prev;
        last.next = null;
        size -= 1;

    }

    public static void main(String[] args){
//        NaiveDLList D = new NaiveDLList(9);
        NaiveDLList D = new NaiveDLList();
        D.addLast(9);
        D.addFirst(8);
        D.addLast(10);
        D.addFirst(7);
        D.addFirst(6);
        D.removeFirst();
        D.removeLast();

    }
}
