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
    public IntNode get(int i){
        int start = 0;
        IntNode temp = first;
        while((temp != null) && (start < i)){
            temp = temp.next;
            start += 1;
        }
        return temp;
    }

    public void addFirst(int x){
        first = new IntNode(x, first);
        size += 1;
    }

    public void insert(int x, int i){
        if(i == 0){
            addFirst(x);
        }else if(i == size-1){
            IntNode temp = get(i);
            temp.next = new IntNode(x, temp.next);
            size += 1;
        }else{
            IntNode temp = get(i - 1);
            temp.next = new IntNode(x, temp.next);
            size += 1;
        }
    }

    public void print(){
        IntNode printit = first;
        while(printit != null){
            System.out.printf("%s ",printit.item);
            printit = printit.next;
        }
        System.out.println();
    }

//    public void reverse(){
//        int i = 1;
//        IntNode anchor;
//        IntNode rest;
//        while(i <= size){
//            anchor = first;
//            rest = first.next;
//            while(rest.next != null){
//                rest = rest.next;
//            }
//            rest.next = anchor;
//            first = first.next;
//            anchor.next = null;
//            i += 1;
//        }
//    }
    public void reverse(){
        int i = 0;
        while(i <= size){
            insert(get(size-1).item, i);
            size -= 1;
            i += 1;
        }
        IntNode temp = get(size-1);
        temp.next = null;
    }
    private void reverseRecurHelper(int i){

    }

    public void reverseRecur(){

    }

    public int size(){
        return size;
    }

    public static void main(String[] args){
        SLList S = new SLList(8);
        S.addFirst(7);
        S.addFirst(5);
        S.insert(6, 1);
        S.insert(4, 0);
        S.insert(9, 4);
        S.print();
        S.reverse();
        S.print();
    }
}
