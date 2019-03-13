public class LinkedListDeque<T> implements Deque<T> {
    private class tNode{
        private T item;
        private tNode next;
        private tNode prev;

        public tNode(tNode pr, T n, tNode nx){
            item = n;
            prev = pr;
            next = nx;
        }
    }

    private int size;
    private tNode cSentinel;

    public LinkedListDeque(T n){
        cSentinel = new tNode(null,null,null);
        cSentinel.next = new tNode(cSentinel, n, cSentinel);
        size = 1;
    }

    public LinkedListDeque(){
        cSentinel = new tNode(null, null, null);
        cSentinel.next = cSentinel;
        cSentinel.prev = cSentinel;
        size = 0;
    }

    public boolean isEmpty(){
        if(cSentinel.next == cSentinel){
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }
    @Override
    public T get(int index){
        T x;
        if(!isEmpty() && (index < size)){
            int i = 0;
            tNode temp = cSentinel.next;
            while((i < index) && (temp.next != cSentinel)){
                temp = temp.next;
                i += 1;
            }
            x = temp.item;
            return x;
        }
        return null;
    }
    @Override
    public void printDeque(){
        System.out.print("Deque list: ");
        if(!isEmpty()){
            tNode temp = cSentinel.next;
            while(temp != cSentinel){
                System.out.printf("%s ",temp.item);
                temp = temp.next;
            }
        }else{
            System.out.print("Empty list!!!");
        }
        System.out.println();
    }
    @Override
    public void addFirst(T x){
        if(isEmpty()){
            cSentinel.next = new tNode(cSentinel, x, cSentinel);
            cSentinel.prev = cSentinel.next;
        }else{
            cSentinel.next = new tNode(cSentinel, x, cSentinel.next);
            cSentinel.next.next.prev = cSentinel.next;
        }
        size += 1;
    }
    @Override
    public T removeFirst(){
        T returner = null;
        if(!isEmpty()){
            tNode temp = cSentinel.next.next;
            returner = cSentinel.next.item;
            // remove any reference of removing tNode
            cSentinel.next.next = null;
            cSentinel.next.prev = null;
            cSentinel.next = temp;
            cSentinel.next.prev = cSentinel;
            size -= 1;
        }
        return returner;
    }
    @Override
    public void addLast(T x){
        if(!isEmpty()){
            cSentinel.prev = new tNode(cSentinel.prev, x, cSentinel);
            cSentinel.prev.prev.next = cSentinel.prev;
        }else{
            cSentinel.next = new tNode(cSentinel, x, cSentinel);
            cSentinel.prev = cSentinel.next;
        }
        size += 1;
    }
    @Override
    public T removeLast(){
        T returner = null;
        if(!isEmpty()){
            tNode temp = cSentinel.prev;
            returner = cSentinel.prev.item;
            cSentinel.prev = cSentinel.prev.prev;
            cSentinel.prev.next = cSentinel;
            // remove any reference of the removing tNode
            temp.next = null;
            temp.prev = null;
            size -= 1;
        }
        return returner;
    }

    public static void main(String[] args){
        LinkedListDeque<Integer> D = new LinkedListDeque<>();
        D.addLast(9);
        D.addFirst(8);
        D.addLast(10);
        D.addFirst(7);
        D.addFirst(6);
        D.removeFirst();
        D.removeLast();
        System.out.println(D.get(0));
        System.out.println(D.size());
        D.printDeque();
    }
}
