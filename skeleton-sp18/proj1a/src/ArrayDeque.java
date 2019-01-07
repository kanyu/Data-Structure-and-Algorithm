public class ArrayDeque {
    private int[] items;
    private int size;
    private double uFactor = 0.25;

    public ArrayDeque(int n){
        size = 0;
        items = new int[8];
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

    public int get(int i){
        return items[i];
    }

    public void printDeque(){
        int i = 0;
        while (i < size){
            System.out.printf("%s ", items[i]);
        }
    }

    public void addFirst(int x){

    }

    public void removeFirst(){

    }

    public void addLast(int x){

    }

    public void removeLast(){

    }

    public static void main(String[] args){
        ArrayDeque D = new ArrayDeque();
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
