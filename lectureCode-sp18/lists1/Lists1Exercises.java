public class Lists1Exercises {
    /** Returns an IntList identical to L, but with
      * each element incremented by x. L is not allowed
      * to change. */
    public static IntList incrList(IntList L, int x) {
        /* Your code here. */
        if (L.rest == null){
          L = new IntList((L.first + x), null);
        }else{
          L = new IntList((L.first + x), incrList(L.rest, x));
        }
        return L;
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. Not allowed to use
      * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        /* Your code here. */
        if(L.rest == null){
          L.first += x;
        }else{
          L.first += x;
          dincrList(L.rest, x);
        }
        return L;
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(7, null);
        L.rest.rest = new IntList(9, null);

        System.out.println(L.size());
        System.out.println(L.iterativeSize());

        // Test your answers by uncommenting. Or copy and paste the
        // code for incrList and dincrList into IntList.java and
        // run it in the visualizer.
        // System.out.println(L.get(1));
        // System.out.println(incrList(L, 3));
        System.out.printf("L: %s, %s, %s\n", L.get(0), L.get(1), L.get(2));

        IntList K = incrList(L, 3);
        System.out.printf("K incrList: %s, %s, %s\n", K.get(0), K.get(1), K.get(2));

        IntList J = dincrList(L, 3);
        System.out.printf("J dincrList: %s, %s, %s", J.get(0), J.get(1), J.get(2));
        // System.out.println(dincrList(L, 3));
    }
}
