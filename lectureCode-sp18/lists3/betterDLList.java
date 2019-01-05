public class betterDLList {
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
    public IntNode sentFront;
    public IntNode sentBack;
    public int size;

    public betterDLList(int n){
        sentFront = new IntNode(null, 42, null);
        sentFront.next = new IntNode(sentFront, n, null);
        sentBack = new IntNode(sentFront.next, 42, null);
        sentFront.next = sentBack;
        size = 1;
    }

    public betterDLList(){
        sentFront = new IntNode(null, -42, null);
        sentBack = new IntNode(sentFront, 42, null);
        sentFront.next = sentBack;
        size = 0;
    }

    public void addFirst(int n){
        sentFront.next = new IntNode(sentFront, n, sentFront.next);
        sentFront.next.next.prev = sentFront.next;
        size += 1;
    }

    public int getFirst(){
        if(sentFront.next != sentBack) {
            return sentFront.next.item;
        }else{
            System.out.println("Nothing to get");
            return 0;
        }
    }

    public void removeFirst(){
        if(sentFront.next != sentBack) {
            sentFront.next = sentFront.next.next;
            sentFront.next.prev = sentFront;
            size -= 1;
        }else{
            System.out.println("Nothing to remove");
        }
    }

    public void addLast(int n){
        sentBack.prev = new IntNode(sentBack.prev, n, sentBack);
        sentBack.prev.prev.next = sentBack.prev;
        size += 1;
    }

    public int getLast(){
        if(sentFront.next != sentBack) {
            return sentBack.item;
        }else{
            System.out.println("Nothing to get");
            return 0;
        }
    }

    public void removeLast(){
        if(sentFront.next != sentBack) {
            sentBack.prev = sentBack.prev.prev;
            sentBack.prev.next = sentBack;
            size -= 1;
        }else{
            System.out.println("Nothing to remove");
        }
    }

    public static void main(String[] args){
        betterDLList D = new betterDLList();
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
