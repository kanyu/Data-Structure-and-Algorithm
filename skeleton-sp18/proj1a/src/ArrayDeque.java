public class ArrayDeque {
    private int[] items;
    private int size;
    private double uFactor = 0.25;
    private int nLast;
    private int nStart;

    public ArrayDeque(){
        size = 0;
        items = new int[8];
        nStart = items.length / 2;
        nLast = nStart + 1;
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }

    public int size(){
        return  size;
    }

    public int get(int userIndex){
        if(userIndex > size - 1){
            System.out.println("Out of index!!!");
            return 0;
        }
        int realIndex = userIndex + nStart + 1;
        if(realIndex > items.length - 1) {
            realIndex = realIndex % items.length;
        }
        return items[realIndex];
    }
    //private method to set value to array at [ith]
    private void set(int userIndex, int n){
        if(userIndex > size - 1){
            System.out.println("Out of index!!!");
        }
        int realIndex = userIndex + nStart + 1;
        if(realIndex > items.length - 1) {
            realIndex = realIndex % items.length;
        }
        items[realIndex] = n;
    }

    public void printDeque(){
        if(!isEmpty()) {
            int i = 0;
            while (i < size) {
                System.out.printf("%s ", get(i));
                i++;
            }
        }
    }

    public void addFirst(int x){
        int propose_nStart = nStart - 1;
        if(propose_nStart < 0){
            propose_nStart = items.length - 1;
        }
        if(propose_nStart != nLast){
            items[nStart] = x;
            nStart = propose_nStart;
            size += 1;
        }else{
            //resize up
            System.out.println("Cant addFirst. Full slot!!!");
        }


    }

    public void removeFirst(){
        if(!isEmpty()) {
            int propose_nStart = nStart + 1;
            if (propose_nStart > items.length - 1) {
                propose_nStart = propose_nStart % items.length;
            }
            if (propose_nStart != nLast) {
                // set first value to zero
//            set(0, 0);
                // it's safe to just use
                items[propose_nStart] = 0;
                nStart = propose_nStart; // change nStart position
                size -= 1;
            }
        }
    }

    public void addLast(int x){
        if(isEmpty()){
            addFirst(x);
        }else{
            int propose_nLast = nLast + 1;
            if(propose_nLast > items.length - 1){
                propose_nLast = propose_nLast % items.length;
            }
            if(propose_nLast != nStart){
                items[nLast] = x;
                nLast = propose_nLast;
                size += 1;
            }else{
                //resize up
                System.out.println("Cant addLast. Full slot!!!");
            }
        }

    }

    public void removeLast(){
        if(!isEmpty()) {
            int propose_nLast = nLast - 1;
            if (propose_nLast < 0) {
                propose_nLast = items.length - 1;
            }
            if (propose_nLast != nStart) {
                items[propose_nLast] = 0;
                nLast = propose_nLast;
                size -= 1;
            } else {
                //do somethin
            }
        }
    }

    public static void main(String[] args){
        ArrayDeque D = new ArrayDeque();
        D.addLast(4);
        D.addLast(5);

        D.addLast(7);
        D.addLast(8);
        D.addLast(9);
        D.addFirst(3);
        D.addFirst(2);
        D.addFirst(1);
        D.addFirst(99);
        D.addLast(6);
        D.removeFirst();
        D.removeFirst();
        D.removeFirst();
        D.removeLast();
        D.removeLast();
        D.removeLast();
        D.addLast(4);
        D.addLast(5);

        D.addLast(7);
        D.addLast(8);
        D.addLast(9);
        D.addFirst(3);
        D.addFirst(2);
        D.addFirst(1);
        D.addFirst(99);
        D.addLast(6);
        System.out.println(D.get(7));
        System.out.println(D.get(0));
        System.out.println(D.get(1));
        System.out.println(D.get(2));
        System.out.println(D.get(3));
        System.out.println(D.get(4));
        System.out.println(D.get(5));
        System.out.println(D.get(6));
        System.out.println(D.get(7));
        System.out.println(D.size());
        D.printDeque();
    }
}
