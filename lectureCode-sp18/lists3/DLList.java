public class DLList {
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

    public DLList(int n){
        sentinal = new IntNode(null, 42, null);
        sentinal.next = new IntNode(sentinal, 9, null);
        last = sentinal.next;
        size = 1;
    }

    public DLList(){
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

    }

    public void addLast(int n){
        if(sentinal.next != null) {
            last.next = new IntNode(last, n, null);
            last = last.next;
        }else{
            addFirst(n);
        }
        size += 1;
    }

    public void removeLast(){

    }

    public static void main(String[] args){
//        DLList D = new DLList(9);
        DLList D = new DLList();
        D.addLast(9);
        D.addFirst(8);
        D.addLast(10);
        D.addFirst(7);
        D.addFirst(6);

    }
}
