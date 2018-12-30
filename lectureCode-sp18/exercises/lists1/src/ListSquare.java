public class ListSquare{
    /** create static methods that both take in
     an IntList L and return an IntList with its integer values all squared
     does this non-mutatively and mutatively*/

    public static IntList square(IntList L){
        /** square() non-mutative recursive */
        if(L.rest == null){
            L = new IntList(L.first * L.first, null);
            return L;
        }else{
            L = new IntList(L.first * L.first, square(L.rest));
            return L;
        }
    }

    public static IntList squareIter(IntList L){
        /** square() non-mutative iterative */
        IntList K = L;
        IntList M = new IntList(K.first * K.first, null);
        while(K.rest != null){
            M.rest = new IntList(K.first * K.first, null);
            K = K.rest;
        }
        return M;
    }

//    public static IntList squareMutative(IntList L){
        /** square() mutative recursive */

//    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(7, null);
        L.rest.rest = new IntList(9, null);

        System.out.printf("L: %s, %s, %s\n", L.get(0), L.get(1), L.get(2));

        IntList square = square(L);
        System.out.printf("square: %s, %s, %s\n", square.get(0), square.get(1), square.get(2));

        IntList sqrIter = squareIter(L);
        System.out.printf("squareIter: %s, %s, %s", sqrIter.get(0), sqrIter.get(1), sqrIter.get(2));
    }

}