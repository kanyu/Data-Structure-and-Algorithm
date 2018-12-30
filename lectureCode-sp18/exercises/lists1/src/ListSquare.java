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
        IntList J = M;
        while(K.rest != null){
            K = K.rest;
            J.rest = new IntList(K.first * K.first, null);
            J = J.rest;
        }
        return M;
    }

    public static IntList squareMutative(IntList L){
        /** square() mutative recursive */
        if(L.rest == null){
            L.first = L.first * L.first;
        }else{
            L.first = L.first * L.first;
            squareMutative(L.rest);
        }
        return L;
    }

    public static IntList squareMutativeIter(IntList L){
        /** square() mutative Iterative */
        IntList T = L;
        while(T != null){
            T.first *= T.first;
            T = T.rest;
        }
        return L;
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(7, null);
        L.rest.rest = new IntList(9, null);

        System.out.printf("L before: %s, %s, %s\n", L.get(0), L.get(1), L.get(2));
        IntList square = square(L);
        System.out.printf("square(L): %s, %s, %s\n", square.get(0), square.get(1), square.get(2));
        System.out.printf("L after: %s, %s, %s\n", L.get(0), L.get(1), L.get(2));

        IntList sqrIter = squareIter(L);
        System.out.printf("squareIter(L): %s, %s, %s, %s\n", sqrIter.size(), sqrIter.get(0), sqrIter.get(1), sqrIter.get(2));
        System.out.printf("L after: %s, %s, %s\n", L.get(0), L.get(1), L.get(2));

        IntList squareMutative = squareMutative(L);
        System.out.printf("squareMutative(L): %s, %s, %s\n", squareMutative.get(0), squareMutative.get(1), squareMutative.get(2));
        System.out.printf("L after: %s, %s, %s\n", L.get(0), L.get(1), L.get(2));

        IntList squareMutativeIter = squareMutativeIter(L);
        System.out.printf("squareMutative(L): %s, %s, %s\n", squareMutativeIter.get(0), squareMutativeIter.get(1), squareMutativeIter.get(2));
        System.out.printf("L after: %s, %s, %s\n", L.get(0), L.get(1), L.get(2));
    }

}