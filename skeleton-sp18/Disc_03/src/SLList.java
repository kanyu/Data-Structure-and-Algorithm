public class SLList {
    private class IntNode{
        public int item;
        public IntNode next;
        public IntNode(int item, IntNode next){
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;
    private int size;

    public SLList(int x){
        first = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x){
        first = new IntNode(x, first);
        size += 1;
    }

    public void insert(int x, int p){
        int i = 0;
        IntNode temp = first;
        while((temp != null) && (i < p - 1)){
            temp = temp.next;
            i += 1;
        }
        temp.next = new IntNode(x, temp.next);
        size += 1;
    }

    public void reverse(){
        int i = 1;
        while(i < size){
            IntNode anchor = first;
            IntNode rest = first.next;
            while(rest.next != null){
                rest = rest.next;
            }
            rest.next = anchor;
            first = first.next;
            anchor.next = null;
            i += 1;
        }
    }
    private void reverseRecurHelper(int i){

    }

    public void reverseRecur(){

    }

    public int size(){
        return size;
    }

    public static void main(String[] args){
        SLList S = new SLList(2);
        S.addFirst(7);
        S.addFirst(5);
        S.insert(6, 1);
        S.addFirst(4);
        S.addFirst(3);
        S.addFirst(2);
        S.addFirst(1);
        S.addFirst(0);
        S.reverse();
    }
}
