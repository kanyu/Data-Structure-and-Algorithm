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
        nLast = nStart;
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
        int realIndex = userIndex + nStart;
        if(realIndex > items.length - 1) {
            realIndex = realIndex % items.length;
        }
        return items[realIndex];
    }

    public void printDeque(){
        int i = 0;
        while (i < size){
            System.out.printf("%s ", get(i));
            i++;
        }
    }

    public void addFirst(int x){

    }

    public void removeFirst(){

    }

    public void addLast(int x){
        int proposeLast = nLast + 1;
        if(proposeLast > items.length - 1){
            proposeLast = proposeLast % items.length;
        }
        if(proposeLast != nStart){
            items[nLast] = x;
            nLast = proposeLast;
        }else{
            //resize up
        }
        size += 1;
    }

    public void removeLast(){

    }

    public static void main(String[] args){
        ArrayDeque D = new ArrayDeque();
        D.addLast(4);
        D.addLast(5);
        D.addLast(6);
        D.addLast(7);
        D.addLast(8);
        D.addLast(9);

        System.out.println(D.get(7));
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
