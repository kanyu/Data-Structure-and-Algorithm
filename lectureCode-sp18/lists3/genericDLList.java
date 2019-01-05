public class genericDLList<dataType> {
    public class dLNode{
        public dataType item;
        public dLNode next;
        public dLNode prev;

        public dLNode(dLNode pr, dataType x, dLNode nx){
            item = x;
            prev = pr;
            next = nx;
        }
    }
    public dLNode cSentinel;
    public int size;

    public genericDLList(dataType n){
        cSentinel = new dLNode(null, null, null);
        cSentinel.next = new dLNode(cSentinel, n, cSentinel);
        size = 1;
    }

    public genericDLList(){
        cSentinel = new dLNode(null, null, null);
        cSentinel.prev = cSentinel;
        cSentinel.next = cSentinel;
        size = 0;
    }

    public void addFirst(dataType n){
        cSentinel.next = new dLNode(cSentinel, n, cSentinel.next);
        cSentinel.next.next.prev = cSentinel.next;
        size += 1;
    }

    public dataType getFirst(){
        if(cSentinel.next != cSentinel) {
            return cSentinel.next.item;
        }else{
            System.out.println("Empty list!!!");
            return null;
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

    public void addLast(dataType n){
        cSentinel.prev = new dLNode(cSentinel.prev, n, cSentinel);
        cSentinel.prev.prev.next = cSentinel.prev;
        size += 1;
    }

    public dataType getLast(){
        if(cSentinel.prev != cSentinel) {
            return cSentinel.prev.item;
        }else{
            System.out.println("Empty list!!!");
            return null;
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
        genericDLList<Integer> D = new genericDLList<>();
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
