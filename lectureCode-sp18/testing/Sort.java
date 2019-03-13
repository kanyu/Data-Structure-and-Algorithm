public class Sort {
        // find min
        // swap
        // sort
    public static int findMin(String[] s, int start){
        int minAtIndex = start;
        for(int i = start; i < s.length; i++){
            int det = s[i].compareTo(s[minAtIndex]);
            if(det < 0){
                minAtIndex = i;
            }
        }
        return  minAtIndex;
    }

    public static void swap(String[] s, int from, int to){
        String temp = s[to];
        s[to] = s[from];
        s[from] = temp;
    }

    public static void sort(String[] s, int start){
    if(start == s.length-1){
        return;
    }
        int minAtIndex = findMin(s, start);
        swap(s, minAtIndex, start );
        sort(s, start+1);
    }

    public static void sort(String[] s){
        sort(s, 0);
    }

}
