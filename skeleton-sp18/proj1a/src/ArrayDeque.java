public class ArrayDeque {
    private int[] items;
    private int size;
    private double uFactor = 0.25;
    private int rFactor = 2;
    private int nLast;
    private int nStart;

    public ArrayDeque(){
        size = 0;
        items = new int[8];
        nStart = 0;
        nLast = 1;
    }

    public ArrayDeque(int[] arr){
        items = new int[arr.length + 2];
        System.arraycopy(arr, 0,items,1, arr.length);
        size = arr.length;
        nStart = 0;
        nLast = size + 1;

    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }
    private void copyToNewArray(int length) {
        int[] newArray = new int[length];
        if (nStart < nLast) {
            System.arraycopy(items, nStart + 1, newArray, 1, size);
        }else if(nStart == items.length - 1){
            System.arraycopy(items,0, newArray,1, size);
        }else if(nStart > nLast){
            System.arraycopy(items,nStart + 1, newArray,1,items.length - (nStart + 1));
            System.arraycopy(items,0, newArray,items.length - nStart, nLast);
        }
        nStart = 0;
        nLast = size + 1;
        items = newArray;
    }
    private void resize() {
        double r = (double)size / (double)items.length;
        if (items.length > 8 && r <= 0.25) {
            copyToNewArray(items.length / 2);
        } else if (size == items.length - 2) {
            copyToNewArray(items.length * rFactor);
        }
    }

    public int getRealIndex(int userIndex){
        if(userIndex > size - 1){
            System.out.println("Out of index!!!");
            return 0;
        }
        int realIndex = userIndex + nStart + 1;
        if(realIndex > items.length - 1) {
            realIndex = realIndex % items.length;
        }
        return realIndex;
    }

    public int get(int userIndex){
        return items[getRealIndex(userIndex)];
    }

    //private method to set value to array at [ith]
    private void set(int userIndex, int n){
        items[getRealIndex(userIndex)] = n;
    }

    public void printDeque(){
        if(!isEmpty()) {
            int i = 0;
            while (i < size) {
                System.out.printf("%s ", get(i));
                i++;
            }
        }
        System.out.println();
    }

    public void addFirst(int x){
        resize();
        int propose_nStart = nStart - 1;
        if(propose_nStart < 0){
            propose_nStart = items.length - 1;
        }
        if(propose_nStart != nLast){
            items[nStart] = x;
            nStart = propose_nStart;
            size += 1;
        }
    }

    public void removeFirst(){
        resize();
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
            resize();
            int propose_nLast = nLast + 1;
            if(propose_nLast > items.length - 1){
                propose_nLast = propose_nLast % items.length;
            }
            if(propose_nLast != nStart){
                items[nLast] = x;
                nLast = propose_nLast;
                size += 1;
            }
        }

    }

    public void removeLast(){
        if(!isEmpty()) {
            resize();
            int propose_nLast = nLast - 1;
            if (propose_nLast < 0) {
                propose_nLast = items.length - 1;
            }
            if (propose_nLast != nStart) {
                items[propose_nLast] = 0;
                nLast = propose_nLast;
                size -= 1;
            }
        }
    }

    public static void grow_nStart_lessThan_nLast(){
        int[] test = {1, 2, 3, 4, 5, 6, 7, 8};
        ArrayDeque D = new ArrayDeque(test);
        test = null;
        for(int i = 1; i < 10; i++){
            D.addLast(8+i);
            D.addFirst(-i);
        }
        while (D.size() > 1) {
            D.printDeque();
            D.removeFirst();
            D.removeLast();
        }

    }

    public static void grow_nStart_biggerThan_nLast(){

    }

    public static void shrink_nStart_lessThan_nLast(){

    }

    public static void shrink_nStart_biggerThan_nLast(){

    }

    public static void main(String[] args){
        grow_nStart_lessThan_nLast();
    }
}
