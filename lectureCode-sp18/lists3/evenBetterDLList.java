public class evenBetterDLList {
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
    public IntNode cSentinel;
    public int size;

    public evenBetterDLList(int n){
        cSentinel = new IntNode(null, 42, null);
        cSentinel.next = new IntNode(cSentinel, n, cSentinel);
        size = 1;
    }

    public evenBetterDLList(){
        cSentinel = new IntNode(null, 42, null);
        cSentinel.prev = cSentinel;
        cSentinel.next = cSentinel;
        size = 0;
    }

    public void addFirst(int n){
        cSentinel.next = new IntNode(cSentinel, n, cSentinel.next);
        cSentinel.next.next.prev = cSentinel.next;
        size += 1;
    }

    public int getFirst(){
        if(cSentinel.next != cSentinel) {
            return cSentinel.next.item;
        }else{
            System.out.println("Empty list!!!");
            return 0;
        }
    }

    public void removeFirst(){
        if(cSentinel.next != cSentinel) {
            cSentinel.next = cSentinel.next.next;
            cSentinel.next.prev = cSentinel;
            size -= 1;
        }else{
            System.out.println("Empty list!!!");
        }
    }

    public void addLast(int n){
        cSentinel.prev = new IntNode(cSentinel.prev, n, cSentinel);
        cSentinel.prev.prev.next = cSentinel.prev;
        size += 1;
    }

    public int getLast(){
        if(cSentinel.prev != cSentinel) {
            return cSentinel.prev.item;
        }else{
            System.out.println("Empty list!!!");
            return 0;
        }

    }

    public void removeLast(){
        if(cSentinel.prev != cSentinel) {
            cSentinel.prev = cSentinel.prev.prev;
            cSentinel.prev.next = cSentinel;
        }else{
            System.out.println("Empty list!!!");
        }
    }

    public static void main(String[] args){
        evenBetterDLList D = new evenBetterDLList();
        D.addLast(9);
        D.addFirst(8);
        D.addLast(10);
        D.addFirst(7);
        D.addFirst(6);
        D.removeFirst();
        D.removeLast();
        D.getFirst();
        D.getLast();

    }
}
